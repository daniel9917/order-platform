package com.ordering.platform.order.service.messaging.service;

import com.ordering.platform.kafka.order.avro.model.ProductApprovalResponseAvroModel;
import com.ordering.platform.kafka.order.avro.model.RestaurantApprovalRequestAvroModel;

public interface OrderMessagingService {
    void processIncomingMessage (ProductApprovalResponseAvroModel productApprovalRequestAvroModel);

    void processIncomingMessage (RestaurantApprovalRequestAvroModel restaurantApprovalRequestAvroModel);
}
