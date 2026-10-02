package com.listener;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.observer.entity.MediaEntity;
import com.base.baseSetup;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class ITestListenersClass extends baseSetup implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        ExtentReport_Test.extentTest=baseSetup.extentReports.createTest(result.getMethod().getMethodName()+"Test Start");

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        try {
            ExtentReport_Test.extentTest.pass(result.getMethod().getMethodName()+": Test Pass",
                    MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        try {
            ExtentReport_Test.extentTest.fail(result.getMethod().getMethodName(),
                    MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            ExtentReport_Test.extentReportsEnd();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
    }

    @Override
    public void onStart(ITestContext context) {
        ExtentReport_Test.extentTestReportStart();
    }

    @Override
    public void onFinish(ITestContext context) {
        try {
            ExtentReport_Test.extentReportsEnd();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
