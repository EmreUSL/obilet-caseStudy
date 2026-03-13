package pages.actions;

import enums.Gender;
import pages.elements.HomePage;
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

    public static void selectSeat() {
        UIActions.selectRandomSeatByGender(ResultPage.seat, Gender.FEMALE);
        UIActions.click(ResultPage.selectedSeat(Gender.FEMALESEAT.getValue()));
    }

    public static String getSelectedSeatPrice() {
        return UIActions.getText(ResultPage.priceValue);
    }

    public static void clickOkButton() {
        UIActions.click(ResultPage.continueButton);
        UIActions.click(ResultPage.selectNoPackage);
    }
}
