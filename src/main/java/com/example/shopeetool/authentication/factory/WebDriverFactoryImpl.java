package com.example.shopeetool.authentication.factory;

import com.example.shopeetool.authentication.factory.impl.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WebDriverFactoryImpl implements WebDriverFactory {

    private final WebDriver webDriver;

    public WebDriverFactoryImpl() {
        WebDriverManager.chromedriver().setup();
        this.webDriver = setupWebDriver();
    }

    private WebDriver setupWebDriver() {
        ChromeOptions options = new ChromeOptions();

        // Các flag cải tiến
        options.addArguments("--start-maximized");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("user-data-dir=D:\\UserData");
        options.addArguments("profile-directory=shopee_tool");

        // Đặt user-agent tùy chỉnh
        options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/116.0.0.0 Safari/537.36");

        // Loại bỏ các dấu hiệu ChromeDriver
        options.setExperimentalOption("excludeSwitches", List.of("enable-automation"));
        options.setExperimentalOption("useAutomationExtension", false);
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("--disable-extensions");
        // Xử lý SSL nếu cần
        options.addArguments("--ignore-certificate-errors");

        // Khởi tạo WebDriver
        WebDriver driver = new ChromeDriver(options);

        // Gỡ bỏ navigator.webdriver
        ((JavascriptExecutor) driver).executeScript(
                "Object.defineProperty(navigator, 'webdriver', {get: () => undefined})");

        return driver;
    }


    @Override
    public WebDriver getWebDriver() {
        return webDriver;
    }
}