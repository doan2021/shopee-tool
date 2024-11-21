package com.example.shopeetool;

import com.example.shopeetool.authentication.factory.impl.WebDriverFactory;
import com.example.shopeetool.authentication.service.AuthenticationService;
import com.example.shopeetool.product.service.impl.ProductService;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

@Component
public class MainTool {

    @Resource
    private AuthenticationService authenticationService;
    @Resource
    private ProductService productService;
    @Resource
    private WebDriverFactory webDriverFactory;

    @PostConstruct
    public void handleLogin() {
        try {
            authenticationService.login();
//            productService.redirect();

            Thread.sleep(Long.MAX_VALUE);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @PreDestroy
    public void onShutdown() {
        webDriverFactory.getWebDriver().close();
    }


}