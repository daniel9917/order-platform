package com.ordering.platform.order.service.domain.ports.output.messaging;

import com.ordering.platform.order.service.domain.entity.Order;

public interface OrderCreatedProductApprovalRequestMessagePublisher {
    void publishOrder(Order order);
}
