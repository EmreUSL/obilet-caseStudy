package tests;
import config.ConfigurationManager;
import core.driver.DriverManager;
import org.testng.annotations.*;

public abstract class BaseTest {

    @BeforeMethod
    void setUp() {
        DriverManager.initDriver();
        DriverManager.getDriver().get(ConfigurationManager.getBaseUrl());
        DriverManager.getDriver().manage().window().maximize();
    }

    @AfterMethod
    void tearDown() {
        DriverManager.quitDriver();
    }
}
