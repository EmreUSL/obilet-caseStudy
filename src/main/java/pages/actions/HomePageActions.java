package pages.actions;

import config.ConfigurationManager;
import pages.elements.HomePage;
import utils.UIActions;

public class HomePageActions {

    public void selectLanguage()
    {
        UIActions.click(HomePage.selectLanguage);
        UIActions.click(HomePage.acceptCookie);
    }
    public void selectFrom()
    {
        UIActions.click(HomePage.destinationFrom);
        UIActions.type(HomePage.destinationFrom, ConfigurationManager.getFromDestination());
        UIActions.click(HomePage.selectDestinationFrom);
    }

    public void selectTo() {
        UIActions.click(HomePage.destinationTo);
        UIActions.type(HomePage.destinationTo, ConfigurationManager.getToDestination());
        UIActions.click(HomePage.selectDestinationTo);
    }

    public void selectDateFromCalendar() {

    }

    public void search() {
        UIActions.click(HomePage.searchBtn);
    }

    public void selectHotelPage() {
        UIActions.click(HomePage.selectHotelButton);
    }
}
