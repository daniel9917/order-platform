package com.ordering.platform.order.service.dataaccess.mapper;

import com.ordering.platform.order.service.dataaccess.entity.OrderEntity;
import com.ordering.platform.order.service.domain.entity.Order;
import com.ordering.platform.order.service.domain.entity.OrderStatus;
import org.springframework.stereotype.Component;

@Component
public class OrderDataAccessMapper {
    public Order orderEntityToOrder(OrderEntity orderEntity) {
        return
                new Order(
                        orderEntity.getId(),
                        orderEntity.getDish(),
                        OrderStatus.valueOf(orderEntity.getStatus()));
    }

    public OrderEntity orderToOrderEntity (Order order) {
        return OrderEntity.builder()
                .id(order.getId())
                .status(order.getOrderStatus().toString())
                .dish(order.getDish())
                .build();
    }
}
