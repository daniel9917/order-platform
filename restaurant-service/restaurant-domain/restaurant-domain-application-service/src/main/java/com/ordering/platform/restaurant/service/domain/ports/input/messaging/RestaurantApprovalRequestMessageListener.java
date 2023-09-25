package com.ordering.platform.restaurant.service.domain.ports.input.messaging;

import com.ordering.platform.restaurant.service.domain.dto.RestaurantApprovalResponse;

public interface RestaurantApprovalRequestMessageListener {
    void publishResponse(RestaurantApprovalResponse restaurantApprovalResponse);
}
