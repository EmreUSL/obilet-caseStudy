package tests;

import assertions.AssertActions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.actions.HomePageActions;
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

    }
}
