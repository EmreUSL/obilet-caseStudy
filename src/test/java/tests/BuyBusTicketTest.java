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
        homePage.search();

        resultPage.closePopUp();
        AssertActions.assertTrue(resultPage.isResultPageOpen(), "Result page is not open");
        resultPage.selectRandomBusTrip();
        resultPage.selectSeat();

        String price = resultPage.getSelectedSeatPrice();
        System.out.println("Price is: " + price);
        resultPage.clickOkButton();

        AssertActions.assertTrue(paymentPage.isPaymentPageOpened(), "Payment page is not opened");

        String destinationFrom =  paymentPage.getDestinationFrom();
        String destinationTo =  paymentPage.getDestinationTo();
        String destinationPrice = paymentPage.getDestinationPrice();

        System.out.println("Destination from is: " + destinationFrom);
        System.out.println("Destination to is: " + destinationTo);
        System.out.println("Destination price is: " + destinationPrice);

        AssertActions.assertEquals(price, destinationPrice, "Prices are not equal");

    }
}
