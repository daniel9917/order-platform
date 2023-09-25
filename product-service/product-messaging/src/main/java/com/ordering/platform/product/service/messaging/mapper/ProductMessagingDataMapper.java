package com.ordering.platform.product.service.messaging.mapper;

import com.ordering.platform.kafka.order.avro.model.Dish;
import com.ordering.platform.kafka.order.avro.model.OrderApprovalStatus;
import com.ordering.platform.kafka.order.avro.model.ProductApprovalRequestAvroModel;
import com.ordering.platform.kafka.order.avro.model.ProductApprovalResponseAvroModel;
import com.ordering.platform.product.service.domain.dto.OrderStatus;
import com.ordering.platform.product.service.domain.dto.ProductApprovalRequest;
import com.ordering.platform.product.service.domain.dto.ProductApprovalResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class ProductMessagingDataMapper {

    public ProductApprovalRequest productApprovalRequestAvroModelToProductApprovalRequest (ProductApprovalRequestAvroModel productApprovalRequestAvroModel) {
        List<UUID> productIdList = new ArrayList<>();
        productApprovalRequestAvroModel.getDishList().forEach(dish -> productIdList.addAll(dish.getProductList()));

        return new ProductApprovalRequest(productApprovalRequestAvroModel.getId(),
                productApprovalRequestAvroModel.getUserId(),
                productApprovalRequestAvroModel.getRestaurantId(),
                OrderStatus.valueOf(productApprovalRequestAvroModel.getOrderStatus().toString()),
                productIdList);
    }

    public ProductApprovalResponseAvroModel productApprovalResponseToProductApprovalResponseAvroMode (ProductApprovalResponse productApprovalResponse){
        return ProductApprovalResponseAvroModel.newBuilder()
                .setOrderId(productApprovalResponse.getId())
                .setOrderApprovalStatus(OrderApprovalStatus.valueOf(productApprovalResponse.getOrderStatus().toString()))
                .setRestaurantId(productApprovalResponse.getRestaurantId())
                .setUserId(productApprovalResponse.getUserId())
                .setProductList(productApprovalResponse.getProductList())
                .build();
    }
}