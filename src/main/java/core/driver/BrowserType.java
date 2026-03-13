package core.driver;

public enum BrowserType {
    CHROME,
    FIREFOX,
    EDGE;

    public static BrowserType fromString(String browser) {
        return BrowserType.valueOf(browser.toUpperCase());
    }
}
