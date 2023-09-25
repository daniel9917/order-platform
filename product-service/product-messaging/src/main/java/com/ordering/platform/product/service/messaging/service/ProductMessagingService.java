package com.ordering.platform.product.service.messaging.service;

import com.ordering.platform.kafka.order.avro.model.ProductApprovalRequestAvroModel;

public interface ProductMessagingService {
    void processIncomingMessage (ProductApprovalRequestAvroModel productApprovalRequestAvroModel);
}
