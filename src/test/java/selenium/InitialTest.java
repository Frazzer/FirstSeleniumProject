package selenium;

import com.szendzij.FirstSeleniumProject.config.DriverHelper;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public class InitialTest {

    public WebDriver driver;

    @Before
    public void setup() {
        driver = DriverHelper.getDriver();
    }

    @After
    public void cleanUp() {
        DriverHelper.closeDriver();
    }
}
