package com.example.shopeetool;

import com.example.shopeetool.authentication.service.AuthenticationService;
import com.example.shopeetool.product.service.impl.ProductService;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

@Component
public class MainTool {

    @Resource
    private AuthenticationService authenticationService;
    @Resource
    private ProductService productService;

    @PostConstruct
    public void handleLogin() {
        authenticationService.login();
        productService.redirect();
        try {
            Thread.sleep(Long.MAX_VALUE);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}