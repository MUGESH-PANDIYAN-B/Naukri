package com.base;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.io.File;
import java.time.Duration;
import java.time.format.DateTimeFormatter;

public class baseSetup {
    public static WebDriver driver;

    public static WebDriver launchBrowser(String browserName) {
        try {

            if (browserName.equalsIgnoreCase("chrome")) {
                driver = new ChromeDriver();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            } else if (browserName.equalsIgnoreCase("firefox")) {
                driver = new FirefoxDriver();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            } else if (browserName.equalsIgnoreCase("edge")) {
                driver = new EdgeDriver();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            }
        } catch (Exception e) {
            Assert.fail("Failed to launch browser: " + e.getMessage());
        }
        return driver;
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
            DateTimeFormatter formatter =DateTimeFormatter.ofPattern("ss-mm-HH-dd-MM-yyyy");
            String timeStamp=formatter.format(java.time.LocalDateTime.now());
            File filepath=new File("D:\\WorkSpace\\Naukri\\src\\main\\resources\\screenShot\\screenshot_"+timeStamp+".png");
            File screenshot=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileHandler.copy(screenshot,filepath);
        } catch (Exception e) {
            Assert.fail("Failed to take screenshot: " + e.getMessage());
        }
    }
}


