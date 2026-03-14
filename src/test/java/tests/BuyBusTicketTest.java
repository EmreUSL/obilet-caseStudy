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
        AssertActions.assertTrue(resultPage.isResultPageOpen(), "Result page is not open");
        resultPage.selectRandomBusTrip();
        resultPage.selectSeat();

        String price = resultPage.getSelectedSeatPrice();
        String originLocation = resultPage.getOriginLocation();
        String destinationLocation = resultPage.getDestinationLocation();
        resultPage.clickOkButton();

        AssertActions.assertTrue(paymentPage.isPaymentPageOpened(), "Payment page is not opened");

        String destinationFrom =  paymentPage.getDestinationFrom();
        String destinationTo =  paymentPage.getDestinationTo();
        String destinationPrice = paymentPage.getDestinationPrice();

        AssertActions.assertEquals(price, destinationPrice, "Prices are not equal");
        AssertActions.assertEquals(originLocation, destinationFrom, "Origin location are not equal");
        AssertActions.assertEquals(destinationLocation, destinationTo, "Destination location are not equal");
    }
}
