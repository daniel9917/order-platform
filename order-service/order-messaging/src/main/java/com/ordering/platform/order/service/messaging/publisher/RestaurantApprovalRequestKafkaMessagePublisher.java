package com.ordering.platform.order.service.messaging.publisher;

import com.ordering.platform.kafka.order.avro.model.ProductApprovalRequestAvroModel;
import com.ordering.platform.kafka.order.avro.model.ProductApprovalResponseAvroModel;
import com.ordering.platform.kafka.order.avro.model.RestaurantApprovalRequestAvroModel;
import com.ordering.platform.kafka.producer.service.KafkaProducer;
import com.ordering.platform.order.service.domain.config.OrderServiceConfigData;
import com.ordering.platform.order.service.domain.entity.Order;
import com.ordering.platform.order.service.domain.ports.output.messaging.OrderCreatedRestaurantApprovalRequestMessagePublisher;
import com.ordering.platform.order.service.messaging.mapper.OrderMessagingDataMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class RestaurantApprovalRequestKafkaMessagePublisher implements OrderCreatedRestaurantApprovalRequestMessagePublisher {

    private final OrderMessagingDataMapper orderMessagingDataMapper;

    private final OrderServiceConfigData orderServiceConfigData;

    private final KafkaProducer<String, RestaurantApprovalRequestAvroModel> kafkaProducer;

    @Override
    public void publishOrder(Order order) {
        String orderId = order.getId().toString();
        log.info("Publishing to restaurant approval request order Id: " + orderId);

        try {
            RestaurantApprovalRequestAvroModel restaurantApprovalRequestAvroModel = orderMessagingDataMapper.orderToRestaurantApprovalRequest(order);

            log.info("Sending orderId {} to product validation", orderId);
            kafkaProducer.send(
                    orderServiceConfigData.getRestaurantApprovalRequestTopicName(),
                    orderId,
                    restaurantApprovalRequestAvroModel,
                    kafkaProducer.getKafkaCallback(
                            orderId,
                            orderServiceConfigData.getProductApprovalRequestTopicName(),
                            restaurantApprovalRequestAvroModel
                    ));


            log.info("Order sent to kafka for id: {} and saga id: {}", orderId);
        } catch (Exception e){
            log.error("Error while sending order to kafka for order id: ", orderId);
        }

    }
}
