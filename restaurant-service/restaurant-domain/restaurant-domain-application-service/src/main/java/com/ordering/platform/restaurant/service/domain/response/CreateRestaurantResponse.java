package com.ordering.platform.restaurant.service.domain.response;

import java.util.UUID;

public record CreateRestaurantResponse (UUID restaurantId, String message){

    public static final class Builder {
        private UUID restaurantId;
        private String message;

        public Builder restaurantId (UUID restaurantId) {
            this.restaurantId = restaurantId;
            return this;
        }

        public Builder message (String message) {
            this.message = message;
            return this;
        }

        public CreateRestaurantResponse build () {
            return new CreateRestaurantResponse (restaurantId, message);
        }
    }
}
