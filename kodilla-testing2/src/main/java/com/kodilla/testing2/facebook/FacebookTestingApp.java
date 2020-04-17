package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FacebookTestingApp {
    private static final String FIRST_NAME_XPATH = "//input[contains(@name, \"firstname\")]";
    private static final String LAST_NAME_XPATH = "//input[contains(@name, \"lastname\")]";
    private static final String MOBILE_XPATH = "//input[contains(@type, \"text\") and contains(@name, \"email\")]";
    private static final String BDAY_XPATH = "//span/select[contains(@name, \"birthday\")]";
    private static final String MONTH_XPATH = "//select[contains(@name, \"month\")]";
    private static final String YEAR_XPATH = "//select[contains(@name, \"year\")]";
    private static final String NON_STANDARD_SEX_OPTION_ID = "u_0_8";
    private static final String PREF_PRON_XPATH = "//select[contains(@name, \"pronoun\")]";
           
    
    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://www.facebook.com/");

        WebElement firstNameBox = driver.findElement(By.xpath(FIRST_NAME_XPATH));
        firstNameBox.sendKeys("Adam");

        WebElement lastNameBox = driver.findElement(By.xpath(LAST_NAME_XPATH));
        lastNameBox.sendKeys("Smith");

        WebElement mobileBox = driver.findElement(By.xpath(MOBILE_XPATH));
        mobileBox.sendKeys("1234");
        
        WebElement bDayElement = driver.findElement(By.xpath(BDAY_XPATH));
        Select bDaySelect = new Select(bDayElement);
        bDaySelect.selectByValue("10");

        WebElement monthElement = driver.findElement(By.xpath(MONTH_XPATH));
        Select monthSelect = new Select(monthElement);
        monthSelect.selectByIndex(10);

        WebElement yearElement = driver.findElement(By.xpath(YEAR_XPATH));
        Select yearSelect = new Select(yearElement);
        yearSelect.selectByValue("1910");
        
        WebElement genderBox = driver.findElement(By.id(NON_STANDARD_SEX_OPTION_ID));
        genderBox.click();
        
        WebElement pronounElement = driver.findElement(By.xpath(PREF_PRON_XPATH));
        Select pronounSelect = new Select(pronounElement);
        pronounSelect.selectByIndex(2);
    }
}
