package runner;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.base.baseSetup;
import com.listener.ExtentReport_Test;
import com.pageObjectModel.DataDrivenLoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;

import static com.base.baseSetup.*;
import static com.pageObjectManager.PageObjectManager.pageObjectManager;
import static com.utility.ExcelReader.excelReader;

public class DataDrivenNaukriTest {

    @DataProvider(name = "excelData")
    public static Object[][] getExcelData() throws IOException {
        return excelReader("loginExcelPath", 0);
    }
    @Test(dataProvider = "excelData", dataProviderClass = DataDrivenNaukriTest.class)
    public void dataDrivenNaukriTest(String email, String password,Method result) throws IOException {
        System.out.println("Email: " + email + ", Password: " + password);
        launchBrowser("chrome");
        launchUrl("https://www.naukri.com/nlogin/login");

        ExtentReport_Test.extentTest = baseSetup.extentReports.createTest(result.getName() + ": Test Start");
        String mName = result.toString();
        System.out.println("Method: " + mName);
        DataDrivenLoginPage dataDrivenLoginPage = new DataDrivenLoginPage();
        dataDrivenLoginPage.inputs(email, password);



        try {
            WebElement name=baseSetup.driver.findElement(By.xpath("//div[@title=\"MUGESH PANDIYAN B\"]"));
            String actualName=name.getAttribute("title");
            String expectedName="MUGESH PANDIYAN B";
            WebDriverWait wait = new WebDriverWait(baseSetup.driver, Duration.ofSeconds(5));
            WebElement name1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@title=\"MUGESH PANDIYAN B\"]")));
            if (actualName.equals(expectedName)) {

                ExtentReport_Test.extentTest.pass(result.getName() + ": Test Pass",
                        MediaEntityBuilder.createScreenCaptureFromBase64String(takeScreenShot()).build());
          baseSetup.extentReportsEnd();
          driver.quit();
            }
        } catch (Exception e) {
            ExtentReport_Test.extentTest.fail(result.getName() + ": Test Failed",
                    MediaEntityBuilder.createScreenCaptureFromBase64String(takeScreenShot()).build());
            driver.quit();
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }

    }
    @BeforeClass
    public void setupReport() {
        baseSetup.extentReportsStart();
    }
    @AfterClass
    public void tearDownReport() {
        try {
            baseSetup.extentReportsEnd();
        } catch (Exception e) {
            System.out.println("Error saving Extent Report: " + e.getMessage());
        }
    }
}
