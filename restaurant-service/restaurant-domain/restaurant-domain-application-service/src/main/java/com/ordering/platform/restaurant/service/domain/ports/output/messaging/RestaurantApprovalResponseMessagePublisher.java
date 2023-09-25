package com.ordering.platform.restaurant.service.domain.ports.output.messaging;

import com.ordering.platform.restaurant.service.domain.dto.RestaurantApprovalRequest;
import com.ordering.platform.restaurant.service.domain.dto.RestaurantApprovalResponse;

public interface RestaurantApprovalResponseMessagePublisher {
    void publishRestaurantResponse (RestaurantApprovalResponse restaurantApprovalRequest);
}
