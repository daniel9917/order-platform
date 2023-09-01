package com.ordering.platform.product.service.domain.command;

public record CreateProductCommand (String name, String type) {

    public static final class Builder {

        private String name;
        private String type;

        public Builder name (String name) {
            this.name = name;
            return this;
        }

        public Builder type (String type) {
            this.type = type;
            return this;
        }

        public CreateProductCommand build () {
            return new CreateProductCommand(name, type);
        }
    }


}
