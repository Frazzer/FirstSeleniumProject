package com.szendzij.FirstSeleniumProject.pages;

import com.szendzij.FirstSeleniumProject.config.DriverHelper;
import com.szendzij.FirstSeleniumProject.config.WaitHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    @FindBy(className = "login")
    private WebElement loginBtn;
    @FindBy(id = "contact-link")
    private WebElement contactUsMenu;
    @FindBy(css = "#homefeatured > li:nth-child(2)")
    private WebElement blouseElement;
    @FindBy(linkText = "Add to cart")
    private WebElement addToCartBlouseElement;
    @FindBy(linkText = "Proceed to checkout")
    private WebElement proceedBtn;

    public HomePage() {
        PageFactory.initElements(DriverHelper.getDriver(), this);
    }

    public void clickSignIn() {
        loginBtn.click();
    }

    public void clickContactUsMenu() {
        contactUsMenu.click();
    }

    public void clickAddToCartBlouseElement() {
        addToCartBlouseElement.click();
    }

    public void clickProceedBtn() {
        proceedBtn.click();
    }

    public void moveToBlouseElement() {
        Actions actions = new Actions(DriverHelper.getDriver());
        actions.moveToElement(blouseElement).build().perform();
    }

    public void waitForProceedElement() {
        WaitHelper.explicitWait(proceedBtn);
    }

    public void waitForAddToCartBlouseElement() {
        WaitHelper.explicitWait(addToCartBlouseElement);
    }


}
