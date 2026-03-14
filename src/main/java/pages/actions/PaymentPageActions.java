package pages.actions;

import pages.elements.PaymentPage;
import utils.UIActions;
import utils.WaitActions;

public class PaymentPageActions {

    public boolean isPaymentPageOpened() {
        return UIActions.isDisplayed(PaymentPage.paymentPage);
    }

    public String getDestinationFrom() {
        return UIActions.getText(PaymentPage.destinationFrom);
    }

    public String getDestinationTo() {
        return UIActions.getText(PaymentPage.destinationTo);
    }

    public String getDestinationPrice() {
        WaitActions.waitForVisible(PaymentPage.packageType);
        return UIActions.getText(PaymentPage.destinationPrice);
    }
}
