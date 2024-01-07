package com.darkmist.reports;

import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.testng.ITestResult;

public final class ExtentLogger {

    public static void pass(String message){
        ExtentManager.getExtentTest().pass(MarkupHelper.createLabel(message, ExtentColor.GREEN));
    }
    public static void fail(String message){
        ExtentManager.getExtentTest().fail(MarkupHelper.createLabel(message, ExtentColor.RED));
    }
    public static void skip(String message){
        ExtentManager.getExtentTest().skip(MarkupHelper.createLabel(message, ExtentColor.YELLOW));
    }
    public static void logInfo(String message){
        ExtentManager.getExtentTest().info(message);
    }
    public static void throwable(ITestResult result){
        ExtentManager.getExtentTest().info(result.getThrowable());
    }
    public static void logRequestBody(String message){
        ExtentManager.getExtentTest().info(MarkupHelper.createLabel("Request Body: ", ExtentColor.ORANGE));
        ExtentManager.getExtentTest().info(MarkupHelper.createCodeBlock(message, CodeLanguage.JSON));
    }
}
