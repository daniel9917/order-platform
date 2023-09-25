package com.ordering.platform.restaurant.service.messaging.publisher;

import com.ordering.platform.kafka.order.avro.model.RestaurantApprovalResponseAvroModel;
import com.ordering.platform.kafka.producer.service.KafkaProducer;
import com.ordering.platform.restaurant.service.domain.config.RestaurantServiceConfigData;
import com.ordering.platform.restaurant.service.domain.dto.RestaurantApprovalRequest;
import com.ordering.platform.restaurant.service.domain.dto.RestaurantApprovalResponse;
import com.ordering.platform.restaurant.service.domain.ports.output.messaging.RestaurantApprovalResponseMessagePublisher;
import com.ordering.platform.restaurant.service.messaging.mapper.RestaurantMessagingDataMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class RestaurantApprovalResponseKafkaMessagePublisher implements RestaurantApprovalResponseMessagePublisher {

    private final RestaurantMessagingDataMapper restaurantMessagingDataMapper;
    private final RestaurantServiceConfigData restaurantServiceConfigData;
    private final KafkaProducer<String, RestaurantApprovalResponseAvroModel> kafkaProducer;

    @Override
    public void publishRestaurantResponse(RestaurantApprovalResponse restaurantApprovalResponse) {
        String orderId = restaurantApprovalResponse.getId();
        log.info("Publishing cooking response to restaurant approval response for order-id: {}", orderId);
        try {
            RestaurantApprovalResponseAvroModel restaurantApprovalResponseAvroModel = restaurantMessagingDataMapper.restaurantApprovalResponseToRestaurantApprovalResponseAvroModel(restaurantApprovalResponse);

            kafkaProducer.send(
                    restaurantServiceConfigData.getRestaurantApprovalResponseTopicName(),
                    orderId,
                    restaurantApprovalResponseAvroModel,
                    kafkaProducer.getKafkaCallback(
                            orderId,
                            restaurantServiceConfigData.getRestaurantApprovalResponseTopicName(),
                            restaurantApprovalResponseAvroModel
                    )
            );
        } catch (Exception e) {
            log.error("Error while sending order restaurant-response to kafka for order id: ", orderId);
        }
    }

    public RestaurantMessagingDataMapper getRestaurantMessagingDataMapper(){
        return this.restaurantMessagingDataMapper;
    }
}
