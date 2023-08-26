package com.ordering.application.order.service.application.rest;

import com.ordering.platform.restaurant.service.domain.command.CreateRestaurantCommand;
import com.ordering.platform.restaurant.service.domain.ports.input.service.RestaurantApplicationService;
import com.ordering.platform.restaurant.service.domain.response.CreateRestaurantResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/restaurants")
public class RestaurantController {

    private final RestaurantApplicationService restaurantApplicationService;

    @Autowired
    public RestaurantController(RestaurantApplicationService restaurantApplicationService) {
        this.restaurantApplicationService = restaurantApplicationService;
    }

    @GetMapping
    private String hello () {
        return "hi baby yanfri";
    }

    @PostMapping("/create")
    public ResponseEntity<CreateRestaurantResponse> createRestaurant(@RequestBody CreateRestaurantCommand createRestaurantCommand) {
        return new ResponseEntity<>(restaurantApplicationService.createRestaurant(createRestaurantCommand), HttpStatus.CREATED);
    }
}
