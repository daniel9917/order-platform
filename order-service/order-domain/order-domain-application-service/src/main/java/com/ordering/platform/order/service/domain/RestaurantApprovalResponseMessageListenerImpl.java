package com.ordering.platform.order.service.domain;

import com.ordering.platform.order.service.domain.dto.RestaurantApprovalResponse;
import com.ordering.platform.order.service.domain.entity.Order;
import com.ordering.platform.order.service.domain.entity.OrderStatus;
import com.ordering.platform.order.service.domain.mapper.OrderDataMapper;
import com.ordering.platform.order.service.domain.ports.input.messaging.RestaurantApprovalResponseMessageListener;
import com.ordering.platform.order.service.domain.ports.output.repository.OrderRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@AllArgsConstructor
public class RestaurantApprovalResponseMessageListenerImpl implements RestaurantApprovalResponseMessageListener {

    private final OrderRepository orderRepository;
    private final OrderDataMapper orderDataMapper;



    @Override
    public void orderCompleted(RestaurantApprovalResponse restaurantApprovalResponse) {
        String orderId = restaurantApprovalResponse.getId();
        log.info("Order received, marking status cooked for orderId: {}", orderId);
        Order currentOrder = orderRepository.findById(UUID.fromString(orderId));
        Order updateOrder = new Order(currentOrder.getId(), currentOrder.getDish(), OrderStatus.COOKED, currentOrder.getRestaurantId(), currentOrder.getUserId());
        orderRepository.update(UUID.fromString(orderId), updateOrder);
        log.info("Order id {} was completed, notifying customer Id {} ", orderId, restaurantApprovalResponse.getUserId());
    }
}
