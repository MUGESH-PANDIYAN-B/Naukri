package runner;

import com.pageObjectManager.PageObjectManager;
import com.pageObjectModel.DataDrivenLoginPage;
import com.utility.ExcelReader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.base.baseSetup.launchBrowser;
import static com.base.baseSetup.launchUrl;
import static com.pageObjectManager.PageObjectManager.pageObjectManager;
import static com.utility.ExcelReader.excelReader;

public class DataDrivenNaukriTest {
    @DataProvider(name = "excelData")
    public static Object[][] getExcelData() throws IOException {
        return excelReader("loginExcelPath", 0);
    }
    @Test(dataProvider = "excelData", dataProviderClass = DataDrivenNaukriTest.class)
    public void dataDrivenNaukriTest(String email, String password) {
        System.out.println("Email: " + email + ", Password: " + password);
        launchBrowser("chrome");
        launchUrl("https://www.naukri.com/nlogin/login");
        DataDrivenLoginPage dataDrivenLoginPage = new DataDrivenLoginPage();
        dataDrivenLoginPage.inputs(email, password);
    }
}
