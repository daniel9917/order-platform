package com.ordering.platform.product.service.domain.entity;

import com.ordering.platform.domain.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.UUID;

public class Product extends BaseEntity {
    private final String name;
    private final ProductType productType;

    public Product(UUID id, String name, ProductType productType) {
        super.setId(id);
        this.name = name;
        this.productType = productType;
    }

    public String getName() {
        return name;
    }

    public ProductType getProductType() {
        return productType;
    }
}
