package com.pageObjectModel;

import com.base.baseSetup;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class NaukriDashBoard {
    public NaukriDashBoard(){
        PageFactory.initElements(baseSetup.driver, this);
    }
    @FindBy(xpath = "//div[@title=\"MUGESH PANDIYAN B\"]")
    private WebElement MUGESH_PANDIYANB;
public WebElement getMUGESH_PANDIYANB(){
    return MUGESH_PANDIYANB;
}
@FindBy(xpath="//a[@class=\"nI-gNb-header__logo nI-gNb-company-logo\"]")
    private WebElement logo;
public void clickLogo(){
    logo.click();
}
@FindBy(xpath = "//div[@class=\"tab-wrapper\"]")
    private List <WebElement> tabWrapper;
@FindBy(xpath = "//div[@class=\"ni-citem\"]")
private List<WebElement> niCitem;
public void clickTabWrapper(){
    List <WebElement> tabWrapperList=new ArrayList<>(tabWrapper);
    int tabWrapperSize=tabWrapperList.size();
    System.out.println(tabWrapperSize);
    for(WebElement element:tabWrapperList){

       String tabWrapperAttributes= element.getAttribute("class");
       Boolean interActionCheck=element.isDisplayed()&& element.isEnabled();
       System.out.println("Wrapper are: "+interActionCheck);
       System.out.println(tabWrapperAttributes);
        element.click();
        List<WebElement> niCitemList=new ArrayList<>(niCitem);
        System.out.println(niCitemList.size());

    }

}
}
