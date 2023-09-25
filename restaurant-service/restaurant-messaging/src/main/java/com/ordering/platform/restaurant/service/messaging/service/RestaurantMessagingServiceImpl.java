package com.ordering.platform.restaurant.service.messaging.service;

import com.ordering.platform.kafka.order.avro.model.RestaurantApprovalRequestAvroModel;
import com.ordering.platform.restaurant.service.domain.dto.OrderStatus;
import com.ordering.platform.restaurant.service.domain.dto.RestaurantApprovalRequest;
import com.ordering.platform.restaurant.service.domain.dto.RestaurantApprovalResponse;
import com.ordering.platform.restaurant.service.messaging.publisher.RestaurantApprovalResponseKafkaMessagePublisher;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@AllArgsConstructor
public class RestaurantMessagingServiceImpl implements RestaurantMessagingService{

    private static final long cookInterval = 5000;

    private final RestaurantApprovalResponseKafkaMessagePublisher publisher;

    @Override
    public void processIncomingMessage(RestaurantApprovalRequest restaurantApprovalRequest) {
        log.info("Received orderId: {} at restaurantId: {}. Started Cooking.", restaurantApprovalRequest.getId(), restaurantApprovalRequest.getRestaurantId());
        RestaurantApprovalResponse restaurantApprovalResponse = cook(restaurantApprovalRequest);
        log.info("Successfully cooked orderId {}, sending message to broker.", restaurantApprovalResponse.getId());
        publisher.publishRestaurantResponse(restaurantApprovalResponse);
    }

    RestaurantApprovalResponse cook(RestaurantApprovalRequest restaurantApprovalRequest){
        String orderId = String.valueOf(restaurantApprovalRequest.getId());
        try{
            Thread.sleep(cookInterval);
            log.info("Finished cooking orderId {}", orderId);
            return RestaurantApprovalResponse
                    .builder()
                    .id(restaurantApprovalRequest.getId().toString())
                    .restaurantId(restaurantApprovalRequest.getRestaurantId().toString())
                    .userId(restaurantApprovalRequest.getUserId().toString())
                    .orderStatus(OrderStatus.COOKED)
                    .productList(restaurantApprovalRequest.getProductList())
                    .build();
        } catch (InterruptedException exception) {
           log.error("Error cooking orderId {}, retrying.", orderId);
           return cook(restaurantApprovalRequest);
        }

    }
}
