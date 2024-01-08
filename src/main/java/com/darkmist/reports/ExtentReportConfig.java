package com.darkmist.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.configuration.ViewName;
import com.darkmist.constants.FrameworkConstants;

import java.awt.*;
import java.io.File;
import java.net.InetAddress;
import java.util.Objects;

public final class ExtentReportConfig {

    private static final ExtentSparkReporter sparkReporter = new ExtentSparkReporter(FrameworkConstants
            .EXTENT_REPORT_PATH).viewConfigurer().viewOrder().as(new ViewName[]{ViewName.DASHBOARD,
            ViewName.TEST,ViewName.EXCEPTION}).apply();
    private static ExtentReports extentReports;
    private static String path = FrameworkConstants.LOGO_PATH;
    /**
     * This method to initialize extent report
     */
    public static void initExtentReport(){
        try{
            if (Objects.isNull(extentReports)){
                extentReports = new ExtentReports();
                extentReports.attachReporter(sparkReporter);
                InetAddress ip = InetAddress.getLocalHost();
                String hostName = ip.getHostName();
                extentReports.setSystemInfo("Host Name", hostName);
                extentReports.setSystemInfo("Environment", "Local - Rest Assured");
                extentReports.setSystemInfo("User Name", System.getProperty("user.name"));
                sparkReporter.loadJSONConfig(new File("./src/test/resources/extent-config.json"));

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void createTest(String testCaseName, String description){
        ExtentManager.setExtentTest(extentReports.createTest(testCaseName,
                description));
    }

    /**
     * This method to gather all required things for report
     */
    public static void flushExtentReport(){
        if (Objects.nonNull(extentReports)){
            extentReports.flush();
        }
        ExtentManager.unload();
        try{
            Desktop.getDesktop().browse(new File(FrameworkConstants.EXTENT_REPORT_PATH).toURI());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
