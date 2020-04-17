package com.kodilla.testing2.crudapp;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CrudAppTestingApp {
    public static final String XPATH_TASK_NAME_ABS = "/html/body/main/section/form/fieldset/input";
    public static final String XPATH_TASK_CONTENT_ABS = "/html/body/main/section[1]/form/fieldset[2]/textarea";
    public static final String XPATH_WAIT_FOR = "//select[1]";
    public static final String XPATH_SELECT = "//div[contains(@class, \"tasks-container\")]/form/div/fieldset/select[1]";
    

    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://sebeni.github.io/");

        WebElement taskNameField = driver.findElement(By.xpath(XPATH_TASK_NAME_ABS));
        taskNameField.sendKeys("New robotic task");
        
        WebElement taskContentField = driver.findElement(By.xpath(XPATH_TASK_CONTENT_ABS));
        taskContentField.sendKeys("The robotic content");
        
        while(!driver.findElement(By.xpath(XPATH_WAIT_FOR)).isDisplayed());
        
        WebElement selectCombo = driver.findElement(By.xpath(XPATH_SELECT));
        Select selectBoard = new Select(selectCombo);
        selectBoard.selectByIndex(1);
    }
}
