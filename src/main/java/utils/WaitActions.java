package utils;

import core.driver.DriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;


import java.time.Duration;

public class WaitActions {

    private static final int DEFAULT_TIMEOUT = 10;
    private static final int DEFAULT_POLLING = 500;

    private static Wait<WebDriver> getFluentWait() {
        return new FluentWait<>(DriverManager.getDriver())
                .withTimeout(Duration.ofSeconds(DEFAULT_TIMEOUT))
                .pollingEvery(Duration.ofMillis(DEFAULT_POLLING))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);
    }

    public static WebElement waitForVisible(By locator) {
        return getFluentWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForClickable(By locator) {
        return getFluentWait().until(ExpectedConditions.elementToBeClickable(locator));
    }

}
