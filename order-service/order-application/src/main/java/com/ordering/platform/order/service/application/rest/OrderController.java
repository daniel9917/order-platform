package com.ordering.platform.order.service.application.rest;

import com.ordering.platform.order.service.domain.command.CreateOrderCommand;
import com.ordering.platform.order.service.domain.ports.input.service.OrderApplicationService;
import com.ordering.platform.order.service.domain.response.CreateOrderResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/orders")
public class OrderController {
    private final OrderApplicationService orderApplicationService;

    @Autowired
    public OrderController(OrderApplicationService orderApplicationService) {
        this.orderApplicationService = orderApplicationService;
    }

    @PostMapping(value = "/create")
    public ResponseEntity<CreateOrderResponse> createOrder (@RequestBody CreateOrderCommand createOrderCommand){
        return new ResponseEntity<>(orderApplicationService.createOrder(createOrderCommand), HttpStatus.CREATED);
    }
}
