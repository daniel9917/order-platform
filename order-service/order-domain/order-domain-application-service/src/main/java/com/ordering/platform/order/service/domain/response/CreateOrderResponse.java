package com.ordering.platform.order.service.domain.response;

import java.util.UUID;

public record CreateOrderResponse(UUID orderId, String message) {
    public static final class Builder {
        UUID orderId;
        String message;
        public Builder orderId (UUID orderId){
            this.orderId = orderId;
            return this;
        }
        public Builder message (String message){
            this.message = message;
            return this;
        }

        public CreateOrderResponse build(){
            return new CreateOrderResponse(orderId, message);
        }
    }
}
