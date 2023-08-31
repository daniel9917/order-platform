package com.ordering.platform.order.service.domain.entity;

import com.ordering.platform.domain.entity.BaseEntity;

import java.util.List;
import java.util.UUID;

public class Dish extends BaseEntity {
    private final String name;
    private final int quantity;
    private final List<UUID> productList;

    public Dish(UUID id, String name, int quantity, List<UUID> productList) {
        this.setId(id);
        this.name = name;
        this.quantity = quantity;
        this.productList = productList;
    }

    public Dish(String name, int quantity, List<UUID> productList) {
        this.name = name;
        this.quantity = quantity;
        this.productList = productList;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public List<UUID> getProductList() {
        return productList;
    }
}
