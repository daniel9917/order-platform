package com.ordering.platform.order.service.messaging.publisher;

import com.google.common.util.concurrent.ListenableFuture;
import com.ordering.platform.kafka.order.avro.model.RestaurantApprovalRequestAvroModel;
import com.ordering.platform.kafka.producer.service.KafkaProducer;
import com.ordering.platform.order.service.domain.config.OrderServiceConfigData;
import com.ordering.platform.order.service.domain.entity.Order;
import com.ordering.platform.order.service.domain.ports.output.messaging.OrderCreatedRestaurantApprovalRequestMessagePublisher;
import com.ordering.platform.order.service.messaging.mapper.OrderMessagingDataMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import java.util.function.BiConsumer;

@Slf4j
@Component
public class CreateOrderKafkaMessagePublisher implements OrderCreatedRestaurantApprovalRequestMessagePublisher {

    private final OrderMessagingDataMapper orderMessagingDataMapper;
    private final OrderServiceConfigData orderServiceConfigData;
    private final KafkaProducer<String, RestaurantApprovalRequestAvroModel>  kafkaProducer;

    public CreateOrderKafkaMessagePublisher(OrderMessagingDataMapper orderMessagingDataMapper, OrderServiceConfigData orderServiceConfigData, KafkaProducer<String, RestaurantApprovalRequestAvroModel> kafkaProducer) {
        this.orderMessagingDataMapper = orderMessagingDataMapper;
        this.orderServiceConfigData = orderServiceConfigData;
        this.kafkaProducer = kafkaProducer;
    }

    @Override
    public void publishOrder(Order order) {
        String orderId = order.getId().toString();
        log.info("Publishing to restaurant approval request order Id: " + orderId);

        try {
            RestaurantApprovalRequestAvroModel restaurantApprovalRequestAvroModel = orderMessagingDataMapper.orderToRestaurantApprovalRequest(order);

            kafkaProducer.send(
                    orderServiceConfigData.getRestaurantApprovalRequestTopicName(),
                    orderId, restaurantApprovalRequestAvroModel,
                    kafkaProducer.getKafkaCallback(
                            orderId,
                            orderServiceConfigData.getRestaurantApprovalRequestTopicName(),
                            restaurantApprovalRequestAvroModel));


            log.info("Order sent to kafka for id: {} and saga id: {}", orderId);
        } catch (Exception e){
            log.error("Error while sending order to kafka for order id: ", orderId);
        }
    }
}
