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

    public static By genderView = By.cssSelector("div[class='drop-content']");
    public static By priceValue = By.cssSelector("div[class='price ']>span>span");

    public static By originLocation = By.cssSelector("li.journey.journey-domestic.item.open.success > div > div.trip.col > div.route.down > span.origin.location");

    public static By destinationLocation = By.cssSelector("li.journey.journey-domestic.item.open.success > div > div.trip.col > div.route.down > span.destination.location");

    public static final By continueButton = By.cssSelector("button>span[class='ready']");

    public static final By selectNoPackage = By.cssSelector("button[class='bf-non-selected']");


}
