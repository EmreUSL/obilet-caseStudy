package tests;

import assertions.AssertActions;
import org.testng.annotations.Test;
import pages.actions.HomePageActions;
import pages.actions.PaymentPageActions;
import pages.actions.BusResultPageActions;

public class BuyBusTicketTest extends BaseTest {

    @Test
    public void searchAndBuyTicketTest() {
        HomePageActions homePage = new HomePageActions();
        PaymentPageActions paymentPage = new PaymentPageActions();
        BusResultPageActions resultPage = new BusResultPageActions();

        homePage.selectLanguage();
        homePage.selectFrom();
        homePage.selectTo();
        homePage.selectDateFromCalendar();
        homePage.search();

        resultPage.closePopUp();
        AssertActions.assertTrue(resultPage.isResultPageOpen(), "Verify result page is opened");
        resultPage.selectRandomBusTrip();
        resultPage.selectSeat();

        String price = resultPage.getSelectedSeatPrice();
        String originLocation = resultPage.getOriginLocation();
        String destinationLocation = resultPage.getDestinationLocation();
        resultPage.clickOkButton();

        AssertActions.assertTrue(paymentPage.isPaymentPageOpened(), "Verify payment page is opened");

        String destinationFrom =  paymentPage.getDestinationFrom();
        String destinationTo =  paymentPage.getDestinationTo();
        String destinationPrice = paymentPage.getDestinationPrice();

        AssertActions.assertEquals(price, destinationPrice, "Verify prices are equal");
        AssertActions.assertEquals(originLocation, destinationFrom, "Verify origin location is correct");
        AssertActions.assertEquals(destinationLocation, destinationTo, "Verify destination location is correct");
    }
}
