package com.ordering.platform.order.service.domain.ports.input.service;

import com.ordering.platform.order.service.domain.command.CreateOrderCommand;
import com.ordering.platform.order.service.domain.response.CreateOrderResponse;
import jakarta.validation.Valid;

public interface OrderApplicationService {
    CreateOrderResponse createOrder (@Valid CreateOrderCommand createOrderCommand);
}
