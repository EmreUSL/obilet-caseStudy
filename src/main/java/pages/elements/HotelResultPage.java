package pages.elements;

import org.openqa.selenium.By;

public class HotelResultPage {
    public static By resultPage = By.id("searchResultCountContainer");
    public static By pensionFilter = By.id("filterGroup__boardItems");
    public static By selectFilter = By.xpath("//span[@class='filter-item__name'][text()='Yarım Pansiyon ']/preceding-sibling::input");
    public static By sortButton = By.cssSelector("button[class='head-filter__btn']");
    public static By sortHigherToLower = By.cssSelector("button[data-value='price-lowest']");
    public static By sortedPrices = By.cssSelector("div[class='hotel-price__amount']");

}
