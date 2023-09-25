package com.ordering.platform.order.service.domain.dto;

import com.ordering.platform.order.service.domain.entity.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class ProductApprovalResponse {
    private String id;
    private String userId;
    private String restaurantId;
    private OrderStatus orderStatus;
}
