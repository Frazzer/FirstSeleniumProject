package com.szendzij.FirstSeleniumProject.pages;

import com.szendzij.FirstSeleniumProject.config.DriverHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage {

    @FindBy(id = "email")
    public WebElement emialInput;
    @FindBy(id = "id_order")
    public WebElement orderReferenctInput;
    @FindBy(id = "message")
    public WebElement messageTextArea;
    @FindBy(id = "submitMessage")
    public WebElement submitBtn;
    @FindBy(css = "#center_column > div > ol > li")
    public WebElement textOfValidationWhenThereIsNoSubject;
    @FindBy(css = "#id_contact > option:nth-child(2)")
    public WebElement selectSubject;
    @FindBy(css = "#center_column > p")
    public WebElement validationMsg;
    @FindBy(id = "fileUpload")
    public WebElement fileUpload;

    public ContactUsPage() {
        PageFactory.initElements(DriverHelper.getDriver(), this);
    }


}

