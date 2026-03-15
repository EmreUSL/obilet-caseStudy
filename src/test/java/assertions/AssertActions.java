package assertions;

import io.qameta.allure.Allure;
import org.testng.Assert;

public class AssertActions {

    public static void assertTrue(boolean condition, String message) {
        Allure.step(message, () -> {
            Assert.assertTrue(condition, message);
        });
    }

    public static void assertEquals(String actual, String expected, String message) {
        Allure.step(message + " | Actual: " + actual + " Expected: " + expected, () -> {
            Assert.assertEquals(actual, expected, message);
        });
    }

}