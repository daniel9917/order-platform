package com.ordering.platform.restaurant.service.domain.response;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CreateRestaurantResponse {
    @NotNull
    private final UUID restaurantId;
    @NotNull
    private final String message;
}
