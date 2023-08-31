package com.ordering.platform.order.service.domain.entity;

import com.ordering.platform.domain.entity.BaseEntity;

import java.util.List;
import java.util.UUID;

public class Order extends BaseEntity {

    private final List<Dish> dish;

    private final UUID restaurantId;
    private final UUID userId;

    private final OrderStatus orderStatus;

    public Order (UUID id, List<Dish> dish, OrderStatus orderStatus, UUID restaurantId, UUID userId) {
        super.setId(id);
        this.dish = dish;
        this.orderStatus = orderStatus;
        this.restaurantId = restaurantId;
        this.userId = userId;
    }

    public Order (List<Dish> dish, OrderStatus orderStatus, UUID restaurantId, UUID userId) {
        this.dish = dish;
        this.orderStatus = orderStatus;
        this.restaurantId = restaurantId;
        this.userId = userId;
    }

    public List<Dish> getDish() {
        return dish;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public UUID getRestaurantId() {
        return restaurantId;
    }

    public UUID getUserId() {
        return userId;
    }
}
