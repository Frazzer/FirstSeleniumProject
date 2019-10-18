package selenium;

import com.szendzij.FirstSeleniumProject.pages.HomePage;
import com.szendzij.FirstSeleniumProject.pages.LoginPage;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LoginTest extends InitialTest {

    @Test
    public void asNotRegisteredCustomerIShallNotLogIn() {

        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();

        //given
        final String expectedTextOfValidation = "Authentication failed.";

        //when
        homePage.loginBtn.click();
        loginPage.emailInp.sendKeys("testowyEmail@test.pl");
        loginPage.passwdInp.sendKeys("qwertyuiop");
        loginPage.submitLoginBtn.click();
        String actualTextOfValidation = loginPage.actualTextOfValidation.getText();

        //then
        assertEquals(expectedTextOfValidation, actualTextOfValidation);
    }

}
