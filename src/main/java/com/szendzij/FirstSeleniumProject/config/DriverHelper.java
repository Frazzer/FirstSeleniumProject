package com.szendzij.FirstSeleniumProject.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public class DriverHelper {
    WebDriver driver;


    public WebDriver startDriver(String url) {
        ClassLoader classLoader = DriverHelper.class.getClassLoader();
        String chromeDriverPath = classLoader.getResource("chromedriver.exe").getFile();
        File chromeDriver = new File(chromeDriverPath);

        System.setProperty("webdriver.chrome.driver", chromeDriver.getAbsolutePath());
        driver = new ChromeDriver();
        driver.navigate().to(url);
        driver.manage().window().maximize();

        return driver;
    }

    public void closeDriver() {
        driver.close();
        driver.quit();
        driver.manage();
    }
}
