package com.ordering.platform.restaurant.service.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class RestaurantApprovalRequest {

    private UUID id;
    private UUID userId;
    private UUID restaurantId;
    private OrderStatus orderStatus;
    private List<UUID> productList;
}

