package com.ordering.platform.order.service.domain.dto;

import com.ordering.platform.order.service.domain.entity.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class RestaurantApprovalResponse {
    private String id;
    private String userId;
    private String restaurantId;
    private OrderStatus orderStatus;
}
