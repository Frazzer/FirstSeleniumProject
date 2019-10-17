package selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;

public class LoginTest extends InitialTest {

    @Test
    public void asNotRegisteredCustomerIShallNotLogIn()  {
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
