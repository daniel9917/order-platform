package com.ordering.platform.domain;

import com.ordering.platform.domain.entity.Restaurant;
import com.ordering.platform.domain.exception.RestaurantDomainException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RestaurantDomainServiceImpl implements RestaurantDomainService{

    @Override
    public void validateRestaurant(Restaurant restaurant) throws RestaurantDomainException {
        //validate restaurant.
        log.info("Restaurant with restaurant Id: {} has been initialized.", restaurant.getId());
    }
}
