package com.ordering.platform;

import com.ordering.platform.product.service.domain.ProductDomainService;
import com.ordering.platform.product.service.domain.ProductDomainServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProductServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class);
    }

    @Bean
    public ProductDomainService productDomainService () {
        return new ProductDomainServiceImpl();
    }
}