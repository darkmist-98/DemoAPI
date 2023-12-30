package com.darkmist.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.darkmist.constants.FrameworkConstants;

import java.awt.*;
import java.io.File;
import java.net.InetAddress;
import java.util.Objects;

public final class ExtentReportConfig {

    private static final ExtentSparkReporter sparkReporter = new ExtentSparkReporter(FrameworkConstants
            .EXTENT_REPORT_PATH);
    private static ExtentReports extentReports;
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
                sparkReporter.config().setDocumentTitle("HTML Report");
                sparkReporter.config().setReportName("API - Rest Assured");
                sparkReporter.config().setTheme(Theme.DARK);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void createTest(String testCaseName){
        ExtentManager.setExtentTest(extentReports.createTest(testCaseName));
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
