package config;

public enum ConfigKeys {
    BROWSER("browser"),
    BASE_URL("baseUrl"),
    HEADLESS("headless"),
    FROM("from"),
    TO("to");

    private final String key;

    ConfigKeys(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
