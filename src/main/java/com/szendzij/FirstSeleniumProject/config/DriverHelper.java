package com.szendzij.FirstSeleniumProject.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public class DriverHelper {

    private static WebDriver driver;

    public static WebDriver getDriver(String... url) {
        if (driver == null) {
            if (url.length != 0) {
                driver = startDriver(url[0]);
            } else {
                driver = startDriver("http://automationpractice.com/index.php");
            }
        }
        return driver;
    }

    private static WebDriver startDriver(String url) {
        ClassLoader classLoader = DriverHelper.class.getClassLoader();
        String chromeDriverPath = classLoader.getResource("chromedriver.exe").getFile();
        File chromeDriver = new File(chromeDriverPath);

        System.setProperty("webdriver.chrome.driver", chromeDriver.getAbsolutePath());
        driver = new ChromeDriver();
        driver.navigate().to(url);
        driver.manage().window().maximize();

        return driver;
    }

    public static void closeDriver() {
        driver.close();
        driver.quit();
        driver = null;
    }


}
