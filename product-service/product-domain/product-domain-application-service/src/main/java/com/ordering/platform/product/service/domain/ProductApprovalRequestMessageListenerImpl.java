package com.ordering.platform.product.service.domain;

import com.ordering.platform.product.service.domain.dto.ProductApprovalRequest;
import com.ordering.platform.product.service.domain.ports.input.messaging.ProductApprovalRequestMessageListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ProductApprovalRequestMessageListenerImpl implements ProductApprovalRequestMessageListener {

//    private final

    @Override
    public void orderCreated(ProductApprovalRequest productApprovalRequest) {
        log.info("Order Id {} was created, notifying order with customer Id {}",
                productApprovalRequest.getId(),
                productApprovalRequest.getUserId());

    }
}
