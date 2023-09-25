package com.ordering.platform.order.service.messaging.publisher;

import com.ordering.platform.kafka.order.avro.model.ProductApprovalRequestAvroModel;
import com.ordering.platform.kafka.producer.service.KafkaProducer;
import com.ordering.platform.order.service.domain.config.OrderServiceConfigData;
import com.ordering.platform.order.service.domain.entity.Order;
import com.ordering.platform.order.service.domain.ports.output.messaging.OrderCreatedProductApprovalRequestMessagePublisher;
import com.ordering.platform.order.service.messaging.mapper.OrderMessagingDataMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CreateOrderKafkaMessagePublisher implements OrderCreatedProductApprovalRequestMessagePublisher {

    private final OrderMessagingDataMapper orderMessagingDataMapper;
    private final OrderServiceConfigData orderServiceConfigData;
    private final KafkaProducer<String, ProductApprovalRequestAvroModel>  kafkaProducer;

    public CreateOrderKafkaMessagePublisher(OrderMessagingDataMapper orderMessagingDataMapper, OrderServiceConfigData orderServiceConfigData, KafkaProducer<String, ProductApprovalRequestAvroModel> kafkaProducer) {
        this.orderMessagingDataMapper = orderMessagingDataMapper;
        this.orderServiceConfigData = orderServiceConfigData;
        this.kafkaProducer = kafkaProducer;
    }

    @Override
    public void publishOrder(Order order) {
        String orderId = order.getId().toString();
        log.info("Publishing to product approval request order Id: " + orderId);

        try {
            ProductApprovalRequestAvroModel productApprovalResponseAvroModel = orderMessagingDataMapper.orderToProductApprovalRequest(order);

            log.info("Sending orderId {} to product validation", orderId);
            kafkaProducer.send(
                    orderServiceConfigData.getProductApprovalRequestTopicName(),
                    orderId,
                    productApprovalResponseAvroModel,
                    kafkaProducer.getKafkaCallback(
                            orderId,
                            orderServiceConfigData.getProductApprovalRequestTopicName(),
                            productApprovalResponseAvroModel
                    ));


            log.info("Order sent to kafka for id: {} and saga id: {}", orderId);
        } catch (Exception e){
            log.error("Error while sending order to kafka for order id: ", orderId);
        }
    }
}
