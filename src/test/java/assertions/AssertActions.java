package assertions;

import org.testng.Assert;

public class AssertActions {

    public static void assertTrue(boolean condition, String message) {
        Assert.assertTrue(condition, message);
    }

    public static void assertFalse(boolean condition, String message) {
        Assert.assertFalse(condition, message);
    }

    public static void assertEquals(String actual, String expected, String message) {
        Assert.assertEquals(actual, expected, message);
    }

    public static void assertNotNull(Object object, String message) {
        Assert.assertNotNull(object, message);
    }
}
