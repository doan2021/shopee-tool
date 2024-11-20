package com.example.shopeetool.authentication.service.impl;

import com.example.shopeetool.authentication.configuration.AuthenticationProperties;
import com.example.shopeetool.authentication.factory.impl.WebDriverFactory;
import com.example.shopeetool.authentication.service.AuthenticationService;
import jakarta.annotation.Resource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Resource
    private WebDriverFactory webDriverFactory;

    @Resource
    private AuthenticationProperties authenticationProperties;

    @Override
    public boolean isLoggedIn() {
        try {
            WebElement profilePic = webDriverFactory.getWebDriver().findElement(By.id("pic"));
            return profilePic != null && profilePic.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public void login() {
        WebDriver driver = webDriverFactory.getWebDriver();
        driver.get(authenticationProperties.getUrl());
        if (!isLoggedIn()) {
            WebElement usernameField = driver.findElement(By.name("email"));
            usernameField.sendKeys(authenticationProperties.getUsername());
            WebElement passwordField = driver.findElement(By.name("password"));
            passwordField.sendKeys(authenticationProperties.getUsername());
            WebElement loginButton = driver.findElement(By.id("js_btn_login"));
            loginButton.click();
        }
    }
}