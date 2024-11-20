package com.example.shopeetool.login.action;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class ActionPage {

    private final WebDriver driver;

    public ActionPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToPage(String url) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.location.href=" + url + ";");
    }
}
