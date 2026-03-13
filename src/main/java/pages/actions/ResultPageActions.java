package pages.actions;

import pages.elements.ResultPage;
import utils.UIActions;

public class ResultPageActions {

    public static void closePopUp() {
        UIActions.click(ResultPage.closePopUp);
    }
    public static boolean isResultPageOpen() {
        return UIActions.isDisplayed(ResultPage.resultPage);
    }

    public static void selectRandomBusTrip() {
        UIActions.selectRandomIndex(ResultPage.busTrip);
    }
}
