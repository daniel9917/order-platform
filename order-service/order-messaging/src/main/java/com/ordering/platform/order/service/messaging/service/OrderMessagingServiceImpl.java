package com.ordering.platform.order.service.messaging.service;

import com.ordering.platform.kafka.order.avro.model.OrderApprovalStatus;
import com.ordering.platform.kafka.order.avro.model.ProductApprovalResponseAvroModel;
import com.ordering.platform.kafka.order.avro.model.RestaurantApprovalRequestAvroModel;
import com.ordering.platform.order.service.domain.entity.Order;
import com.ordering.platform.order.service.domain.ports.output.repository.OrderRepository;
import com.ordering.platform.order.service.messaging.mapper.OrderMessagingDataMapper;
import com.ordering.platform.order.service.messaging.publisher.RestaurantApprovalRequestKafkaMessagePublisher;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@AllArgsConstructor
public class OrderMessagingServiceImpl implements OrderMessagingService {

    private final OrderRepository orderRepository;
    private final OrderMessagingDataMapper orderMessagingDataMapper;
    private final RestaurantApprovalRequestKafkaMessagePublisher restaurantApprovalRequestKafkaMessagePublisher;

    @Override
    public void processIncomingMessage(ProductApprovalResponseAvroModel productApprovalRequestAvroModel) {
        UUID orderId = UUID.fromString(productApprovalRequestAvroModel.getOrderId());
        log.info("Processing {} order, updating order status.", productApprovalRequestAvroModel.getOrderApprovalStatus().toString());

        // updating order status
        Order order = orderMessagingDataMapper.productApprovalResponseToOrder(productApprovalRequestAvroModel);
        Order updatedOrder = orderRepository.update(orderId, order);

        if (productApprovalRequestAvroModel.getOrderApprovalStatus().equals(OrderApprovalStatus.APPROVED)){
            //Publishing to a restaurant topic
            restaurantApprovalRequestKafkaMessagePublisher.publishOrder(updatedOrder);
        }

    }

    @Override
    public void processIncomingMessage(RestaurantApprovalRequestAvroModel restaurantApprovalRequestAvroModel) {

    }
}
