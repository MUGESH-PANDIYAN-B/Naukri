package com.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.format.DateTimeFormatter;

//import static baseSetup.extentReports;

public class baseSetup {
    public static WebDriver driver;
public static ExtentReports extentReports;
public static File file;
    public static ExtentSparkReporter extentSparkReporter;
    public static void launchBrowser(String browserName) {
        try {

            if (browserName.equalsIgnoreCase("chrome")) {
                driver = new ChromeDriver();
                System.out.println("Browser Started");
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
            } else if (browserName.equalsIgnoreCase("firefox")) {
                driver = new FirefoxDriver();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
            } else if (browserName.equalsIgnoreCase("edge")) {
                driver = new EdgeDriver();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
            }
        } catch (Exception e) {
            Assert.fail("Failed to launch browser: " + e.getMessage());
        }
    }
    public static void launchUrl(String url) {
        try {
            driver.get(url);
        } catch (Exception e) {
            Assert.fail("Failed to launch URL: " + e.getMessage());
        }
    }
    public static void closeBrowser() {
        try {
            driver.quit();
        } catch (Exception e) {
            Assert.fail("Failed to close browser: " + e.getMessage());
        }
    }

    public static void inputField(String xpath, String value) {
        try {
            driver.findElement(By.xpath(xpath)).sendKeys(value);
        } catch (Exception e) {
            Assert.fail("Failed to input value: " + e.getMessage());
        }
    }
    public static void clickElement(String xpath) {
        try {
            driver.findElement(By.xpath(xpath)).click();
        } catch (Exception e) {
            Assert.fail("Failed to click element: " + e.getMessage());
        }
    }
    public static void windowHandle() {
        try {
            String parentWindow = driver.getWindowHandle();
            for (String windowHandle : driver.getWindowHandles()) {
                if (!windowHandle.equals(parentWindow)) {
                    driver.switchTo().window(windowHandle);
                }
            }
        } catch (Exception e) {
            Assert.fail("Failed to switch window: " + e.getMessage());
        }
    }
    public static void dropDown(WebElement element,String method,String value)
    {
        try{
            Select selectOptions=new Select(element);
            if(method.equalsIgnoreCase("index"))
            {
                selectOptions.selectByIndex(Integer.parseInt(value));
            } else if (method.equalsIgnoreCase("value)")) {
                selectOptions.selectByValue(value);
            } else if (method.equalsIgnoreCase("visibletext")) {
                selectOptions.selectByVisibleText(value);

            }
        } catch (Exception e) {
            Assert.fail("Failed to select dropdown option: " + e.getMessage());
        }
    }
    public static void alertHandle(String action)
    {
        try{
            if(action.equalsIgnoreCase("accept"))
            {
                driver.switchTo().alert().getText();
                driver.switchTo().alert().accept();
            } else if (action.equalsIgnoreCase("dismiss")) {
                driver.switchTo().alert().getText();
                driver.switchTo().alert().dismiss();
            }
        } catch (Exception e) {
            Assert.fail("Failed to handle alert: " + e.getMessage());
        }

    }
    public static void takeScreenShot()
    {
        try{
            DateTimeFormatter formatter =DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
            String timeStamp=formatter.format(java.time.LocalDateTime.now());
            File filepath=new File("D:\\WorkSpace\\Naukri\\src\\main\\resources\\screenShot\\screenshot_"+timeStamp+".png");
            File screenshot=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileHandler.copy(screenshot,filepath);
        } catch (Exception e) {
            Assert.fail("Failed to take screenshot: " + e.getMessage());
        }

    }
     public static void verifyElementText (WebElement element ,String assertString)
     {
         try{
            String text= element.getAttribute("title");
            System.out.println(text);
             Assert.assertEquals(text,assertString);
         }
         catch (Exception e){
             Assert.fail("Failed to Assert: " + e.getMessage());
         }
     }
     public static void extentReportsStart(String location){
            extentReports= new ExtentReports();
            file=new File(location);
         extentSparkReporter=new ExtentSparkReporter(file);
         extentReports.attachReporter(extentSparkReporter);
         extentReports.setSystemInfo("OS",System.getProperty("os.name"));
         extentReports.setSystemInfo("Java Version",System.getProperty("java.version"));


     }
     public static void extentReportsEnd(String location) throws IOException {
        extentReports.flush();
         file = new File(location);
         Desktop.getDesktop().browse((file).toURI());
     }
}


