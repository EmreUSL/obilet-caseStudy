package pages.elements;
import config.ConfigurationManager;
import org.openqa.selenium.By;

public class HomePage {
    public static final By selectLanguage = By.cssSelector("a[data-language='tr-TR']");
    public static final By acceptCookie = By.id("accept");
    public static final By selectHotelButton = By.cssSelector("a[data-event-action='Hotel']");
    public static final By destinationFrom = By.id("origin-input");
    public static final By selectDestinationFrom = By.xpath("//span[@class='location'][contains(text(),'"+ ConfigurationManager.getFromDestination()+"')]/parent::li");
    public static final By selectDestinationTo = By.xpath("//span[@class='location'][contains(text(),'"+ ConfigurationManager.getToDestination()+"')]/parent::li");
    public static final By destinationTo = By.id("destination-input");
    public static final By calendarBtn = By.cssSelector("div[class='departure group']");
    public static final By changeMonth = By.cssSelector("th[class='next']");
    public static final By date  = By.cssSelector("button[data-date='"+ConfigurationManager.getDate()+"']");

    public static final By searchBtn = By.id("search-button");









}
