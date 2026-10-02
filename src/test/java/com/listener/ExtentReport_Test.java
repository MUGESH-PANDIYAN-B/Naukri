package com.listener;

import com.aventstack.extentreports.ExtentTest;
import com.base.baseSetup;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

public class ExtentReport_Test
{
    public static ExtentTest extentTest;

    public static void extentTestReportStart(){
        baseSetup.extentReportsStart();

}

public static void extentReportsEnd() throws IOException {
        baseSetup.extentReportsEnd();
}
}
