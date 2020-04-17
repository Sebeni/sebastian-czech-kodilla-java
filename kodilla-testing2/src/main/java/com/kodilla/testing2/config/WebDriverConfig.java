package com.kodilla.testing2.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverConfig {
    public static final String FIREFOX = "FIREFOX_DRIVER";
    public static final String CHROME = "CHROME_DRIVER";
    
    public static WebDriver getDriver(final String driver) {
        System.setProperty("webdriver.gecko.driver", "C:\\Selenium-drivers\\\\firefox\\geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium-drivers\\chrome\\chromedriver.exe");
        
        WebDriver result;
        
        switch(driver) {
            case FIREFOX:
                result = new FirefoxDriver();
                break;
            case CHROME:
                result = new ChromeDriver();
                break;
            default:
                result = null;
                break;
        }
        
        return result;
    }
}
