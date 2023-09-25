package com.ordering.platform.dataaccess.adapter;

import com.ordering.platform.dataaccess.entity.OrderEntity;
import com.ordering.platform.dataaccess.mapper.OrderDataAccessMapper;
import com.ordering.platform.dataaccess.repository.OrderEntityManagerRepository;
import com.ordering.platform.order.service.domain.entity.Order;
import com.ordering.platform.order.service.domain.exception.OrderDomainException;
import com.ordering.platform.order.service.domain.ports.output.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

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

    @Override
    public Order findById(UUID orderId) {
        Optional<OrderEntity> optionalOrderEntity = orderEntityManagerRepository.findById(orderId);
        if (!optionalOrderEntity.isPresent()){
            throw new OrderDomainException("Order with Id: " + orderId.toString() + " is not found.");
        }
        return orderDataAccessMapper.orderEntityToOrder(optionalOrderEntity.get());
    }

    @Override
    public Order update(UUID orderId, Order order) {
        // Retrieve order from db and throw exception if not found
        Optional<OrderEntity> optionalOrderEntity = orderEntityManagerRepository.findById(orderId);
        if (!optionalOrderEntity.isPresent()){
            throw new OrderDomainException("Order with Id: " + orderId.toString() + " is not found.");
        }

        // Map retrieved entity to a domain object
        Order o = orderDataAccessMapper.orderEntityToOrder(optionalOrderEntity.get());

        // Set up update object
        Order updateOrder = new Order(orderId, o.getDish(), order.getOrderStatus(), o.getRestaurantId(), o.getUserId());

        // Update object against db
        OrderEntity updatedOrderEntity = orderEntityManagerRepository.update(orderDataAccessMapper.orderToOrderEntity(updateOrder));

        return orderDataAccessMapper.orderEntityToOrder(updatedOrderEntity);
    }

}
