package com.szendzij.FirstSeleniumProject.pages;

import com.szendzij.FirstSeleniumProject.config.DriverHelper;
import com.szendzij.FirstSeleniumProject.config.WaitHelper;
import lombok.extern.java.Log;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Log
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
    @FindBy(css = "#block_top_menu a[title='Summer Dresses']")
    private WebElement casualDressesElementMenuItem;
    @FindBy(css = "#block_top_menu a[title='Women']")
    private WebElement womenMenu;


    Actions actions = new Actions(DriverHelper.getDriver());


    public HomePage() {
        PageFactory.initElements(DriverHelper.getDriver(), this);
    }

    public LoginPage clickSignIn() {
        log.info("Click on Sign in button ");
        loginBtn.click();
        return new LoginPage();
    }

    public ContactUsPage clickContactUsMenu() {
        log.info("Click on ContactUs button ");
        contactUsMenu.click();
        return new ContactUsPage();
    }

    public HomePage clickAddToCartBlouseElement() {
        log.info("Click on addToCartBlouseElement button ");
        addToCartBlouseElement.click();
        return this;
    }


    public ShopingCartPage clickProceedBtn() {
        log.info("Click on clickProceedBtn button ");
        proceedBtn.click();
        return new ShopingCartPage();
    }

    public void moveMouseToBlouseElement() {
        actions.moveToElement(blouseElement).build().perform();
    }

    public void moveMouseToWomenMenu() {
        actions.moveToElement(womenMenu).build().perform();
    }

    public ShoppingPage clickOnCasualDressesMenuItem() {
        log.info("Click on clickOnCasualDressesElement ");
        casualDressesElementMenuItem.click();
        return new ShoppingPage();
    }

    public void waitForProceedElement() {
        WaitHelper.explicitWait(proceedBtn);
    }

    public void waitForCasualDressesElementMenuItem() {
        WaitHelper.explicitWait(casualDressesElementMenuItem);
    }


    public void waitForAddToCartBlouseElement() {
        WaitHelper.explicitWait(addToCartBlouseElement);
    }


}
