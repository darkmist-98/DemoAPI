package com.darkmist.constants;

import java.io.File;

public final class FrameworkConstants {

    private static final String PROJECT_PATH = System.getProperty("user.dir");
    public static final String RESOURCE_FOLDER_PATH = PROJECT_PATH+ File.separator+"src"+File.separator
            +"test"+File.separator+"resources";
    public static final String CONFIG_PROPERTIES_PATH = RESOURCE_FOLDER_PATH+File.separator
            +"config.properties";
    public static final String JSON_FILE_FOLDER_PATH = PROJECT_PATH+File.separator+"src"+File.separator
            +"main"+File.separator+"java"+File.separator+"com"+File.separator+"darkmist"+File.separator
            +"payloads";
    public static final String EXTENT_REPORT_PATH = PROJECT_PATH+File.separator+"report";
    public static final String LOGO_PATH = PROJECT_PATH+File.separator+"eivf_logo.png";
}
