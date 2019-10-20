package selenium;

import com.szendzij.FirstSeleniumProject.pages.HomePage;
import com.szendzij.FirstSeleniumProject.pages.LoginPage;
import lombok.extern.java.Log;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LoginTest extends InitialTest {

    final static String email = "lorem@ipsum.pl";
    final String password = "lorem";

    private HomePage homePage;
    private LoginPage loginPage;

    @Test
    public void asNotRegisteredCustomerIShallNotLogIn() {


        //given
        homePage = new HomePage();
        loginPage = new LoginPage();

        final String expectedTextOfValidation = "Authentication failed.";

        //when
        homePage.clickSignIn()
                .enterEmail(email)
                .enterPassword(password)
                .clickSubmitBtn();

        //then
        assertEquals(expectedTextOfValidation, loginPage.getActualTextOfValidation());
    }

}
