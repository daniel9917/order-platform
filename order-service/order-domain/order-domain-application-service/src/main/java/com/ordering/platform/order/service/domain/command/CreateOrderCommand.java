package com.ordering.platform.order.service.domain.command;

import com.ordering.platform.order.service.domain.entity.Dish;
import com.ordering.platform.order.service.domain.entity.OrderStatus;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CreateOrderCommand {

    @NotNull
    private final UUID id;
    @NotNull
    private final OrderStatus orderStatus;
    private final Dish dish;
}
