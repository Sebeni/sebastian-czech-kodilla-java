package com.kodilla.testing2.crudapp;

import com.kodilla.testing2.config.WebDriverConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;
import java.util.stream.Collectors;

import static org.junit.Assert.assertTrue;

public class CrudAppTestSuite {
    private static final String BASE_URL = "https://sebeni.github.io/";
    private WebDriver driver;
    private Random randomGenerator;

    @Before
    public void initTests() {
        driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get(BASE_URL);
        randomGenerator = new Random();
    }

    @After
    public void cleanUpAfterTest() {
        driver.close();
    }


    //    @Ignore
    @Test
    public void shouldCreateTrelloCard() throws InterruptedException {
        String taskName = createCrudAppTestTask();
        sendTestTaskToTrello(taskName);
        deleteCreatedTask(taskName);
        assertTrue(checkTaskExistsInTrello(taskName));
    }

    private String createCrudAppTestTask() throws InterruptedException {
        final String XPATH_TASK_NAME = "//form[contains(@action, \"createTask\")]/fieldset[1]/input";
        final String XPATH_TASK_CONTENT = "//form[contains(@action, \"createTask\")]/fieldset[2]/textarea";
        final String XPATH_ADD_BUTTON = "//form[contains(@action, \"createTask\")]/fieldset[3]/button";
        String taskName = "Task number " + randomGenerator.nextInt(100000);
        String taskContent = taskName + " content";

        WebElement name = driver.findElement(By.xpath(XPATH_TASK_NAME));
        name.sendKeys(taskName);

        WebElement content = driver.findElement(By.xpath(XPATH_TASK_CONTENT));
        content.sendKeys(taskContent);

        WebElement addButton = driver.findElement(By.xpath(XPATH_ADD_BUTTON));
        addButton.click();

        Thread.sleep(2000);


        return taskName;
    }

    private void sendTestTaskToTrello(String taskName) throws InterruptedException {
        driver.navigate().refresh();

        while (!driver.findElement(By.xpath("//select[1]")).isDisplayed()) ;


        driver.findElements(By.xpath("//form[@class=\"datatable__row\"]")).stream()
                .filter(anyForm -> anyForm.findElement(By.xpath(".//p[@class=\"datatable__field-value\"]")).getText().equals(taskName))
                .forEach(theForm -> {
                    WebElement selectElement = theForm.findElement(By.xpath(".//select[1]"));
                    Select select = new Select(selectElement);
                    select.selectByIndex(1);

                    WebElement buttonCreateCard = theForm.findElement(By.xpath(".//button[contains(@class, \"card-creation\")]"));
                    buttonCreateCard.click();
                });
        Thread.sleep(5000);
        driver.switchTo().alert().accept();
    }

    private boolean checkTaskExistsInTrello(String taskName) throws InterruptedException {
        boolean result = false;

        final String TRELLO_URL = "https://trello.com/login";
        WebDriver driverTrello = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driverTrello.get(TRELLO_URL);

        WebElement user = driverTrello.findElement(By.id("user"));
        user.sendKeys(System.getenv("TRELLO_USERNAME"));
        Thread.sleep(2000);
        while (!driverTrello.findElement(By.id("login")).isDisplayed()) ;
        driverTrello.findElement(By.id("login")).click();

        Thread.sleep(2000);

        while (!driverTrello.findElement(By.id("password")).isDisplayed()) ;
        WebElement password = driverTrello.findElement(By.id("password"));
        password.sendKeys(System.getenv("TRELLO_PASSWORD"));

        driverTrello.findElement(By.id("login-submit")).click();

        Thread.sleep(10000);

        while (!driverTrello.findElement(By.xpath("//a[@class=\"board-tile\"]")).isDisplayed()) ;
        driverTrello.findElement(By.xpath("//a[@class=\"board-tile\" and contains(@href, \"kodilla\")]")).click();


        Thread.sleep(2000);

        result = driverTrello.findElements(By.xpath("//span")).stream()
                .filter(theSpan -> theSpan.getText().contains(taskName))
                .collect(Collectors.toList())
                .size() > 0;

        driverTrello.close();

        return result;
    }

    private void deleteCreatedTask(String taskName) {
        driver.findElements(By.xpath("//form[@class=\"datatable__row\"]")).stream()
                .filter(anyForm -> anyForm.findElement(By.xpath(".//p[@class=\"datatable__field-value\"]")).getText().equals(taskName))
                .forEach(theForm -> theForm.findElements(By.xpath(".//button[@type=\"button\"]")).stream()
                        .filter(button -> button.getText().equals("Delete"))
                        .forEach(WebElement::click));
    }
}
