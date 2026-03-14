package pages.elements;
import org.openqa.selenium.By;

public class BusResultPage {


    public static final By closePopUp = By.id("close-button-1454703513200");
    public static final By resultPage = By.id("quick-filters-container");
    public static final By busTrip = By.cssSelector("li[class='journey journey-domestic item   ']");
    public static final By seat = By.tagName("a");
    public static By selectedSeat(String gender) {
        return By.cssSelector("button[class='" + gender + " ']");
    }
    public static By priceValue = By.cssSelector("div[class='price ']>span>span");

    public static final By selectedCampaign = By.cssSelector("li[class='journey journey-domestic item open success']");

    public static final By continueButton = By.cssSelector("button>span[class='ready']");

    public static final By selectNoPackage = By.cssSelector("button[class='bf-non-selected']");


}
