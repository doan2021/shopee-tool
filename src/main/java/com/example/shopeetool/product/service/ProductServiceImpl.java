package com.example.shopeetool.product.service;

import com.example.shopeetool.authentication.factory.impl.WebDriverFactory;
import com.example.shopeetool.product.configuration.ProductProperties;
import com.example.shopeetool.product.service.impl.ProductService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    private WebDriverFactory webDriverFactory;

    @Resource
    private ProductProperties productProperties;

    @Override
    public void redirect() {
        webDriverFactory.getWebDriver().get(productProperties.getUrl());
    }
}
