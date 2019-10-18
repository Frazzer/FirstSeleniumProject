package selenium;

import com.szendzij.FirstSeleniumProject.pages.HomePage;
import com.szendzij.FirstSeleniumProject.pages.LoginPage;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LoginTest extends InitialTest {

    private HomePage homePage;
    private LoginPage loginPage;

    @Test
    public void asNotRegisteredCustomerIShallNotLogIn() {

        //given
        homePage = new HomePage();
        loginPage = new LoginPage();
        final String expectedTextOfValidation = "Authentication failed.";

        //when
        homePage.clickSignIn();
        loginPage.enterEmail("lorem@ipsum.pl");
        loginPage.enterPassword("password");
        loginPage.clickSubmitBtn();

        //then
        assertEquals(expectedTextOfValidation, loginPage.getActualTextOfValidation());
    }

}
