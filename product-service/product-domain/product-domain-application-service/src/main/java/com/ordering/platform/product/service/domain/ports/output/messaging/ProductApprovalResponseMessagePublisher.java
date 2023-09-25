package com.ordering.platform.product.service.domain.ports.output.messaging;

import com.ordering.platform.product.service.domain.dto.ProductApprovalRequest;
import com.ordering.platform.product.service.domain.dto.ProductApprovalResponse;

public interface ProductApprovalResponseMessagePublisher {
    void publishResponse(ProductApprovalResponse productApprovalResponse);
}
