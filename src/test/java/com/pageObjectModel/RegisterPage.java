package com.pageObjectModel;

import com.base.baseSetup;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.time.Duration;

public class RegisterPage extends baseSetup {

    public RegisterPage() {
        PageFactory.initElements(baseSetup.driver, this);
    }

    @FindBy(xpath = "//input[@placeholder=\"What is your name?\"]")
    private static WebElement nameField;

    public static void enterFullName(String fullName) {
        nameField.sendKeys(fullName);
    }

    @FindBy(xpath = "//input[@placeholder=\"Tell us your Email ID\"]")
    private static WebElement emailField;

    public static void enterEmail(String email) {
        emailField.sendKeys(email);
    }

    @FindBy(xpath = "//input[@id=\"password\"]")
    private static WebElement passwordField;

    public static void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    @FindBy(xpath = "//button[@type=\"submit\"]")
    private static WebElement submitButton;

    public static void clickSubmitButton() {
        submitButton.click();
    }

    @FindBy(xpath = "//input[@placeholder=\"Enter your mobile number\"]")
    private static WebElement mobileField;

    public static void enterMobileNumber(String mobileNumber) {
        mobileField.sendKeys(mobileNumber);
    }

    @FindBy(xpath = "//div[@aria-label=\"I'm experienced.   I have work experience (excluding internships)\"]")
    private static WebElement experienceField;

    public static void selectExperience() {

        experienceField.click();
    }

    @FindBy(xpath = "//input[@id=\"resumeUpload\"]")
    private static WebElement uploadResumeButton;

    public static void clickUploadResumeButton() {
        uploadResumeButton.sendKeys("C:\\Users\\Mugesh Pandiyan B\\Downloads\\Mugesh_Pandiyan_ATS_QA_Resume.pdf");
    }
  @FindBy(xpath = "//button[@class=\"submitbtn resman-btn-primary resman-btn-regular\"]")
    private static WebElement registerButton;
    public static void clickRegisterButton() {
        registerButton.click();
    }
    public static void main(String[] args) throws IOException {
        launchBrowser("chrome");
        launchUrl("https://www.naukri.com/registration/createAccount?othersrcp=23531&gclsrc=aw.ds&&utm_source=google&utm_medium=cpc&utm_campaign=Brand_Core_Exact&gad_source=1&gad_campaignid=23412039063&gbraid=0AAAAADLp3cFtsDKsmlO0GDVsYuJlPeek2&gclid=Cj0KCQjwzsjVBhC3ARIsALnMv4mYdd2yAZe3ykBv9xRn4K78N_9CdmHOnYU2HPDXuYobUue8THwT75YaAmhIEALw_wcB");
        new RegisterPage();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        enterFullName("MUGESH PANDIYAN B");
        takeScreenShot();
        enterEmail("greeninspecters@gmail.com");
        enterMobileNumber("8012651953");
        enterPassword("Lastleaf+");
        selectExperience();
        clickUploadResumeButton();
        takeScreenShot();
        clickRegisterButton();
        takeScreenShot();
    }
}


