package com.ordering.platform.order.service.domain;


import com.ordering.platform.order.service.domain.entity.Order;
import com.ordering.platform.order.service.domain.exception.OrderDomainException;

public interface OrderDomainService {
    void validateOrder(Order order) throws OrderDomainException;
}
