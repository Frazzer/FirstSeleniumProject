package com.szendzij.FirstSeleniumProject.pages;

import com.szendzij.FirstSeleniumProject.config.DriverHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    @FindBy(className = "login")
    public WebElement loginBtn;
    @FindBy(id = "contact-link")
    public WebElement contactUsMenu;
    @FindBy(css = "#header_logo > a > img")
    public WebElement headerLogo;

    public HomePage() {
        PageFactory.initElements(DriverHelper.getDriver(), this);
    }


}
