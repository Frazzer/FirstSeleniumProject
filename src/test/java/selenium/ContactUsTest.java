package selenium;

import com.szendzij.FirstSeleniumProject.pages.ContactUsPage;
import com.szendzij.FirstSeleniumProject.pages.HomePage;
import org.junit.Before;
import org.junit.Test;


import java.io.File;

import static org.junit.Assert.assertEquals;


public class ContactUsTest extends InitialTest {
    final String email = "lorem@ipsum.pl";
    final String orderreference = "lorem";
    final String message = "lorem";

    @Before
    public void contactMenu() {

        HomePage homePage = new HomePage();
        ContactUsPage contactUsPage = new ContactUsPage();

        homePage.contactUsMenu.click();
        contactUsPage.emialInput.sendKeys(this.email);
        contactUsPage.orderReferenctInput.sendKeys(this.orderreference);
        contactUsPage.messageTextArea.sendKeys(this.message);
    }


    @Test
    public void asCustomerIShallNotSendEmailWithoutSubject() {

        final String expectedTextOfValidation = "Please select a subject from the list provided.";
        ContactUsPage contactUsPage = new ContactUsPage();


        //given

        //when
        contactUsPage.submitBtn.click();
        String currentTextOfValidation = contactUsPage.textOfValidationWhenThereIsNoSubject.getText();

        //then
        assertEquals(expectedTextOfValidation, currentTextOfValidation);
    }

    @Test
    public void asCustomerIShallSendEmailWithSubject() {
        //given
        final String expectedText = "Your message has been successfully sent to our team.";
        ContactUsPage contactUsPage = new ContactUsPage();

        //when
        contactUsPage.selectSubject.click();
        contactUsPage.submitBtn.click();

        String currentText = contactUsPage.validationMsg.getText();

        //then
        assertEquals(expectedText, currentText);
    }

    @Test
    public void asCustomerIShallSendEmailWithSubjectAndAttachment() {
        //given

        final String expectedText = "Your message has been successfully sent to our team.";
        ContactUsPage contactUsPage = new ContactUsPage();

        String testFile = getClass().getClassLoader().getResource("test.txt").getFile();
        contactUsPage.selectSubject.click();
        contactUsPage.fileUpload.sendKeys(new File(testFile).getAbsolutePath());

        //when
        contactUsPage.submitBtn.click();
        String currentText = contactUsPage.validationMsg.getText();

        //then
        assertEquals(expectedText, currentText);
    }
}
