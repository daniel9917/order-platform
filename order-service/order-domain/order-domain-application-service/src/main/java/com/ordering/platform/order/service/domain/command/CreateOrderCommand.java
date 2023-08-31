package com.ordering.platform.order.service.domain.command;

import com.ordering.platform.order.service.domain.entity.OrderStatus;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@ToString
@AllArgsConstructor
public class CreateOrderCommand implements Serializable {

    @NotNull
    private final UUID restaurantId;
    @NotNull
    private final UUID userId;
    @NotNull
    private final OrderStatus status;
    @NotNull
    private final List<CreateDishCommand> dishList;
}
