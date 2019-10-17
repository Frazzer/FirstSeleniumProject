package selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

import static org.junit.Assert.assertEquals;

public class LoginTest {

    @Test
    public void asNotRegisteredCustomerIShallNotLogIn() throws InterruptedException {
        //given
        final String url = "http://automationpractice.com/index.php";
        final String expectedTextOfValidation = "Authentication failed.";

        ClassLoader classLoader = LoginTest.class.getClassLoader();
        String chromeDriverPath = classLoader.getResource("chromedriver.exe").getFile();
        File chromeDriver = new File(chromeDriverPath);

        System.setProperty("webdriver.chrome.driver", chromeDriver.getAbsolutePath());
        WebDriver driver = new ChromeDriver();
        driver.navigate().to(url);
        driver.manage().window().maximize();

        //when
        WebElement loginBtn = driver.findElement(By.className("login"));
        loginBtn.click();
        driver.wait(500);

        WebElement emailInp = driver.findElement(By.id("email"));
        emailInp.sendKeys("testowyEmail@test.pl");

        WebElement passwdInp = driver.findElement(By.id("passwd"));
        passwdInp.sendKeys("qwertyuiop");

        WebElement submitLoginBtn = driver.findElement(By.id("SubmitLogin"));
        submitLoginBtn.click();
        driver.wait(500);

        WebElement alertValidation = driver.findElement(By.cssSelector("#center_column > div.alert.alert-danger > ol > li"));
        String actualTextOfValidation = alertValidation.getText();

        //then
        assertEquals(expectedTextOfValidation, actualTextOfValidation);

        driver.close();
        driver.quit();
    }

}
