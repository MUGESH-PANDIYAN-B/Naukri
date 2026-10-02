package runner;

import com.pageObjectManager.PageObjectManager;
import com.pageObjectModel.DataDrivenLoginPage;
import com.utility.ExcelReader;
import org.testng.annotations.Test;

import static com.base.baseSetup.launchBrowser;
import static com.base.baseSetup.launchUrl;
import static com.pageObjectManager.PageObjectManager.pageObjectManager;

public class DataDrivenNaukriTest {
    @Test(dataProvider = "excelData", dataProviderClass = ExcelReader.class)
    public void dataDrivenNaukriTest(String email, String password) {
        System.out.println("Email: " + email + ", Password: " + password);
        launchBrowser("chrome");
        launchUrl("https://www.naukri.com/nlogin/login");
        DataDrivenLoginPage dataDrivenLoginPage = new DataDrivenLoginPage();
        dataDrivenLoginPage.inputs(email, password);
    }
}
