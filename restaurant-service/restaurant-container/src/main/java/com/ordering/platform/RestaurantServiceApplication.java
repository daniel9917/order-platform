package com.ordering.platform;

import com.ordering.application.order.service.application.rest.RestaurantController;
import com.ordering.platform.domain.RestaurantDomainService;
import com.ordering.platform.domain.RestaurantDomainServiceImpl;
import com.ordering.platform.order.service.domain.ports.output.messaging.OrderCreatedProductApprovalRequestMessagePublisher;
import com.ordering.platform.restaurant.service.domain.ports.input.service.RestaurantApplicationService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class RestaurantServiceApplication {
    public static void main (String [] args) {
        SpringApplication.run(RestaurantServiceApplication.class, args);
    }

    @Bean
    public RestaurantDomainService restaurantDomainService () {
        return new RestaurantDomainServiceImpl();
    }

    @Bean
    public RestaurantController restaurantController (RestaurantApplicationService restaurantApplicationService) {
        return new RestaurantController(restaurantApplicationService);
    }

    @Bean
    public OrderCreatedProductApprovalRequestMessagePublisher orderCreatedRestaurantApprovalRequestMessagePublisher (){
        return order -> {

        };
    }
}
