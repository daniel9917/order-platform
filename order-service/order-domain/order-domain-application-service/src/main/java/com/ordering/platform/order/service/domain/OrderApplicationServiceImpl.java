package com.ordering.platform.order.service.domain;

import com.ordering.platform.order.service.domain.command.CreateOrderCommand;
import com.ordering.platform.order.service.domain.entity.Order;
import com.ordering.platform.order.service.domain.exception.OrderDomainException;
import com.ordering.platform.order.service.domain.mapper.OrderDataMapper;
import com.ordering.platform.order.service.domain.ports.input.service.OrderApplicationService;
import com.ordering.platform.order.service.domain.ports.output.messaging.OrderCreatedRestaurantApprovalRequestMessagePublisher;
import com.ordering.platform.order.service.domain.ports.output.repository.OrderRepository;
import com.ordering.platform.order.service.domain.response.CreateOrderResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

@Slf4j
@Service
@Validated
public class OrderApplicationServiceImpl implements OrderApplicationService {

    private final OrderDataMapper orderDataMapper;

    private final OrderRepository orderRepository;

    private final OrderCreatedRestaurantApprovalRequestMessagePublisher publisher;

    private final OrderDomainService orderDomainService;

    @Autowired
    public OrderApplicationServiceImpl(OrderDataMapper orderDataMapper, OrderRepository orderRepository, OrderCreatedRestaurantApprovalRequestMessagePublisher publisher, OrderDomainService orderDomainService) {
        this.orderDataMapper = orderDataMapper;
        this.orderRepository = orderRepository;
        this.publisher = publisher;
        this.orderDomainService = orderDomainService;
    }

    @Override
    @Transactional
    public CreateOrderResponse createOrder(CreateOrderCommand createOrderCommand) {
        Order order = orderDataMapper.createOrderCommandToOrder(createOrderCommand);
        orderDomainService.validateOrder(order);
        Order persistedOrder = orderRepository.createOrder(order);
        if (persistedOrder == null) {
            log.error("Could not create order: {}", createOrderCommand);
            throw new OrderDomainException("Could not save order: " + createOrderCommand);
        }
        publisher.publishOrder(persistedOrder);
        log.info("Successfully created order with Id: " + order.getId());
        return orderDataMapper.orderToCreateOrderResponse(persistedOrder, createOrderCommand.toString());
    }
}
