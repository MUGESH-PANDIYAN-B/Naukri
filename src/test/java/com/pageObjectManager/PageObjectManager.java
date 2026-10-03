package com.pageObjectManager;

import com.base.baseSetup;
import com.pageObjectModel.DataDrivenLoginPage;
import com.pageObjectModel.LoginPage;
import com.pageObjectModel.NaukriDashBoard;
import com.pageObjectModel.RegisterPage;
import com.utility.FileReaderManager;

import static javax.swing.plaf.basic.BasicHTML.propertyKey;

public class PageObjectManager {

    public static PageObjectManager pageObjectManager;
    public static LoginPage loginPage;
    private RegisterPage registerPage;
private baseSetup baseSetup;
    private NaukriDashBoard naukriDashBoard;
    private static FileReaderManager fileReaderManager;
private static DataDrivenLoginPage dataDrivenLoginPage;
    public static PageObjectManager getPageObjectManager() {
        if (pageObjectManager == null) {
            pageObjectManager = new PageObjectManager();
        }
        return pageObjectManager;
    }

    public static LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }

    public RegisterPage getRegisterPage() {
        if (registerPage == null) {
            registerPage = new RegisterPage();
        }
        return registerPage;
    }
    public baseSetup getBaseSetup() {
        if (baseSetup == null) {
            baseSetup = new baseSetup();
        }
        return new baseSetup();
    }

        public NaukriDashBoard getDashBoard() {

            if (naukriDashBoard == null) {
                naukriDashBoard = new NaukriDashBoard();
            }

            return naukriDashBoard;

        }
        public static FileReaderManager getFileReaderManger() {
            if (fileReaderManager == null) {
                fileReaderManager = new FileReaderManager();
            }
            return fileReaderManager;
        }
        public static DataDrivenLoginPage getDataDrivenLoginPage() {
            if(dataDrivenLoginPage == null){
                dataDrivenLoginPage=new DataDrivenLoginPage();
            }
            return dataDrivenLoginPage;
        }
        public static void main(String[] args){

        }
}


