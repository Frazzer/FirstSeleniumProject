package com.szendzij.FirstSeleniumProject.pages;

import com.szendzij.FirstSeleniumProject.config.DriverHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(id = "email")
    public WebElement emailInp;
    @FindBy(id = "passwd")
    public WebElement passwdInp;
    @FindBy(id = "SubmitLogin")
    public WebElement submitLoginBtn;
    @FindBy(css = "#center_column > div.alert.alert-danger > ol > li")
    public WebElement actualTextOfValidation;

    public LoginPage() {
        PageFactory.initElements(DriverHelper.getDriver(), this);
    }

}
