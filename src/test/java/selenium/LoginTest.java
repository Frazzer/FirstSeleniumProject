package selenium;

import com.szendzij.FirstSeleniumProject.config.DriverHelper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.sql.Driver;

import static org.junit.Assert.assertEquals;

public class LoginTest {
    WebDriver driver;
    DriverHelper driverHelper;

    @Before
    public void setup() {
        driverHelper = new DriverHelper();
        this.driver = driverHelper.startDriver("http://automationpractice.com/index.php");
    }

    @After
    public void cleanUp() {
        driverHelper.closeDriver();
    }

    @Test
    public void asNotRegisteredCustomerIShallNotLogIn() throws InterruptedException {
        //given
        final String expectedTextOfValidation = "Authentication failed.";

        //when
        WebElement loginBtn = this.driver.findElement(By.className("login"));
        loginBtn.click();

        WebElement emailInp = this.driver.findElement(By.id("email"));
        emailInp.sendKeys("testowyEmail@test.pl");

        WebElement passwdInp = this.driver.findElement(By.id("passwd"));
        passwdInp.sendKeys("qwertyuiop");

        WebElement submitLoginBtn = this.driver.findElement(By.id("SubmitLogin"));
        submitLoginBtn.click();

        WebElement alertValidation = this.driver.findElement(By.cssSelector("#center_column > div.alert.alert-danger > ol > li"));
        String actualTextOfValidation = alertValidation.getText();

        //then
        assertEquals(expectedTextOfValidation, actualTextOfValidation);
    }

}
