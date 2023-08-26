package com.ordering.platform;

import com.ordering.platform.order.service.domain.OrderDomainService;
import com.ordering.platform.order.service.domain.OrderDomainServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OrderServiceApplication {
    public static void main (String [] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }

    @Bean
    public OrderDomainService orderDomainService () {
        return new OrderDomainServiceImpl();
    }

}
