package com.ordering.platform.order.service.messaging.listener;

import com.ordering.platform.kafka.consumer.KafkaConsumer;
import com.ordering.platform.kafka.order.avro.model.OrderStatus;
import com.ordering.platform.kafka.order.avro.model.RestaurantApprovalResponseAvroModel;
import com.ordering.platform.order.service.domain.ports.input.messaging.RestaurantApprovalResponseMessageListener;
import com.ordering.platform.order.service.messaging.mapper.OrderMessagingDataMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Slf4j
@Component
public class RestaurantApprovalResponseKafkaListener implements KafkaConsumer<RestaurantApprovalResponseAvroModel> {
    private final RestaurantApprovalResponseMessageListener restaurantApprovalResponseMessageListener;
    private final OrderMessagingDataMapper orderMessagingDataMapper;

    public RestaurantApprovalResponseKafkaListener(RestaurantApprovalResponseMessageListener restaurantApprovalResponseMessageListener, OrderMessagingDataMapper orderMessagingDataMapper) {
        this.restaurantApprovalResponseMessageListener = restaurantApprovalResponseMessageListener;
        this.orderMessagingDataMapper = orderMessagingDataMapper;
    }

    @Override
    @KafkaListener(
            id = "${spring.kafka.consumer.restaurant-approval-consumer-group-id}",
            topics = "${order-service.restaurant-approval-response-topic-name}")
    public void receive(
            @Payload List<RestaurantApprovalResponseAvroModel> messages,
            @Headers Map<String, Object> headers) {
        messages.forEach(orderAvroModel ->
        {
            if (orderAvroModel.getOrderStatus().toString() == OrderStatus.COOKED.toString()) {
                log.info("Processing successful cook for order id: ", orderAvroModel.getId());
                restaurantApprovalResponseMessageListener.orderCompleted(
                        orderMessagingDataMapper.restaurantApprovalResponseAvroModelToRestaurantApprovalResponse(orderAvroModel));
            }
        });
    }
}
