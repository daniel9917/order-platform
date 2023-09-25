package com.ordering.platform.product.service.domain.command;

public record CreateProductCommand (String name, String type, Integer quantity) {

    public static final class Builder {

        private String name;
        private String type;
        private Integer quantity;

        public Builder name (String name) {
            this.name = name;
            return this;
        }

        public Builder type (String type) {
            this.type = type;
            return this;
        }

        public Builder quantity (Integer quantity){
            this.quantity = quantity;
            return this;
        }

        public CreateProductCommand build () {
            return new CreateProductCommand(name, type, quantity);
        }
    }


}
