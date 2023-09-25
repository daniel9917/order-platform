package com.ordering.platform.order.service.domain;

import com.ordering.platform.domain.event.EmptyEvent;
import com.ordering.platform.order.service.domain.dto.RestaurantApprovalResponse;
import com.ordering.platform.order.service.domain.event.OrderCookedEvent;
import com.ordering.platform.saga.SagaStep;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class OrderRestaurantApprovalSaga implements SagaStep<RestaurantApprovalResponse, OrderCookedEvent, EmptyEvent> {


    @Override
    public OrderCookedEvent process(RestaurantApprovalResponse data) {
        return null;
    }

    @Override
    public EmptyEvent rollabck(RestaurantApprovalResponse data) {
        return null;
    }
}
