package pages.elements;

import org.openqa.selenium.By;

public class PaymentPage {
    public static final By paymentPage = By.id("pay");
    public static final By destinationFrom = By.cssSelector("tbody > tr:nth-child(2) > td:nth-child(1)");
    public static final By destinationTo = By.cssSelector("tbody > tr:nth-child(2) > td:nth-child(2)");
    public static final By destinationPrice = By.id("amount");
    public static final By packageType = By.cssSelector("div[class='brandedfare-pack standart']");
}
