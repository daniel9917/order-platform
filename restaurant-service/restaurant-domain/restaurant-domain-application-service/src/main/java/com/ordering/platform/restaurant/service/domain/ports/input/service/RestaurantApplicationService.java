package com.ordering.platform.restaurant.service.domain.ports.input.service;

import com.ordering.platform.restaurant.service.domain.command.CreateRestaurantCommand;
import com.ordering.platform.restaurant.service.domain.response.CreateRestaurantResponse;
import jakarta.validation.Valid;

public interface RestaurantApplicationService {
    CreateRestaurantResponse createRestaurant (@Valid CreateRestaurantCommand createRestaurantCommand);
}
