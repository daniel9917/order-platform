package com.ordering.platform.order.service.domain.mapper;

import com.ordering.platform.order.service.domain.command.CreateOrderCommand;
import com.ordering.platform.order.service.domain.entity.Order;
import com.ordering.platform.order.service.domain.response.CreateOrderResponse;
import org.springframework.stereotype.Component;

@Component
public class OrderDataMapper {
    public Order createOrderCommandToOrder (CreateOrderCommand createOrderCommand) {
        return
                new Order(
                        createOrderCommand.getId(),
                        createOrderCommand.getDish(),
                        createOrderCommand.getOrderStatus());
    }

    public CreateOrderResponse orderToCreateOrderResponse(Order order, String message){
        return new CreateOrderResponse(order.getId(), message);
    }

}
