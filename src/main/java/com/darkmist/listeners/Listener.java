package com.darkmist.listeners;

import com.darkmist.reports.ExtentLogger;
import com.darkmist.reports.ExtentReportConfig;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Arrays;

public class Listener implements ITestListener, ISuiteListener {

    //private static final String MESSAGE = "Test - ";

    @Override
    public void onStart(ISuite suite) {
        ExtentReportConfig.initExtentReport();
    }

    @Override
    public void onFinish(ISuite suite) {
        ExtentReportConfig.flushExtentReport();
    }

    @Override
    public void onTestStart(ITestResult result) {
        String className = result.getMethod().getTestClass().getName();
        ExtentReportConfig.createTest(result.getMethod().getMethodName(), result.getMethod()
                .getDescription());
        ExtentLogger.logInfo(result.getMethod().getMethodName() + " is started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentLogger.pass(result.getMethod().getMethodName() + "<b> is passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentLogger.fail(result.getMethod().getMethodName() + "<b> is failed");
        ExtentLogger.throwable(result);

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentLogger.skip(result.getMethod().getMethodName() + "<b> is skipped");
    }
}
