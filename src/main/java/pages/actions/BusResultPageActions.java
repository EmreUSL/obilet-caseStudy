package pages.actions;

import enums.Gender;
import pages.elements.BusResultPage;
import utils.UIActions;

public class BusResultPageActions {

    public void closePopUp() {
        UIActions.click(BusResultPage.closePopUp);
    }
    public boolean isResultPageOpen() {
        return UIActions.isDisplayed(BusResultPage.resultPage);
    }

    public void selectRandomBusTrip() {
        UIActions.selectRandomIndex(BusResultPage.busTrip);
    }

    public void selectSeat() {
        UIActions.selectRandomSeatByGender(BusResultPage.seat, Gender.FEMALE);
        UIActions.click(BusResultPage.selectedSeat(Gender.FEMALESEAT.getValue()));
    }

    public String getSelectedSeatPrice() {
        return UIActions.getText(BusResultPage.priceValue);
    }

    public void clickOkButton() {
        UIActions.click(BusResultPage.continueButton);
        UIActions.click(BusResultPage.selectNoPackage);
    }
}
