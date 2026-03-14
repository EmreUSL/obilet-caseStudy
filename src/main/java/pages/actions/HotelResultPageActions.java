package pages.actions;
import core.driver.DriverManager;
import org.openqa.selenium.WebElement;
import pages.elements.HotelResultPage;
import utils.UIActions;
import utils.WaitActions;

import java.util.ArrayList;
import java.util.List;

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
        UIActions.click(HotelResultPage.sortButton);
        WaitActions.waitForVisible(HotelResultPage.sortHigherToLower);
        UIActions.click(HotelResultPage.sortHigherToLower);
    }

    public boolean isSortedPricesCorrect() {

        WaitActions.waitForVisibleAll(HotelResultPage.sortedPrices);
        List<WebElement> price = DriverManager.getDriver().findElements(HotelResultPage.sortedPrices);
        List<Double> priceList = new ArrayList<>();
        for (WebElement priceText : price) {
            priceList.add(Double.parseDouble(priceText.getText().replace("TL", "")));
        }

        double currentPrice = priceList.get(0);
        for (int i = 1; i < priceList.size(); i++) {
            double nextPrice = priceList.get(i);
            if (currentPrice > nextPrice) {
                return false;
            }
            currentPrice = nextPrice;
        }
        return true;
    }
}
