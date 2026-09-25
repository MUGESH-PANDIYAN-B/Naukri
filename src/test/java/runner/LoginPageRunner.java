package runner;

import com.interfaceElement.LoginPageInterFace;
import com.pageObjectModel.LoginPage;

import static com.base.baseSetup.*;

public class LoginPageRunner {
    public static void main(String[] args) {
        launchBrowser("chrome");
        launchUrl("https://www.naukri.com/nlogin/login?srcTemplate=registerfree468x60&utm_source=google&utm_medium=cpc&utm_campaign=Brand&gclsrc=aw.ds&gad_source=1&gad_campaignid=19863995494&gbraid=0AAAAADLp3cGU47m46N5wx1fMEI0Ln8zHv&gclid=Cj0KCQjwlNPVBhCMARIsAPZ5RqhP-dusrQWPxj_tF-8WMTajGSqDV2wF5c2-cqKaQzzHHan9XAg5q58aAmxdEALw_wcB");
       takeScreenShot();
        LoginPage loginPage = new LoginPage();
        loginPage.enterEmail();
        loginPage.enterPassword();
        takeScreenShot();
        loginPage.clickLoginButton();
    }
}
