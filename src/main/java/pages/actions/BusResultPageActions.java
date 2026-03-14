package pages.actions;

import enums.Gender;
import pages.elements.BusResultPage;
import utils.UIActions;
import utils.WaitActions;

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
        WaitActions.waitForVisible(BusResultPage.seat);
        UIActions.selectRandomSeatByGender(BusResultPage.seat, Gender.FEMALE);
        WaitActions.waitForVisible(BusResultPage.genderView);
        UIActions.click(BusResultPage.selectedSeat(Gender.FEMALESEAT.getValue()));
    }

    public String getSelectedSeatPrice() {
        return UIActions.getText(BusResultPage.priceValue);
    }

    public String getOriginLocation() {
        return UIActions.getText(BusResultPage.originLocation);
    }

    public String getDestinationLocation() {
        return UIActions.getText(BusResultPage.destinationLocation);
    }

    public void clickOkButton() {
        UIActions.click(BusResultPage.continueButton);
        UIActions.click(BusResultPage.selectNoPackage);
    }
}
