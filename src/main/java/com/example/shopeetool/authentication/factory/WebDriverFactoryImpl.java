package com.example.shopeetool.authentication.factory;

import com.example.shopeetool.authentication.factory.impl.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.stereotype.Component;

@Component
public class WebDriverFactoryImpl implements WebDriverFactory {

    private final WebDriver webDriver;

    public WebDriverFactoryImpl() {
        WebDriverManager.chromedriver().setup();
        this.webDriver = setupWebDriver();
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

    @Override
    public WebDriver getWebDriver() {
        return webDriver;
    }
}