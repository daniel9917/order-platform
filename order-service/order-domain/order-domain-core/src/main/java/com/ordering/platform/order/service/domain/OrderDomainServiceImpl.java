package com.ordering.platform.order.service.domain;

import com.ordering.platform.order.service.domain.entity.Order;
import com.ordering.platform.order.service.domain.exception.OrderDomainException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OrderDomainServiceImpl implements OrderDomainService{

    @Override
    public void validateOrder(Order order) throws OrderDomainException {
        //validate customer.
        log.info("Order with order Id: {} has been initialized.", order.getId());
    }
}
