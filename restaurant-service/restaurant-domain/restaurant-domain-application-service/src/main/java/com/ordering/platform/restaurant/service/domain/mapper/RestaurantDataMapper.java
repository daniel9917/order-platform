package com.ordering.platform.restaurant.service.domain.mapper;

import com.ordering.platform.domain.entity.Restaurant;
import com.ordering.platform.restaurant.service.domain.command.CreateRestaurantCommand;
import com.ordering.platform.restaurant.service.domain.response.CreateRestaurantResponse;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class RestaurantDataMapper {

    public Restaurant createRestaurantCommandToRestaurant (CreateRestaurantCommand createRestaurantCommand){
        return
                new Restaurant(
                        createRestaurantCommand.name(),
                        createRestaurantCommand.address());
    }

    public CreateRestaurantResponse restaurantToCreateRestaurantResponse (Restaurant restaurant, String message) {
        return new CreateRestaurantResponse.Builder()
                .restaurantId(restaurant.getId())
                .message("Successfuly created restaurant with Id: " + message)
                .build();
    }

}
