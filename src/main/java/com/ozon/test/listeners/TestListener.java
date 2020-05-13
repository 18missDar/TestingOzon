package com.ozon.test.listeners;

import com.ozon.test.settings.ScreenshotMaker;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class TestListener extends TestListenerAdapter {

    @Override
    public void onTestFailure(ITestResult result){
        ScreenshotMaker.takeScreenshot();
    } //
}