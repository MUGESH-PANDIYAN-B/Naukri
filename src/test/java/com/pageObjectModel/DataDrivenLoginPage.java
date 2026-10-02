package com.pageObjectModel;

import com.base.baseSetup;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DataDrivenLoginPage {
    public DataDrivenLoginPage(){
        PageFactory.initElements(baseSetup.driver, this);
    }
    @FindBy(xpath = "//input[@id=\"usernameField\"]")
    protected WebElement eMailField;
    public void inputs(String email, String password){
        eMailField.sendKeys(email);
        passwordField.sendKeys(password);
        loginButton.click();
    }
    @FindBy(xpath = "//input[@id=\"passwordField\"]")
    protected WebElement passwordField;

    @FindBy(xpath = "//button[@class=\"waves-effect waves-light btn-large btn-block btn-bold blue-btn textTransform\"]")
    protected WebElement loginButton;

}
