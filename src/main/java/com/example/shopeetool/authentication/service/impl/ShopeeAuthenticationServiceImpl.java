package com.example.shopeetool.authentication.service.impl;

import com.example.shopeetool.authentication.configuration.AuthenticationProperties;
import com.example.shopeetool.authentication.factory.impl.WebDriverFactory;
import com.example.shopeetool.authentication.service.AuthenticationService;
import jakarta.annotation.Resource;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.springframework.stereotype.Service;

@Service
public class ShopeeAuthenticationServiceImpl implements AuthenticationService {

    @Resource
    private WebDriverFactory webDriverFactory;

    @Resource
    private AuthenticationProperties authenticationProperties;

    @Override
    public boolean isLoggedIn() {
        try {
            WebElement profilePic = webDriverFactory.getWebDriver().findElement(By.xpath("//div[text()='tamduong550']"));
            return profilePic != null && profilePic.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @Override
    public void login() {
        WebDriver driver = webDriverFactory.getWebDriver();
        driver.get(authenticationProperties.getUrl());

        // Mô phỏng tương tác với trang login
        mimicUserInteraction(driver);

        if (!isLoggedIn()) {
            WebElement usernameField = driver.findElement(By.name("loginKey"));
            mimicFocusAndType(driver, usernameField, authenticationProperties.getUsername());

            WebElement passwordField = driver.findElement(By.name("password"));
            mimicFocusAndType(driver, passwordField, authenticationProperties.getPassword());

            WebElement loginButton = driver.findElement(By.xpath("//button[text()='Đăng nhập']"));
            mimicClick(driver, loginButton);
        }
    }

    /**
     * Mô phỏng việc di chuyển chuột và tương tác trên trang để tránh bị nghi ngờ là bot.
     */
    private void mimicUserInteraction(WebDriver driver) {
        Actions actions = new Actions(driver);
        // Di chuyển chuột đến một vị trí ngẫu nhiên
        WebElement randomElement = driver.findElement(By.tagName("body"));
        actions.moveToElement(randomElement, 50, 50).perform();

        // Cuộn xuống một chút
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollBy(0, 200);");

        // Chờ ngẫu nhiên để mô phỏng hành vi người dùng
        try {
            Thread.sleep((long) (Math.random() * 3000) + 1000); // 1-3 giây
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Mô phỏng việc nhập liệu vào một trường input.
     */
    private void mimicFocusAndType(WebDriver driver, WebElement element, String text) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform(); // Di chuyển chuột đến trường và click
        for (char c : text.toCharArray()) {
            element.sendKeys(String.valueOf(c)); // Nhập từng ký tự một
            try {
                Thread.sleep((long) (Math.random() * 200) + 100); // Chờ ngẫu nhiên giữa các ký tự
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    /**
     * Mô phỏng việc click vào một nút.
     */
    private void mimicClick(WebDriver driver, WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform(); // Di chuyển chuột đến nút và click
        try {
            Thread.sleep((long) (Math.random() * 2000) + 500); // Chờ sau khi click
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}