package com.ordering.platform.product.service.messaging.listener;

import com.ordering.platform.kafka.consumer.KafkaConsumer;
import com.ordering.platform.kafka.order.avro.model.OrderStatus;
import com.ordering.platform.kafka.order.avro.model.ProductApprovalRequestAvroModel;
import com.ordering.platform.kafka.order.avro.model.RestaurantApprovalRequestAvroModel;
import com.ordering.platform.product.service.domain.ProductValidator;
import com.ordering.platform.product.service.domain.dto.ProductApprovalRequest;
import com.ordering.platform.product.service.domain.dto.ProductApprovalResponse;
import com.ordering.platform.product.service.domain.ports.input.messaging.ProductApprovalRequestMessageListener;
import com.ordering.platform.product.service.domain.ports.output.messaging.ProductApprovalResponseMessagePublisher;
import com.ordering.platform.product.service.messaging.mapper.ProductMessagingDataMapper;
import com.ordering.platform.product.service.messaging.service.ProductMessagingService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Component
@AllArgsConstructor
public class ProductApprovalRequestKafkaListener implements KafkaConsumer<ProductApprovalRequestAvroModel> {

    private ProductApprovalRequestMessageListener productApprovalRequestMessageListener;

    private final ProductMessagingDataMapper productMessagingDataMapper;

    private final ProductValidator productValidator;

    private final ProductApprovalResponseMessagePublisher productApprovalResponseMessagePublisher;

    private final ProductMessagingService productMessagingService;


    @Override
    @KafkaListener(
            id = "${spring.kafka.consumer.product-approval-consumer-group-id}",
            topics = "${product-service.product-approval-request-topic-name}"
            )
    public void receive(
            @Payload List<ProductApprovalRequestAvroModel> messages,
            @Headers Map<String, Object> headers) {
        messages.forEach(productAvroModel -> {
            log.info("Received message {} from ProductApprovalRequest. ", productAvroModel.getId());
            productMessagingService.processIncomingMessage(productAvroModel);
        });
    }
}
