package com.ordering.platform.dataaccess.adapter;

import com.ordering.platform.dataaccess.mapper.OrderDataAccessMapper;
import com.ordering.platform.dataaccess.repository.OrderEntityManagerRepository;
import com.ordering.platform.order.service.domain.entity.Order;
import com.ordering.platform.order.service.domain.ports.output.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderRepositoryImpl implements OrderRepository {

    private final OrderEntityManagerRepository orderEntityManagerRepository;

    private final OrderDataAccessMapper orderDataAccessMapper;

    @Autowired
    public OrderRepositoryImpl(OrderEntityManagerRepository orderEntityManagerRepository, OrderDataAccessMapper orderDataAccessMapper) {
        this.orderEntityManagerRepository = orderEntityManagerRepository;
        this.orderDataAccessMapper = orderDataAccessMapper;
    }

    @Override
    public Order createOrder(Order order) {
        return orderDataAccessMapper.orderEntityToOrder(
                orderEntityManagerRepository.save(orderDataAccessMapper.orderToOrderEntity(order)));
    }

}
