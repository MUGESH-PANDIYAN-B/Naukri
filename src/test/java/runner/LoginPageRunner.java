package runner;

import com.interfaceElement.LoginPageInterFace;
import com.pageObjectManager.PageObjectManager;
import com.pageObjectModel.LoginPage;
import com.utility.FileReaderManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;

import static com.base.baseSetup.*;
import static com.utility.FileReaderManager.fileReaderManager;


@Listeners(com.listener.ITestListenersClass.class)
public class LoginPageRunner {
@Test
    public void loginPageTest() throws IOException {
        launchBrowser("chrome");
        PageObjectManager manager= PageObjectManager.getPageObjectManager();
        manager.getFileReaderManger().fileReaderManager("loginExcelPath");
    String value=fileReaderManager("loginPageUrl");
        launchUrl(value);
       takeScreenShot();
        LoginPage loginPage = new LoginPage();
        loginPage.enterEmail();
        loginPage.enterPassword();
        loginPage.clickLoginButton();
    WebElement name=driver.findElement(By.xpath("//div[@title=\"MUGESH PANDIYAN B\"]"));
    String actualName=name.getAttribute("title");
    Assert.assertEquals(actualName,"MUGESH PANDIYAN B");
        System.out.println("hi"+Thread.currentThread().getId());
    }
}
