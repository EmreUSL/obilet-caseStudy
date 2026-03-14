package pages.actions;

import pages.elements.HotelPage;
import pages.elements.HotelResultPage;
import utils.UIActions;
import utils.WaitActions;

public class HotelResultPageActions {

    public boolean isHotelResultPageOpened() {
        return UIActions.isDisplayed(HotelResultPage.resultPage);
    }

    public void selectFilter() {
        UIActions.scrollToElement(HotelResultPage.pensionFilter);
        WaitActions.waitForVisible(HotelResultPage.selectFilter);
        UIActions.click(HotelResultPage.selectFilter);
    }

    public void sortResults() {
        UIActions.scrollToElement(HotelResultPage.resultPage);

    }



}
