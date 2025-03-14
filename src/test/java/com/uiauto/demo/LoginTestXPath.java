package com.uiauto.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTestXPath {

    private static final String USERNAME = "standard_user";
    private static final String PASSWORD = "secret_sauce";
    private static final String URI = "https://www.saucedemo.com/";
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.get(URI);
        driver.manage().window().maximize();
    }


    // testing with parth difineing 
    @Test
    public void validLoginTestWithoutPageObjectModel() {
        WebElement userName = driver.findElement(By.xpath("//input[@id='user-name']"));
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        WebElement submitButton = driver.findElement(By.xpath("//input[@id='login-button']"));

        userName.sendKeys(USERNAME);
        password.sendKeys(PASSWORD);
        submitButton.click();
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            // driver.quit();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                // Log the exception, handle it gracefully, or re-interrupt the thread
                e.printStackTrace(); // At minimum, print the stack trace
                Thread.currentThread().interrupt(); // Restore the interrupted status (optional but good practice)
            } finally {
                driver.quit();
            }
        }
    }
}