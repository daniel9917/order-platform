package com.ordering.platform.order.service.domain.ports.output.repository;

import com.ordering.platform.order.service.domain.entity.Order;

public interface OrderRepository {
    Order createOrder (Order order);
}
