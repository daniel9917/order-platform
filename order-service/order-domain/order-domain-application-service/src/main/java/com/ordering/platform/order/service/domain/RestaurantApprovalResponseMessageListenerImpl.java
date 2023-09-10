package com.ordering.platform.order.service.domain;

import com.ordering.platform.order.service.domain.dto.RestaurantApprovalResponse;
import com.ordering.platform.order.service.domain.ports.input.service.messaging.RestaurantApprovalResponseMessageListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RestaurantApprovalResponseMessageListenerImpl implements RestaurantApprovalResponseMessageListener {
    @Override
    public void orderCompleted(RestaurantApprovalResponse restaurantApprovalResponse) {
        log.info("Order id {} was completed, notifying customer Id {} ", restaurantApprovalResponse.getId(), restaurantApprovalResponse.getUserId());
    }
}
