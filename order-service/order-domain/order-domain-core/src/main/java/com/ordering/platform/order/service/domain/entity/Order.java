package com.ordering.platform.order.service.domain.entity;

import com.ordering.platform.domain.entity.BaseEntity;

import java.util.UUID;

public class Order extends BaseEntity {

    private final Dish dish;

    private final OrderStatus orderStatus;

    public Order (UUID id, Dish dish, OrderStatus orderStatus) {
        super.setId(id);
        this.dish = dish;
        this.orderStatus = orderStatus;
    }

    public Dish getDish() {
        return dish;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }
}
