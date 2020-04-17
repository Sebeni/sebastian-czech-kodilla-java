package com.kodilla.testing2.ebay;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EBayTestingApp {
    private final static String EBAY_SEARCH_BAR_ID = "gh-ac";

    public static void main(String[] args) {
        WebDriver webDriver = WebDriverConfig.getDriver(WebDriverConfig.FIREFOX);
        webDriver.get("https://www.ebay.com/");

        WebElement ebaySearchBar = webDriver.findElement(By.id(EBAY_SEARCH_BAR_ID));
        ebaySearchBar.sendKeys("Laptop");
        ebaySearchBar.submit();
        
    }
}
