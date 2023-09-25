package com.ordering.platform.product.service.domain.entity;

import com.ordering.platform.domain.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.UUID;

public class Product extends BaseEntity {
    private final String name;
    private final ProductType productType;
    private final Integer quantity;

    public Product(UUID id, String name, ProductType productType, Integer quantity) {
        super.setId(id);
        this.name = name;
        this.productType = productType;
        this.quantity = quantity;
    }

    public Product(String name, ProductType productType, Integer quantity) {
        this.name = name;
        this.productType = productType;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public ProductType getProductType() {
        return productType;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
