package selenium;

import com.szendzij.FirstSeleniumProject.pages.ContactUsPage;
import com.szendzij.FirstSeleniumProject.pages.HomePage;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;


public class ContactUsTest extends InitialTest {
    final String email = "lorem@ipsum.pl";
    final String orderReference = "lorem";
    final String message = "lorem";

    private HomePage homePage;
    private ContactUsPage contactUsPage;


    @Before
    public void contactMenu() {

        homePage = new HomePage();
        contactUsPage = new ContactUsPage();
        homePage.clickContactUsMenu();
        contactUsPage.enterEmail(email);
        contactUsPage.enterOrderReference(orderReference);
        contactUsPage.enterMessage(message);
    }


    @Test
    public void asCustomerIShallNotSendEmailWithoutSubject() {
        //given
        final String expectedTextOfValidation = "Please select a subject from the list provided.";

        //when
        contactUsPage.clickSubmitBtn();

        //then
        assertEquals(expectedTextOfValidation, contactUsPage.getTextOfValidationWhenThereIsNoSubject());
    }

    @Test
    public void asCustomerIShallSendEmailWithSubject() {
        //given
        final String expectedText = "Your message has been successfully sent to our team.";

        //when
        contactUsPage.clickSubject();
        contactUsPage.clickSubmitBtn();


        //then
        assertEquals(expectedText, contactUsPage.getValidationMsg());
    }

    @Test
    public void asCustomerIShallSendEmailWithSubjectAndAttachment() {
        //given
        final String expectedText = "Your message has been successfully sent to our team.";
        //when

        contactUsPage.clickSubject();
        contactUsPage.addAttachment();
        contactUsPage.clickSubmitBtn();

        //then
        assertEquals(expectedText, contactUsPage.getValidationMsg());
    }


}
