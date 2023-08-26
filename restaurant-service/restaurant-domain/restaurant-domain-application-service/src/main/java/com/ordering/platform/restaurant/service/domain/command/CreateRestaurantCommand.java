package com.ordering.platform.restaurant.service.domain.command;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CreateRestaurantCommand {

    @NotNull
    private final UUID id;
    @NotNull
    private final String name;
    @NotNull
    private final String address;
}
