package com.ordering.platform.order.service.domain.ports.output.repository;

import com.ordering.platform.order.service.domain.entity.Order;

import java.util.UUID;

public interface OrderRepository {
    Order createOrder (Order order);

    Order findById (UUID orderId);

    Order update (UUID orderId, Order order);

}
