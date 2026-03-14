package pages.actions;

import config.ConfigurationManager;
import core.driver.DriverManager;
import org.openqa.selenium.WebElement;
import pages.elements.HomePage;
import utils.UIActions;
import utils.WaitActions;

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
        UIActions.click(HomePage.calendarBtn);

        boolean isDateSelect = false;

        while (!isDateSelect) {
            try {
                WebElement month = DriverManager.getDriver().findElement(HomePage.date);
                month.isDisplayed();
                isDateSelect = true;
            } catch (Exception e) {
                UIActions.click(HomePage.changeMonth);
                WaitActions.waitForVisible(HomePage.changeMonth);
            }
        }

        UIActions.click(HomePage.date);



    }

    public void search() {
        UIActions.click(HomePage.searchBtn);
    }

    public void selectHotelPage() {
        UIActions.click(HomePage.selectHotelButton);
    }
}
