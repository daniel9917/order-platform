package com.ordering.platform.restaurant.service.domain.mapper;

import com.ordering.platform.domain.entity.Restaurant;
import com.ordering.platform.restaurant.service.domain.command.CreateRestaurantCommand;
import com.ordering.platform.restaurant.service.domain.response.CreateRestaurantResponse;
import org.springframework.stereotype.Component;

@Component
public class RestaurantDataMapper {

    public Restaurant createRestaurantCommandToRestaurant (CreateRestaurantCommand createRestaurantCommand){
        return
                new Restaurant(
                        createRestaurantCommand.getName(),
                        createRestaurantCommand.getAddress());
    }

    public CreateRestaurantResponse restaurantToCreateRestaurantResponse (Restaurant restaurant, String message) {
        return CreateRestaurantResponse.builder()
                .restaurantId(restaurant.getId())
                .message("Successfuly created restaurant with Id: " + message)
                .build();
    }

}
