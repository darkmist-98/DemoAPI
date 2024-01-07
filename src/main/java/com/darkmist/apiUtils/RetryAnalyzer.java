package com.darkmist.apiUtils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    private int retryCount = 0;
    private static final int maxRetryCount = 3;

    @Override
    public synchronized boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            System.out.println("Retrying test " + result.getName() +
                    " for the " + (retryCount + 1) +
                    " time(s).");
            retryCount++;
            return true;
        } else {
            System.out.println("Max retries reached for test " + result.getName() +
                    ". Test will be marked as Failed.");
        }
        return false;
    }
}

//    private String getResultStatusName(int status){
//        switch (status){
//            case ITestResult.SUCCESS:
//                return "SUCCESS";
//            case ITestResult.FAILURE:
//                return "FAILURE";
//            case ITestResult.SKIP:
//                return "SKIP";
//            default:
//                return "UNKNOWN";
//        }
//    }
