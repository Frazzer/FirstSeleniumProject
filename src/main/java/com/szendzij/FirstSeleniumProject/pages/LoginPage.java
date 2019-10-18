package com.szendzij.FirstSeleniumProject.pages;

import com.szendzij.FirstSeleniumProject.config.DriverHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(id = "email")
    private WebElement emailInp;
    @FindBy(id = "passwd")
    private WebElement passwdInp;
    @FindBy(id = "SubmitLogin")
    private WebElement submitLoginBtn;
    @FindBy(css = "#center_column > div.alert.alert-danger > ol > li")
    private WebElement actualTextOfValidation;

    public LoginPage() {
        PageFactory.initElements(DriverHelper.getDriver(), this);
    }

    public void enterEmail(String email) { emailInp.sendKeys(email); }
    public void enterPassword(String password) { passwdInp.sendKeys(password); }
    public void clickSubmitBtn() { submitLoginBtn.click(); }
    public String getActualTextOfValidation() {
        return actualTextOfValidation.getText();
    }



}
