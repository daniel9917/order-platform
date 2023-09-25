package com.ordering.platform.product.service.messaging.service;


import com.ordering.platform.kafka.order.avro.model.OrderStatus;
import com.ordering.platform.kafka.order.avro.model.ProductApprovalRequestAvroModel;
import com.ordering.platform.product.service.domain.ProductValidator;
import com.ordering.platform.product.service.domain.dto.ProductApprovalRequest;
import com.ordering.platform.product.service.domain.dto.ProductApprovalResponse;
import com.ordering.platform.product.service.domain.ports.input.messaging.ProductApprovalRequestMessageListener;
import com.ordering.platform.product.service.domain.ports.output.messaging.ProductApprovalResponseMessagePublisher;
import com.ordering.platform.product.service.messaging.mapper.ProductMessagingDataMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Slf4j
@Service
@AllArgsConstructor
public class ProductMessagingServiceImpl implements ProductMessagingService{

    private final ProductApprovalRequestMessageListener productApprovalRequestMessageListener;

    private final ProductMessagingDataMapper productMessagingDataMapper;

    private final ProductValidator productValidator;

    private final ProductApprovalResponseMessagePublisher productApprovalResponseMessagePublisher;
    @Override
    public void processIncomingMessage(ProductApprovalRequestAvroModel productAvroModel) {
        ProductApprovalRequest productApprovalRequest =
                productMessagingDataMapper.productApprovalRequestAvroModelToProductApprovalRequest(productAvroModel);

        if (productAvroModel.getOrderStatus().toString() == OrderStatus.PROCESSING.toString()) {
            log.info("Received order Id {} queued for product approval. Validation in process. ", productAvroModel.getId());
            productApprovalRequestMessageListener.orderCreated(
                    productMessagingDataMapper.productApprovalRequestAvroModelToProductApprovalRequest(productAvroModel));
        }

        ProductApprovalResponse productResponse = ProductApprovalResponse.builder()
                .id(productApprovalRequest.getId().toString())
                .orderStatus(com.ordering.platform.product.service.domain.dto.OrderStatus.APPROVED)
                .userId(productApprovalRequest.getUserId().toString())
                .restaurantId(productApprovalRequest.getRestaurantId().toString())
                .productList(productApprovalRequest.getProductList())
                .build();

        try {
            Map<UUID, Integer> productCount = countProducts(productApprovalRequest.getProductList());
            productValidator.validateProducts(productCount);
            // Add logic to set order status CREATED, and publish it to RestaurantApprovalRequest topic
            productResponse.setOrderStatus(com.ordering.platform.product.service.domain.dto.OrderStatus.APPROVED);
            productApprovalResponseMessagePublisher.publishResponse(productResponse);
        } catch (RuntimeException exception){
            log.error("Unable to complete orderId {} due to {}. Cancelling order." , productApprovalRequest.getId(), exception.getMessage());
            productResponse.setOrderStatus(com.ordering.platform.product.service.domain.dto.OrderStatus.CANCELED);
            productApprovalResponseMessagePublisher.publishResponse(productResponse);
            log.info("Published cancelled response to product-approval-response topic for orderId: {}", productApprovalRequest.getId().toString());
        }

    }

    public Map<UUID, Integer> countProducts (List<UUID> productz) {
        Map<UUID, Integer> countProducts = new HashMap<>();
        productz.forEach(uuid -> {
            if (countProducts.containsKey(uuid)){
                countProducts.put(uuid, countProducts.get(uuid) + 1);
            } else {
                countProducts.put(uuid, 1);
            }
        });
        return countProducts;
    }
}
