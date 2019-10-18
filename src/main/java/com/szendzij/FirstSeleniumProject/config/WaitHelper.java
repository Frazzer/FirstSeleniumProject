package com.szendzij.FirstSeleniumProject.config;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WaitHelper {
    public static void implicitlyWait() {
        /*poniżej jest generyczny generyczny wait który jak leci wyjątek że nie ma elementu to czeka w tym przypadku 10 sek z sprawdzeniem
        co chwile czy może już jest*/
        DriverHelper.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public static void explicitWait(WebElement element) {
        WebDriverWait wait = new WebDriverWait(DriverHelper.getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(element));

    }
}
