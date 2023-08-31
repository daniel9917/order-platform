package com.ordering.platform.dataaccess.mapper;

import com.ordering.platform.dataaccess.entity.RestaurantEntity;
import com.ordering.platform.domain.entity.Restaurant;
import org.springframework.stereotype.Component;

@Component
public class RestaurantDataAccessMapper {

    public Restaurant restaurantEntityToRestaurant (RestaurantEntity restaurantEntity) {
        return
                new Restaurant(
                        restaurantEntity.getId(),
                        restaurantEntity.getName(),
                        restaurantEntity.getAddress());
    }
    public RestaurantEntity restaurantToRestaurantEntity (Restaurant restaurant){
        return RestaurantEntity.builder()
                .id(restaurant.getId())
                .address(restaurant.getAddress())
                .name(restaurant.getName())
                .build();
    }
}
