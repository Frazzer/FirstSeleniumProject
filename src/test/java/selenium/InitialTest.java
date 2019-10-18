package selenium;

import com.szendzij.FirstSeleniumProject.config.DriverHelper;
import org.junit.After;
import org.junit.Before;
import org.omg.CORBA.TIMEOUT;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class InitialTest {

    public WebDriver driver;

    @Before
    public void setup() {
        this.driver = DriverHelper.getDriver();
    }

    @After
    public void cleanUp() {
        DriverHelper.closeDriver();
    }

}

