package com.example.shopeetool.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    public boolean isLoggedIn(WebDriver driver) {
        try {
            WebElement profilePic = driver.findElement(By.id("pic"));
            return profilePic != null && profilePic.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void login(WebDriver driver) {
        WebElement usernameField = driver.findElement(By.name("email"));
        usernameField.sendKeys("dgminhtam1@gmail.com");
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("378187945919Tfgos1");
        WebElement loginButton = driver.findElement(By.xpath("//button[@id='js_btn_login']"));
        loginButton.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}