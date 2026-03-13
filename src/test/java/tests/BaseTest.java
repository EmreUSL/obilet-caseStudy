package tests;
import assertions.VerifyActions;
import config.ConfigurationManager;
import core.driver.DriverManager;
import core.listener.AllureListener;
import org.testng.annotations.*;

@Listeners(AllureListener.class)
public abstract class BaseTest {

    @BeforeMethod
    void setUp() {
       // DriverManager.initDriver();
        DriverManager.getDriver().get(ConfigurationManager.getBaseUrl());
    }

    @AfterMethod
    void tearDown() {
        VerifyActions.assertAll();
        DriverManager.quitDriver();
    }
}
