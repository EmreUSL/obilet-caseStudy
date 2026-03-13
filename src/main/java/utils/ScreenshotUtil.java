package utils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class ScreenshotUtil {

    private static final String SCREENSHOT_PATH = System.getProperty("user.dir") + "/screenshots/";

    public static void takeScreenshot(WebDriver driver, String testName) {
        if (driver == null) return;

        File src = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.FILE);

        File destination = new File(SCREENSHOT_PATH + testName + ".png");

        try {
            Files.createDirectories(destination.getParentFile().toPath());
            Files.copy(src.toPath(), destination.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
