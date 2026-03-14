package pages.elements;

import config.ConfigurationManager;
import org.openqa.selenium.By;

public class HotelPage {

    public static final By whereTo = By.id("origin-input");
    public static  By clickWhereTo = By.xpath("//li[@class='item' and .//div[@class='origin-name']='"+ ConfigurationManager.getHotelDestination()+"']");
    public static final By container = By.className("results");
    public static final By searchButton = By.cssSelector("button[id='search-button']");
}
