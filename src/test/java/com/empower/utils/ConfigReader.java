package com.empower.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static final Properties properties = new Properties();

    static {
        try (FileInputStream fis = new FileInputStream("src/test/resources/.properties")) {
            properties.load(fis);
        } catch (IOException e) {
            System.err.println("⚠️ config.properties not found. Using System Properties only.");
        }
    }

    public static String get(String key) {
        // Priority 1: System Property (mvn -Dkey=value)
        String value = System.getProperty(key);

        // Priority 2: Config File
        if (value == null || value.isEmpty()) {
            value = properties.getProperty(key);
        }

        return value;
    }

    public static String get(String key, String defaultValue) {
        String value = get(key);
        return (value != null && !value.isEmpty()) ? value : defaultValue;
    }

    public static boolean getBoolean(String key, boolean defaultValue) {
        String value = get(key);
        return (value != null && !value.isEmpty()) ? Boolean.parseBoolean(value) : defaultValue;
    }

    public static int getInt(String key, int defaultValue) {
        String value = get(key);
        try {
            return (value != null && !value.isEmpty()) ? Integer.parseInt(value) : defaultValue;
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }
}
