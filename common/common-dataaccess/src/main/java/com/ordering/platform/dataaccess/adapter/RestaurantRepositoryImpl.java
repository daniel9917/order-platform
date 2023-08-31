package com.ordering.platform.dataaccess.adapter;

import com.ordering.platform.dataaccess.mapper.RestaurantDataAccessMapper;
import com.ordering.platform.dataaccess.repository.RestaurantJpaRepository;
import com.ordering.platform.domain.entity.Restaurant;
import com.ordering.platform.restaurant.service.domain.ports.output.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RestaurantRepositoryImpl implements RestaurantRepository {

    private final RestaurantJpaRepository restaurantJpaRepository;

    private final RestaurantDataAccessMapper restaurantDataAccessMapper;

    @Autowired
    public RestaurantRepositoryImpl(RestaurantJpaRepository restaurantJpaRepository, RestaurantDataAccessMapper restaurantDataAccessMapper) {
        this.restaurantJpaRepository = restaurantJpaRepository;
        this.restaurantDataAccessMapper = restaurantDataAccessMapper;
    }

    @Override
    public Restaurant createRestaurant(Restaurant restaurant) {
        return restaurantDataAccessMapper.restaurantEntityToRestaurant(
                restaurantJpaRepository.save(restaurantDataAccessMapper.restaurantToRestaurantEntity(restaurant)));
    }
}
