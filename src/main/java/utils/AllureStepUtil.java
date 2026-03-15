package utils;

import core.driver.DriverManager;
import io.qameta.allure.Attachment;
import org.openqa.selenium.*;

public class AllureStepUtil {

    @Attachment(value = "Step Success - {stepName}", type = "image/png")
    public static void captureStepSuccess(String stepName) {
        WebDriver driver = DriverManager.getDriver();
        ScreenshotUtil.takeScreenshot(driver, stepName);
        ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "Step Failure - {stepName}", type = "image/png")
    public static void captureStepFailure(String stepName) {
        WebDriver driver = DriverManager.getDriver();
        ScreenshotUtil.takeScreenshot(driver, stepName + "_fail");
        ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
