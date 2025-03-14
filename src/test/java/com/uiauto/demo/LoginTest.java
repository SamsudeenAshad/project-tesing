package com.uiauto.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;
import org.testng.annotations.Test;

public class LoginTest {
    private String userNameStr = "standard_user";
    private String passwordStr = "secret_sauce";
    private String uri = "https://www.saucedemo.com/";

    @Test(priority = 1)
    public void validLoginTestWithoutPageObjectModel() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get(uri);
        driver.manage().window().maximize();
        Thread.sleep(5000);

        WebElement userName = driver.findElement(By.id("user-name"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement submitButton = driver.findElement(By.id("login-button"));

        System.out.println("Type attribute " + submitButton.getAttribute("type"));
        System.out.println("ID attribute " + submitButton.getAttribute("id"));
        System.out.println("Name attribute " + submitButton.getAttribute("name"));

        userName.sendKeys(userNameStr);
        Thread.sleep(1000);
        password.sendKeys(passwordStr);
        Thread.sleep(1000);
        submitButton.click();

        Thread.sleep(5000);
        driver.quit();
    }
}
