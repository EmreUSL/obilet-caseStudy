package utils;

import core.driver.DriverManager;
import io.qameta.allure.Attachment;
import org.openqa.selenium.*;

public class AllureStepUtil {

    @Attachment(value = "Step Success - {stepName}", type = "image/png")
    public static void captureStepSuccess(String stepName) {
        WebDriver driver = DriverManager.getDriver();
        ScreenshotUtil.takeScreenshot(driver, stepName); // Dosyaya da kaydediyor
        ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "Step Failure - {stepName}", type = "image/png")
    public static void captureStepFailure(String stepName) {
        WebDriver driver = DriverManager.getDriver();
        ScreenshotUtil.takeScreenshot(driver, stepName + "_fail");
        ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    // Highlight success element
    public static void highlightSuccess(WebDriver driver, WebElement element) {
        if (element != null) {
            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].style.border='3px solid green'", element);
        }
    }

    // Highlight fail element
    public static void highlightFailure(WebDriver driver, WebElement element) {
        if (element != null) {
            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].style.border='3px solid red'", element);
        }
    }
}
