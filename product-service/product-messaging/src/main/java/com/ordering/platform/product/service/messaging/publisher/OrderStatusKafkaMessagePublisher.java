package com.ordering.platform.product.service.messaging.publisher;

import com.ordering.platform.kafka.order.avro.model.ProductApprovalResponseAvroModel;
import com.ordering.platform.kafka.producer.service.KafkaProducer;
import com.ordering.platform.product.service.domain.config.ProductServiceConfigData;
import com.ordering.platform.product.service.domain.dto.ProductApprovalResponse;
import com.ordering.platform.product.service.domain.ports.output.messaging.ProductApprovalResponseMessagePublisher;
import com.ordering.platform.product.service.messaging.mapper.ProductMessagingDataMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class OrderStatusKafkaMessagePublisher implements ProductApprovalResponseMessagePublisher {
    private final ProductMessagingDataMapper productMessagingDataMapper;
    private final ProductServiceConfigData productServiceConfigData;
    private final KafkaProducer<String, ProductApprovalResponseAvroModel> kafkaProducer;

    @Override
    public void publishResponse(ProductApprovalResponse productApprovalResponse) {
        String orderId = productApprovalResponse.getId();
        log.info("Publishing response to Order status for order Id {}", productApprovalResponse.getId());

        try {
            ProductApprovalResponseAvroModel productApprovalResponseAvroModel = productMessagingDataMapper.productApprovalResponseToProductApprovalResponseAvroMode(productApprovalResponse);

            log.info("Sending product-approval-response for orderId: {} ", orderId);

            kafkaProducer.send(
                    productServiceConfigData.getProductApprovalResponseTopicName(),
                    orderId,
                    productApprovalResponseAvroModel,
                    kafkaProducer.getKafkaCallback(
                            orderId,
                            productServiceConfigData.getProductApprovalResponseTopicName(),
                            productApprovalResponseAvroModel
                    ));

            log.info("Product approval response message sent to topic.");
        } catch (Exception e) {
            log.error("Error while sending order to kafka for orderId: {}", orderId);
        }
    }
}
