package com.ordering.platform.product.service.domain.response;

import java.util.UUID;

public record CreateProductResponse (UUID productId, String message){

    public static final class Builder {
        private UUID productId;
        private String message;

        public Builder productId (UUID productId) {
            this.productId = productId;
            return this;
        }

        public Builder message (String message) {
            this.message = message;
            return this;
        }

        public CreateProductResponse build() {
            return new CreateProductResponse(productId, message);
        }
    }
}
