package assertions;

import org.testng.asserts.SoftAssert;

public class VerifyActions {

    private static final ThreadLocal<SoftAssert> softAssert = ThreadLocal.withInitial(SoftAssert::new);

    public static void verifyTrue(boolean condition, String message) {
        softAssert.get().assertTrue(condition, message);
    }

    public static void verifyFalse(boolean condition, String message) {
        softAssert.get().assertFalse(condition, message);
    }

    public static void verifyEquals(boolean condition, String message) {
        softAssert.get().assertEquals(condition, message);
    }

    public static void assertAll() {
        softAssert.get().assertAll();
        softAssert.remove();
    }
}
