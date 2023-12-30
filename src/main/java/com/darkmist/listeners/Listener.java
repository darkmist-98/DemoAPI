package com.darkmist.listeners;

import com.darkmist.reports.ExtentLogger;
import com.darkmist.reports.ExtentReportConfig;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener, ISuiteListener {

    private static final String MESSAGE = "Test - <b>";

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
        ExtentReportConfig.createTest(result.getMethod().getMethodName());
        ExtentLogger.logInfo(MESSAGE + result.getMethod().getMethodName() + " is started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentLogger.pass(MESSAGE + result.getMethod().getMethodName() + "<b> is passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentLogger.fail(MESSAGE + result.getMethod().getMethodName() + "<b> is failed");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentLogger.skip(MESSAGE + result.getMethod().getMethodName() + "<b> is skipped");
    }
}
