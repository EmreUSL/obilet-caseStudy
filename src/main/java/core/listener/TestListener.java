package core.listener;
import core.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.AllureStepUtil;
import utils.ScreenshotUtil;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("TEST STARTED: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        AllureStepUtil.captureStepSuccess(result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = DriverManager.getDriver();
        AllureStepUtil.captureStepFailure(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("TEST SKIPPED: " + result.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("[TESTNG FINISH] " + context.getName());
    }
}
