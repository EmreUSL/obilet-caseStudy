package core.listener;

import core.driver.DriverManager;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class AllureListener implements ITestListener {

    private static String getTestMethodname(ITestResult result) {
        return result.getMethod().getConstructorOrMethod().getName();
    }

    @Attachment
    public byte[] saveFailureScreenshot(WebDriver driver) {
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "{0}", type = "text/plain")
    public static void saveTextLog(String text) {
    }

    @Override
    public void onStart(ITestContext context) {
        DriverManager.initDriver();
        context.setAttribute("WebDriver", DriverManager.getDriver());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Object instance = result.getInstance();
        WebDriver driver = DriverManager.getDriver();
        if (instance instanceof WebDriver) {
            saveFailureScreenshot(driver);
        }
        saveTextLog("Test Failed");
    }



}
