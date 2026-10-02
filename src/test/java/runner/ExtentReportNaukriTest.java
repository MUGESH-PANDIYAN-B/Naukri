package runner;

import com.listener.ExtentReport_Test;
import com.listener.ITestListenersClass;
import com.pageObjectManager.PageObjectManager;
import com.pageObjectModel.LoginPage;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.base.baseSetup.*;
import static com.base.baseSetup.takeScreenShot;
import static com.utility.FileReaderManager.fileReaderManager;
@Listeners(com.listener.ITestListenersClass.class)
public class ExtentReportNaukriTest {
    @Test
    public static void naukriLoginTest() throws Exception {
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
