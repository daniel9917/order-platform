package com.ordering.platform.order.service.domain.entity;

import com.ordering.platform.domain.entity.BaseEntity;

import java.util.List;
import java.util.UUID;

public class Dish extends BaseEntity {
    private final String name;
    private final UUID restaurantId;
    private final int quantity;
    private final List<Product> productList;

    public Dish(String name, UUID restaurantId, int quantity, List<Product> productList) {
        this.name = name;
        this.restaurantId = restaurantId;
        this.quantity = quantity;
        this.productList = productList;
    }

    public String getName() {
        return name;
    }

    public UUID getRestaurantId() {
        return restaurantId;
    }

    public int getQuantity() {
        return quantity;
    }

    public List<Product> getProductList() {
        return productList;
    }
}
