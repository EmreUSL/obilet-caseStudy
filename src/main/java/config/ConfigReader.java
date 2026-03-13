package config;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class ConfigReader {

    private static final Properties properties = new Properties();

    static {
        try {
            InputStream input =
                    ConfigReader.class
                            .getClassLoader()
                            .getResourceAsStream("config.prop");

            if (input == null) {
                throw new RuntimeException("config.properties file not found");
            }

            properties.load(new InputStreamReader(input, StandardCharsets.UTF_8));
        } catch (Exception e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }

    private ConfigReader() {}

    public static String get(String key) {
        String value = properties.getProperty(key);

        if (value == null) {
            throw new RuntimeException("Property not found: " + key);
        }

        return value.trim();
    }
}
