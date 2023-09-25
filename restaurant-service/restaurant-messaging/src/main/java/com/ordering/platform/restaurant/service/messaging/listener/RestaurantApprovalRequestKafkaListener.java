package com.ordering.platform.restaurant.service.messaging.listener;

import com.ordering.platform.kafka.consumer.KafkaConsumer;
import com.ordering.platform.kafka.order.avro.model.RestaurantApprovalRequestAvroModel;
import com.ordering.platform.kafka.order.avro.model.RestaurantApprovalResponseAvroModel;
import com.ordering.platform.restaurant.service.domain.dto.RestaurantApprovalRequest;
import com.ordering.platform.restaurant.service.messaging.mapper.RestaurantMessagingDataMapper;
import com.ordering.platform.restaurant.service.messaging.service.RestaurantMessagingService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Slf4j
@Component
@AllArgsConstructor
public class RestaurantApprovalRequestKafkaListener implements KafkaConsumer <RestaurantApprovalRequestAvroModel> {

    private final RestaurantMessagingDataMapper restaurantMessagingDataMapper;
    private final RestaurantMessagingService restaurantMessagingService;

    @Override
    @KafkaListener(
            id = "${spring.kafka.consumer.restaurant-approval-consumer-group-id}",
            topics = "${restaurant-service.restaurant-approval-request-topic-name}"
    )
    public void receive(
            @Payload List<RestaurantApprovalRequestAvroModel> messages,
            @Headers Map<String, Object> headers) {
        messages.forEach(restaurantApprovalRequestAvroModel -> {
            log.info("Received message from topic {}, processing...", headers.get(KafkaHeaders.RECEIVED_TOPIC));
            RestaurantApprovalRequest mappedRequest = restaurantMessagingDataMapper.restaurantApprovalRequestAvroModelToRestaurantApprovalRequest(restaurantApprovalRequestAvroModel);
            restaurantMessagingService.processIncomingMessage(mappedRequest);
        });

    }
}
