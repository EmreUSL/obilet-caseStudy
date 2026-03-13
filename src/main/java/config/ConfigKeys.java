package config;

public enum ConfigKeys {
    BROWSER("browser"),
    BASE_URL("baseUrl"),
    HEADLESS("headless"),
    USERNAME("username"),
    PASSWORD("password");

    private final String key;

    ConfigKeys(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
