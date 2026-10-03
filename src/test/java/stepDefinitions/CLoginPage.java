package stepDefinitions;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.base.baseSetup;
import com.listener.ExtentReport_Test;
import com.microsoft.schemas.vml.CTFill;
import com.pageObjectManager.PageObjectManager;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;


import java.io.IOException;
import java.util.Base64;

import static com.base.baseSetup.launchUrl;
import static com.base.baseSetup.takeScreenShot;
import static com.listener.ExtentReport_Test.extentTest;
import static com.pageObjectManager.PageObjectManager.pageObjectManager;

public class CLoginPage {
    public static void reportStart(ITestResult result) throws IOException {
        ExtentReport_Test.extentTestReportStart();
        ExtentReport_Test.extentTest=baseSetup.extentReports.createTest(result.getMethod().getMethodName()+"Test Start");
    }

    @Given("User must launch the browser and navigate to the url")
    public void user_must_launch_the_browser_and_navigate_to_the_url() {
        pageObjectManager= pageObjectManager.getPageObjectManager();
        pageObjectManager.getBaseSetup().launchBrowser("chrome");
        String url=pageObjectManager.getFileReaderManger().fileReaderManager("url");
        pageObjectManager.getBaseSetup().launchUrl(url);
    }
    @When("User must enter the valid username in user name field")
    public void user_must_enter_the_valid_username_in_user_name_field() {
        PageObjectManager.getLoginPage().enterEmail();

    }
    @When("User must enter the valid password in the password field")
    public void user_must_enter_the_valid_password_in_the_password_field() {
        pageObjectManager.getLoginPage().enterPassword();
    }
    @When("user must click the login button")
    public void user_must_click_the_login_button() {
        pageObjectManager.getLoginPage().clickLoginButton();
    }
    @Then("user will navigate to the home page")
    public void user_will_navigate_to_the_home_page() {
        WebElement name=baseSetup.driver.findElement(By.xpath("//div[@title=\"MUGESH PANDIYAN B\"]"));
        String actualName=name.getAttribute("title");
        String expectedName="MUGESH PANDIYAN B";
        pageObjectManager.getBaseSetup().waitForPageLoad();
        Boolean as=actualName.equals(expectedName);
            try {
                ITestResult result = null;
                ExtentReport_Test.extentTest.pass(result.getMethod().getMethodName()+": Test Pass",
                        MediaEntityBuilder.createScreenCaptureFromBase64String(takeScreenShot()).build());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

    }

}
