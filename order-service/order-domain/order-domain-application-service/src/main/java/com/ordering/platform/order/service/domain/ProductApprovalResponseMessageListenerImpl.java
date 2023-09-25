package com.ordering.platform.order.service.domain;

import com.ordering.platform.order.service.domain.dto.RestaurantApprovalResponse;
import com.ordering.platform.order.service.domain.ports.input.messaging.ProductApprovalResponseMessageListener;
import com.ordering.platform.order.service.domain.ports.input.messaging.RestaurantApprovalResponseMessageListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@Component
public class ProductApprovalResponseMessageListenerImpl implements ProductApprovalResponseMessageListener {

    @Override
    public void orderApproved(RestaurantApprovalResponse restaurantApprovalResponse) {
        log.info("OrderId: {} was approved by product service, sending to Restaurant Service. UserId: {} ", restaurantApprovalResponse.getId(), restaurantApprovalResponse.getUserId());
    }
}
