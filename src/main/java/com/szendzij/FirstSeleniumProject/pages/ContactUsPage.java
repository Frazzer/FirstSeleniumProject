package com.szendzij.FirstSeleniumProject.pages;

import com.szendzij.FirstSeleniumProject.config.DriverHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;

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

    public void enterEmail(String d) {
        emialInput.sendKeys(d);
    }

    public void enterOrderReference(String d) {
        orderReferenctInput.sendKeys(d);
    }

    public void enterMessage(String d) {
        messageTextArea.sendKeys(d);
    }

    public void clickSubmitBtn() {
        submitBtn.click();
    }

    public void clickSubject() {
        selectSubject.click();
    }

    public String getTextOfValidationWhenThereIsNoSubject() {
        return textOfValidationWhenThereIsNoSubject.getText();
    }

    public String getValidationMsg() {
        return validationMsg.getText();
    }

    public void addAttachment() {
        String testFile = getClass().getClassLoader().getResource("test.txt").getFile();
        fileUpload.sendKeys(new File(testFile).getAbsolutePath());
    }


}

