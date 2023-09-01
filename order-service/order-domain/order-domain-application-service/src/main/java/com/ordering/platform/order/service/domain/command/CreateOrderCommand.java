package com.ordering.platform.order.service.domain.command;

import com.ordering.platform.order.service.domain.entity.OrderStatus;

import java.util.List;
import java.util.UUID;

public record CreateOrderCommand(UUID restaurantId, UUID userId, OrderStatus status, List<CreateDishCommand> dishList) {
    public static final class Builder {
        private UUID restaurantId;
        private UUID userId;
        private OrderStatus status;
        private List<CreateDishCommand> dishList;

        public Builder restaurantId (UUID restaurantId) {
            this.restaurantId = restaurantId;
            return this;
        }

        public Builder userId (UUID userId) {
            this.userId = userId;
            return this;
        }

        public Builder status (OrderStatus status) {
            this.status = status;
            return this;
        }

        public Builder dishList (List<CreateDishCommand> dishList) {
            this.dishList = dishList;
            return this;
        }

        public CreateOrderCommand build () {
            return new CreateOrderCommand(this.restaurantId, this.restaurantId, this.status, this.dishList);
        }
    }
}
