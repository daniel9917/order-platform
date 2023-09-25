package com.ordering.platform.order.service.messaging.listener;

import com.ordering.platform.kafka.consumer.KafkaConsumer;
import com.ordering.platform.kafka.order.avro.model.ProductApprovalResponseAvroModel;
import com.ordering.platform.order.service.domain.ports.input.messaging.ProductApprovalResponseMessageListener;
import com.ordering.platform.order.service.messaging.mapper.OrderMessagingDataMapper;
import com.ordering.platform.order.service.messaging.service.OrderMessagingService;
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
public class ProductApprovalResponseKafkaListener implements KafkaConsumer<ProductApprovalResponseAvroModel> {

    private final ProductApprovalResponseMessageListener productApprovalResponseMessageListener;
    private final OrderMessagingDataMapper orderMessagingDataMapper;
    private final OrderMessagingService orderMessagingService;

    @Override
    @KafkaListener(
            id = "${spring.kafka.consumer.product-approval-consumer-group-id}",
            topics = "${order-service.product-approval-response-topic-name}"
    )
    public void receive(
            @Payload List<ProductApprovalResponseAvroModel> messages,
            @Headers Map<String, Object> headers) {
        messages.forEach(productApprovalResponseAvroModel -> {
            log.info("Received message from topic {}, processing...", headers.get(KafkaHeaders.RECEIVED_TOPIC));
            orderMessagingService.processIncomingMessage(productApprovalResponseAvroModel);
        });

    }
}
