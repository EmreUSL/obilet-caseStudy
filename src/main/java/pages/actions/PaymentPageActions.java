package pages.actions;

import pages.elements.PaymentPage;
import utils.UIActions;

public class PaymentPageActions {

    public static boolean isPaymentPageOpened() {
        return UIActions.isDisplayed(PaymentPage.paymentPage);
    }

    public static String getDestinationFrom() {
        return UIActions.getText(PaymentPage.destinationFrom);
    }

    public static String getDestinationTo() {
        return UIActions.getText(PaymentPage.destinationTo);
    }

    public static String getDestinationPrice() {
        return UIActions.getText(PaymentPage.destinationPrice);
    }
}
