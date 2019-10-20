package com.szendzij.FirstSeleniumProject.pages;

import com.szendzij.FirstSeleniumProject.config.DriverHelper;
import com.szendzij.FirstSeleniumProject.config.WaitHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingPage {

    Actions actions = new Actions(DriverHelper.getDriver());
    @FindBy(css = "#block_top_menu a[title='Summer Dresses']")
    private WebElement casualDressesElementMenuItem;
    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[1]/div/div[1]/div/a[1]/img")
    private WebElement printedSummerDress1;
    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[2]/div/div[1]/div/a[1]/img")
    private WebElement printedSummerDress2;
    @FindBy(linkText = "Add to cart")
    private WebElement addToCartButton;
    @FindBy(css = ".cross")
    private WebElement cancelLayerCardOfProductByClickOnCrossButton;

    public ShoppingPage() {
        PageFactory.initElements(DriverHelper.getDriver(), this);
    }

    public ShoppingPage moveMouseToDress1() {
        actions.moveToElement(printedSummerDress1).build().perform();
        return this;
    }

    public ShoppingPage waitForAddToCartButton() {
        WaitHelper.explicitWait(addToCartButton);
        return this;
    }

    public ShoppingPage clickOnAddToCartButtonOnDress() {
        addToCartButton.click();
        return this;
    }

    public ShoppingPage moveMouseToDress2() {
        actions.moveToElement(printedSummerDress2).build().perform();
        return this;
    }

    public ShoppingPage clickOnCancelLayerCardOfProductCrossButton() {
        cancelLayerCardOfProductByClickOnCrossButton.click();
        return this;
    }

    public ShoppingPage waitForCancelLayerCardOfProductByClickOnCrossButton() {
        WaitHelper.explicitWait(cancelLayerCardOfProductByClickOnCrossButton);
        return this;
    }


}
