package com.darkmist.listeners;

import com.darkmist.apiUtils.RetryAnalyzer;
import org.testng.*;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class RetryListener implements IAnnotationTransformer {

    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor,
                          Method testMethod){
        annotation.setRetryAnalyzer(RetryAnalyzer.class);
    }
}
