package com.darkmist.reports;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentManager {

    private static final ThreadLocal<ExtentTest> threadLocalExtentTest = new ThreadLocal<>();

    public static ExtentTest getExtentTest(){
        return threadLocalExtentTest.get();
    }

    static void setExtentTest(ExtentTest test){
        threadLocalExtentTest.set(test);
    }

    static void unload(){
        threadLocalExtentTest.remove();
    }
}
