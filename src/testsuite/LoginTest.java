package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class LoginTest extends BaseTest {
    String baseUrl ="https://www.saucedemo.com/";
    @Before
    public void setUp() {

        openBrowser(baseUrl);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
    @Test
    public void userSholdLoginSuccessfullyWithValid(){
        //locate username
        WebElement usernameField = driver.findElement(By.id("user-name"));
        usernameField.sendKeys("standard_user");
        //locate password
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("secret_sauce");
        //login button
        WebElement loginBtn = driver.findElement(By.id("login-button"));
        loginBtn.click();

        //this is requirement
        String expectedText = "Products";
        // actual text
        WebElement actualTextElement = driver.findElement(By.xpath("//span[contains(text(),'Products')]"));
        String actualText = actualTextElement.getText();
        assertEquals(expectedText,actualText);
    }
    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {

        //locate username
        WebElement usernameField = driver.findElement(By.id("user-name"));
        usernameField.sendKeys("standard_user");
        //locate password
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("secret_sauce");
        //login button
        WebElement loginBtn = driver.findElement(By.id("login-button"));
        loginBtn.click();
        //this is requirement
        int expectedNumber = 6;
        List<WebElement> actualNumberElement= driver.findElements(By.className("inventory_item"));
        int actualNumber= actualNumberElement.size();
        assertEquals(expectedNumber,actualNumber);

    }

}
