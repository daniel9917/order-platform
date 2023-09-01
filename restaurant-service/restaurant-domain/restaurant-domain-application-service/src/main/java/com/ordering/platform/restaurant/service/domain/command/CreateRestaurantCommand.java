package com.ordering.platform.restaurant.service.domain.command;

public record CreateRestaurantCommand (String name, String address){

    public static final class Builder {
        private String name;
        private String address;

        public Builder name (String name) {
            this.name = name;
            return this;
        }

        public Builder address (String address) {
            this.address = address;
            return this;
        }

        public CreateRestaurantCommand build () {
            return new CreateRestaurantCommand(name, address);
        }
    }
}
