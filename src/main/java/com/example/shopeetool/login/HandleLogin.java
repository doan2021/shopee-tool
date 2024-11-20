package com.example.shopeetool.login;

import com.example.shopeetool.login.factory.WebDriverFactory;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class HandleLogin {

    @Resource
    private LoginService loginService;

    @Resource
    private WebDriverFactory webDriverFactory;

    @PostConstruct
    public void handleLogin() {
        WebDriver driver = webDriverFactory.getWebDriver();
        try {
            driver.get("https://www.zoom.us/signin");

            if (!loginService.isLoggedIn(driver)) {
                System.out.println("Chưa đăng nhập. Thực hiện đăng nhập...");
                loginService.login(driver);
            }
            driver.get("https://www.zoom.us/profile");
            System.out.println("Đi tới trang Profile.");
            Thread.sleep(Long.MAX_VALUE);
        } catch (Exception e) {
            System.err.println(Arrays.toString(e.getStackTrace()));
        } finally {
            System.out.println("Đóng trình duyệt...");
            driver.quit();
        }
    }

}