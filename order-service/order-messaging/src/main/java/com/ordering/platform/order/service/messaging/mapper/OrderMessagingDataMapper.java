package com.ordering.platform.order.service.messaging.mapper;

import com.ordering.platform.kafka.order.avro.model.Dish;
import com.ordering.platform.kafka.order.avro.model.OrderStatus;
import com.ordering.platform.kafka.order.avro.model.ProductApprovalRequestAvroModel;
import com.ordering.platform.kafka.order.avro.model.ProductApprovalResponseAvroModel;
import com.ordering.platform.kafka.order.avro.model.RestaurantApprovalRequestAvroModel;
import com.ordering.platform.kafka.order.avro.model.RestaurantApprovalResponseAvroModel;
import com.ordering.platform.order.service.domain.dto.RestaurantApprovalResponse;
import com.ordering.platform.order.service.domain.entity.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class OrderMessagingDataMapper {
    public ProductApprovalRequestAvroModel orderToProductApprovalRequest (Order order){
        return ProductApprovalRequestAvroModel.newBuilder()
                .setId(order.getId())
                .setOrderStatus(OrderStatus.valueOf(order.getOrderStatus().toString()))
                .setUserId(order.getUserId())
                .setRestaurantId(order.getRestaurantId())
                .setDishList(order.getDish().stream().map(dish -> Dish.newBuilder()
                        .setName(dish.getName())
                        .setQuantity(dish.getQuantity())
                        .setProductList(dish.getProductList())
                        .build()).toList())
                .build();
    }

    public Order productApprovalResponseToOrder(ProductApprovalResponseAvroModel productApprovalResponseAvroModel) {
        return new Order(
                UUID.fromString(productApprovalResponseAvroModel.getOrderId()),
                List.of(),
                com.ordering.platform.order.service.domain.entity.OrderStatus.valueOf(productApprovalResponseAvroModel.getOrderApprovalStatus().toString()),
                UUID.fromString(productApprovalResponseAvroModel.getRestaurantId()),
                UUID.fromString(productApprovalResponseAvroModel.getUserId())
        );

    }

    public RestaurantApprovalRequestAvroModel orderToRestaurantApprovalRequest (Order order){
        return RestaurantApprovalRequestAvroModel.newBuilder()
                .setId(order.getId())
                .setOrderStatus(OrderStatus.valueOf(order.getOrderStatus().toString()))
                .setUserId(order.getUserId())
                .setRestaurantId(order.getRestaurantId())
                .setDishList(order.getDish().stream().map(dish -> Dish.newBuilder()
                        .setName(dish.getName())
                        .setQuantity(dish.getQuantity())
                        .setProductList(dish.getProductList())
                        .build()).toList())
                .build();
    }

    public RestaurantApprovalResponse restaurantApprovalResponseAvroModelToRestaurantApprovalResponse (RestaurantApprovalResponseAvroModel restaurantApprovalResponseAvroModel) {
        return RestaurantApprovalResponse
                .builder()
                .id(restaurantApprovalResponseAvroModel.getId().toString())
                .orderStatus(com.ordering.platform.order.service.domain.entity.OrderStatus.valueOf(restaurantApprovalResponseAvroModel.getOrderStatus().toString()))
                .userId(restaurantApprovalResponseAvroModel.getUserId().toString())
                .restaurantId(restaurantApprovalResponseAvroModel.getRestaurantId().toString())
                .build();
    }
}
