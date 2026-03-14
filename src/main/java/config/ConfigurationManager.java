package config;

import core.driver.BrowserType;

public class ConfigurationManager {

    private ConfigurationManager() {}

    public static BrowserType getBrowser() {
        String browser = ConfigReader.get(ConfigKeys.BROWSER.getKey());
        return BrowserType.valueOf(browser.toUpperCase());
    }

    public static String getBaseUrl() {
        return ConfigReader.get(ConfigKeys.BASE_URL.getKey());
    }

    public static boolean isHeadless() {
        return Boolean.parseBoolean(ConfigReader.get(ConfigKeys.HEADLESS.getKey()));
    }

    public static String getFromDestination() { return ConfigReader.get(ConfigKeys.FROM.getKey()); }

    public static String getToDestination() { return ConfigReader.get(ConfigKeys.TO.getKey()); }

    public static String getHotelDestination() { return ConfigReader.get(ConfigKeys.HOTELDESTINATON.getKey());}


}
