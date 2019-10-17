package selenium;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.File;

import static org.junit.Assert.assertEquals;


public class ContactUsTest extends InitialTest {
    final String email = "lorem@ipsum.pl";
    final String orderreference = "lorem";
    final String message = "lorem";

    @Before
    public void contactMenu() {

        WebElement contactUsMenu = driver.findElement(By.id("contact-link"));
        contactUsMenu.click();

        WebElement emialInput = driver.findElement(By.id("email"));
        emialInput.sendKeys(this.email);

        WebElement orderReferenctInput = driver.findElement(By.id("id_order"));
        orderReferenctInput.sendKeys(this.orderreference);

        WebElement messageTextArea = driver.findElement(By.id("message"));
        messageTextArea.sendKeys(this.message);
    }


    @Test
    public void asCustomerIShallNotSendEmailWithoutSubject() {

        final String expectedTextOfValidation = "Please select a subject from the list provided.";

        //given

        //when
        WebElement submitBtn = driver.findElement(By.id("submitMessage"));
        submitBtn.click();

        WebElement validationMsg = driver.findElement(By.cssSelector("#center_column > div > ol > li"));
        String currentTextOfValidation = validationMsg.getText();

        //then
        assertEquals(expectedTextOfValidation, currentTextOfValidation);
    }

    @Test
    public void asCustomerIShallSendEmailWithSubject() {

        final String expectedText = "Your message has been successfully sent to our team.";

        //given

        WebElement selectSubject = driver.findElement(By.cssSelector("#id_contact > option:nth-child(2)"));
        selectSubject.click();

        //when
        WebElement submitBtn = driver.findElement(By.id("submitMessage"));
        submitBtn.click();

        WebElement validationMsg = driver.findElement(By.cssSelector("#center_column > p"));
        String currentText = validationMsg.getText();

        //then
        assertEquals(expectedText, currentText);
    }

    @Test
    public void asCustomerIShallSendEmailWithSubjectAndAttachment() {

        final String expectedText = "Your message has been successfully sent to our team.";

        //given

        WebElement selectSubject = driver.findElement(By.cssSelector("#id_contact > option:nth-child(2)"));
        selectSubject.click();

        WebElement fileUpload = driver.findElement(By.id("fileUpload"));
        String testFile = getClass().getClassLoader().getResource("test.txt").getFile();
        fileUpload.sendKeys(new File(testFile).getAbsolutePath());

        //when
        WebElement submitBtn = driver.findElement(By.id("submitMessage"));
        submitBtn.click();

        WebElement validationMsg = driver.findElement(By.cssSelector("#center_column > p"));
        String currentText = validationMsg.getText();

        //then
        assertEquals(expectedText, currentText);
    }
}
