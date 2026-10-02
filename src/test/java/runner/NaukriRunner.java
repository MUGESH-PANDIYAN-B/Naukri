package runner;

import com.base.baseSetup;
import com.pageObjectManager.PageObjectManager;
import com.pageObjectModel.NaukriDashBoard;
import org.openqa.selenium.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

    public class NaukriRunner extends baseSetup{
        PageObjectManager pageObjectManager;
@Parameters("browser")
        @BeforeTest
        public void setup() throws IOException {
            Properties prop = new Properties();
            FileInputStream fis = new FileInputStream("D:\\WorkSpace\\Naukri\\src\\main\\resources\\Test.properties");
            prop.load(fis);
            String url = prop.getProperty("url");
    launchBrowser("chrome");
            launchUrl(url);
            pageObjectManager = PageObjectManager.getPageObjectManager();
        }
        @Test(priority = 1)
        public void loginTest() throws InterruptedException {
            pageObjectManager.getLoginPage().enterEmail();
            pageObjectManager.getLoginPage().enterPassword();
            pageObjectManager.getLoginPage().clickLoginButton();
        }
        @AfterClass
        public void tearDown() {
            String title=driver.getTitle();
            System.out.println(title);
PageObjectManager pageObjectManager= PageObjectManager.getPageObjectManager();
WebElement MUGESH_PANDIYANB=pageObjectManager.getDashBoard().getMUGESH_PANDIYANB();
            verifyElementText(MUGESH_PANDIYANB,"MUGESH PANDIYAN B");
pageObjectManager.getDashBoard().clickTabWrapper();
System.out.println("HI"+Thread.currentThread().getId());
            //driver.quit();
        }
}
