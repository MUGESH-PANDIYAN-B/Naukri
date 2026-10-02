package runner;

import com.interfaceElement.LoginPageInterFace;
import com.pageObjectManager.PageObjectManager;
import com.pageObjectModel.LoginPage;
import com.utility.FileReaderManager;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;

import static com.base.baseSetup.*;
import static com.utility.FileReaderManager.fileReaderManager;

@Test
public class LoginPageRunner {
@Test
    public static void loginPageTest()   {
        launchBrowser("chrome");
        PageObjectManager manager= PageObjectManager.getPageObjectManager();
        manager.getFileReaderManger().fileReaderManager("loginExcelPath");
    String value=fileReaderManager("loginPageUrl");
        launchUrl(value);
       takeScreenShot();
        LoginPage loginPage = new LoginPage();
        loginPage.enterEmail();
        loginPage.enterPassword();
        takeScreenShot();
        loginPage.clickLoginButton();
        System.out.println("hi"+Thread.currentThread().getId());
    }
}
