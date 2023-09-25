package com.ordering.platform.restaurant.service.messaging.mapper;

import com.ordering.platform.kafka.order.avro.model.OrderStatus;
import com.ordering.platform.kafka.order.avro.model.RestaurantApprovalRequestAvroModel;
import com.ordering.platform.kafka.order.avro.model.RestaurantApprovalResponseAvroModel;
import com.ordering.platform.restaurant.service.domain.dto.RestaurantApprovalRequest;
import com.ordering.platform.restaurant.service.domain.dto.RestaurantApprovalResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class RestaurantMessagingDataMapper {

    public RestaurantApprovalRequest
    restaurantApprovalRequestAvroModelToRestaurantApprovalRequest(RestaurantApprovalRequestAvroModel restaurantApprovalRequestAvroModel){
        List<UUID> productIdList = new ArrayList<>();
        restaurantApprovalRequestAvroModel.getDishList().forEach(dish -> dish.getProductList().forEach(productIdList::add));

        return RestaurantApprovalRequest.builder()
                .id(restaurantApprovalRequestAvroModel.getId())
                .restaurantId(restaurantApprovalRequestAvroModel.getRestaurantId())
                .userId(restaurantApprovalRequestAvroModel.getUserId())
                .orderStatus(com.ordering.platform.restaurant.service.domain.dto.OrderStatus.valueOf(restaurantApprovalRequestAvroModel.getOrderStatus().toString()))
                .productList(productIdList)
                .build();
    }

    public RestaurantApprovalResponseAvroModel
    restaurantApprovalResponseToRestaurantApprovalResponseAvroModel (RestaurantApprovalResponse restaurantApprovalResponse) {

        return RestaurantApprovalResponseAvroModel.newBuilder()
                .setId(UUID.fromString(restaurantApprovalResponse.getId()))
                .setRestaurantId(UUID.fromString(restaurantApprovalResponse.getRestaurantId()))
                .setUserId(UUID.fromString(restaurantApprovalResponse.getUserId()))
                .setOrderStatus(OrderStatus.valueOf(restaurantApprovalResponse.getOrderStatus().toString()))
                .setDishList(List.of())
                .build();
    }
}
