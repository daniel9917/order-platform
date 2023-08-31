package com.ordering.platform.restaurant.service.domain;

import com.ordering.platform.domain.RestaurantDomainService;
import com.ordering.platform.domain.entity.Restaurant;
import com.ordering.platform.domain.exception.RestaurantDomainException;
import com.ordering.platform.restaurant.service.domain.command.CreateRestaurantCommand;
import com.ordering.platform.restaurant.service.domain.mapper.RestaurantDataMapper;
import com.ordering.platform.restaurant.service.domain.ports.input.service.RestaurantApplicationService;
import com.ordering.platform.restaurant.service.domain.ports.output.repository.RestaurantRepository;
import com.ordering.platform.restaurant.service.domain.response.CreateRestaurantResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

@Slf4j
@Service
@Validated
@AllArgsConstructor
public class RestaurantApplicationServiceImpl implements RestaurantApplicationService {

    private final RestaurantDataMapper restaurantDataMapper;

    private final RestaurantRepository restaurantRepository;

    private final RestaurantDomainService restaurantDomainService;

    @Override
    @Transactional
    public CreateRestaurantResponse createRestaurant(CreateRestaurantCommand createRestaurantCommand) {
        Restaurant mappedRestaurant = restaurantDataMapper.createRestaurantCommandToRestaurant(createRestaurantCommand);
        restaurantDomainService.validateRestaurant(mappedRestaurant);
        Restaurant persistedRestaurant = restaurantRepository.createRestaurant(mappedRestaurant);
        if (persistedRestaurant == null) {
            log.error("Could not create restaurant with id: {}", createRestaurantCommand);
            throw new RestaurantDomainException("Could not save restaurant id: " + createRestaurantCommand);
        }
        log.info("Successfully created restaurant with id: {}", createRestaurantCommand);
        return restaurantDataMapper.restaurantToCreateRestaurantResponse(persistedRestaurant, createRestaurantCommand.toString());
    }
}
