package pages;

import org.openqa.selenium.By;

public class LoginPage {
    public static final By userName = By.name("username");
    public static final By password = By.name("password");
    public static final By loginButton = By.xpath("//button[text()=' Login ']");
    public static final By homePage = By.xpath("//div[@class='oxd-brand-banner']");
}
