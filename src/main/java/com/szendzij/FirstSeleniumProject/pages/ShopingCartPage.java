package com.szendzij.FirstSeleniumProject.pages;

import com.szendzij.FirstSeleniumProject.config.DriverHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShopingCartPage {

    @FindBy(id = "total_product")
    private WebElement blousePrice;
    @FindBy(id = "total_shipping")
    private WebElement shippingCosts;

    public ShopingCartPage() {
        PageFactory.initElements(DriverHelper.getDriver(), this);
    }

    public String getBlousePrice() {
        return blousePrice.getText();
    }

    public String getShippingCosts() {
        return shippingCosts.getText();
    }

}
