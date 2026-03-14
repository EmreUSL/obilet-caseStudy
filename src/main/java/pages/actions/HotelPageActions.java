package pages.actions;

import config.ConfigurationManager;
import pages.elements.HotelPage;
import utils.UIActions;
import utils.WaitActions;



public class HotelPageActions {

    public void selectDestination() {
        WaitActions.waitForClickable(HotelPage.searchButton);
        UIActions.click(HotelPage.whereTo);
        UIActions.type(HotelPage.whereTo , ConfigurationManager.getHotelDestination());
        WaitActions.waitForVisible(HotelPage.container);
        clickSelectedDestination();
    }

    private void clickSelectedDestination() {
        UIActions.click(HotelPage.clickWhereTo);
    }

    public void searchHotel() {
        UIActions.click(HotelPage.searchButton);
    }



}
