package pages.actions;

import config.ConfigurationManager;
import org.openqa.selenium.Keys;
import pages.elements.HomePage;
import utils.UIActions;

public class HomePageActions {

    public static void selectLanguage()
    {
        UIActions.click(HomePage.selectLanguage);
        UIActions.click(HomePage.acceptCookie);
    }
    public static void selectFrom() {
        UIActions.click(HomePage.destinationFrom);
        UIActions.type(HomePage.destinationFrom, ConfigurationManager.getFromDestination());
        UIActions.click(HomePage.selectDestinationFrom);
    }

    public static void selectTo() {
        UIActions.click(HomePage.destinationTo);
        UIActions.type(HomePage.destinationTo, ConfigurationManager.getToDestination());
        UIActions.click(HomePage.selectDestinationTo);
    }

    public static void selectDateFromCalendar() {

    }

    public static void search() {
        UIActions.click(HomePage.searchBtn);
    }
}
