package com.ordering.platform.restaurant.service.domain.ports.output.repository;

import com.ordering.platform.domain.entity.Restaurant;

public interface RestaurantRepository {
    Restaurant createRestaurant (Restaurant restaurant);
}
