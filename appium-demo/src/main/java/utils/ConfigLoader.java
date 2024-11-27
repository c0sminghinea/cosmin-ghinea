package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {
    private static final Properties properties;

    static {

        try (InputStream input = ConfigLoader.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new RuntimeException("config.properties file not found in the classpath");
            }

            properties = new Properties();
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties file", e);
        }
    }

    public static String getProperty(String key, String number) {
        return properties.getProperty(key);
    }
}
