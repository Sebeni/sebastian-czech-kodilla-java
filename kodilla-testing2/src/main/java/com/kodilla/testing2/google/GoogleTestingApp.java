package com.kodilla.testing2.google;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleTestingApp {
    public static final String SEARCHFIELD = "search_form_input_homepage";
    
    public static void main(String[] args) {
        WebDriver webDriver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        webDriver.get("https://duckduckgo.com/");

        WebElement searchField = webDriver.findElement(By.id(SEARCHFIELD));
        searchField.sendKeys("kodilla");
        searchField.submit();
    }
}
