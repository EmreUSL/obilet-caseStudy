package tests;

import assertions.AssertActions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.actions.HomePageActions;
import pages.actions.PaymentPageActions;
import pages.actions.ResultPageActions;

public class BuyBusTicketTest extends BaseTest {

    @Test
    public void searchAndBuyTicket() {
        HomePageActions.selectLanguage();
        HomePageActions.selectFrom();
        HomePageActions.selectTo();
        HomePageActions.search();

        ResultPageActions.closePopUp();
        AssertActions.assertTrue(ResultPageActions.isResultPageOpen(), "Result page is not open");
        ResultPageActions.selectRandomBusTrip();
        ResultPageActions.selectSeat();

        String price = ResultPageActions.getSelectedSeatPrice();
        System.out.println("Price is: " + price);
        ResultPageActions.clickOkButton();

        AssertActions.assertTrue(PaymentPageActions.isPaymentPageOpened(), "Payment page is not opened");

        String destinationFrom =  PaymentPageActions.getDestinationFrom();
        String destinationTo =  PaymentPageActions.getDestinationTo();
        String destinationPrice = PaymentPageActions.getDestinationPrice();

        System.out.println("Destination from is: " + destinationFrom);
        System.out.println("Destination to is: " + destinationTo);
        System.out.println("Destination price is: " + destinationPrice);

        AssertActions.assertEquals(price, destinationPrice, "Prices are not equal");

    }
}
