package com.ordering.platform.restaurant.service.messaging.service;

import com.ordering.platform.kafka.order.avro.model.RestaurantApprovalRequestAvroModel;
import com.ordering.platform.restaurant.service.domain.dto.RestaurantApprovalRequest;

public interface RestaurantMessagingService {
    void processIncomingMessage (RestaurantApprovalRequest restaurantApprovalRequest);
}
