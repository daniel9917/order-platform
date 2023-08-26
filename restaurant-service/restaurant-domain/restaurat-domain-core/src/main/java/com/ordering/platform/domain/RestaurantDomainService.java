package com.ordering.platform.domain;

import com.ordering.platform.domain.entity.Restaurant;
import com.ordering.platform.domain.exception.RestaurantDomainException;

public interface RestaurantDomainService {

    void validateRestaurant (Restaurant restaurant) throws RestaurantDomainException;
}
