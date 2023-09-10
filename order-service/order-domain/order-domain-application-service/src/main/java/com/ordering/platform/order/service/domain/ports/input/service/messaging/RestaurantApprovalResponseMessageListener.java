package com.ordering.platform.order.service.domain.ports.input.service.messaging;

import com.ordering.platform.order.service.domain.dto.RestaurantApprovalResponse;

public interface RestaurantApprovalResponseMessageListener {
    void orderCompleted (RestaurantApprovalResponse restaurantApprovalResponse);
}
