package com.ordering.platform.restaurant.service.domain;

import com.ordering.platform.restaurant.service.domain.dto.RestaurantApprovalResponse;
import com.ordering.platform.restaurant.service.domain.ports.input.messaging.RestaurantApprovalRequestMessageListener;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class RestaurantApprovalRequestMessageListenerImpl implements RestaurantApprovalRequestMessageListener {

    @Override
    public void publishResponse(RestaurantApprovalResponse restaurantApprovalResponse) {

    }
}
