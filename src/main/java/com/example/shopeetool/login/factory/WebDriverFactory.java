package com.example.shopeetool.login.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class WebDriverFactory {

    private final WebDriver webDriver;

    public WebDriverFactory() {
        WebDriverManager.chromedriver().setup();
        this.webDriver = setupWebDriver();
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    private WebDriver setupWebDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("user-data-dir=D:\\UserData");
        options.addArguments("profile-directory=shopee_tool");
        options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36");
        return new ChromeDriver(options);
    }
}