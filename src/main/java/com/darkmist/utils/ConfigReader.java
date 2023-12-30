package com.darkmist.utils;

import com.darkmist.constants.FrameworkConstants;

import java.io.FileInputStream;
import java.util.Properties;

public final class ConfigReader {

    private static final Properties properties = new Properties();

    static {
        try(FileInputStream fileInputStream = new FileInputStream(FrameworkConstants.CONFIG_PROPERTIES_PATH)){
            properties.load(fileInputStream);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public static String getPropertyValue(String key){
        return properties.getProperty(key);
    }
}
