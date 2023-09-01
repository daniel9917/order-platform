package com.ordering.platform.order.service.domain.command;

import java.util.List;
import java.util.UUID;

public record CreateDishCommand(String name, int quantity, List<UUID> productList) {
    public static final class Builder {
        private String name;
        private int quantity;
        private List<UUID> productList;

        public Builder name (String name) {
            this.name = name;
            return this;
        }

        public Builder status (int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder productList (List<UUID> productList) {
            this.productList = productList;
            return this;
        }

        public CreateDishCommand build () {
            return new CreateDishCommand(this.name, this.quantity, this.productList);
        }
    }
}
