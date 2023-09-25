package com.ordering.platform.product.service.domain.ports.input.messaging;

import com.ordering.platform.product.service.domain.dto.ProductApprovalRequest;

public interface ProductApprovalRequestMessageListener {
    void orderCreated (ProductApprovalRequest productApprovalRequest);
}
