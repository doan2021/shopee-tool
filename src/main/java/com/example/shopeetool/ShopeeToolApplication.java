package com.example.shopeetool;

import com.example.shopeetool.authentication.configuration.AuthenticationProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(AuthenticationProperties.class)
public class ShopeeToolApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopeeToolApplication.class, args);
    }
}
