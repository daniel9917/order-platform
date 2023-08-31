package com.ordering.platform.order.service.domain.command;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.UUID;

@Getter
@Builder
@ToString
@AllArgsConstructor
public class CreateDishCommand {
    @NotNull
    private final String name;
    @NotNull
    private final int quantity;
    @NotNull
    private final List<UUID> productList;
}
