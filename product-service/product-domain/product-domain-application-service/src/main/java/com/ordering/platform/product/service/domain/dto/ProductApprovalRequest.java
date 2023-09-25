package com.ordering.platform.product.service.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class ProductApprovalRequest {
    private UUID id;
    private UUID userId;
    private UUID restaurantId;
    private OrderStatus orderStatus;
    private List<UUID> productList;
}
