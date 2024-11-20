package com.example.shopeetool.authentication.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "authentication")
@Getter
@Setter
public class AuthenticationProperties {

    private String url;

    private String username;

    private String password;
}
