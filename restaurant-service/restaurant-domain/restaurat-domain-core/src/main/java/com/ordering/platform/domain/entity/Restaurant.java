package com.ordering.platform.domain.entity;


import java.util.List;
import java.util.UUID;

public class Restaurant extends BaseEntity {

    private final String name;

    private final String address;

    public Restaurant(UUID id, String name, String address) {
        super.setId(id);
        this.name = name;
        this.address = address;
    }

    public Restaurant(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

//    public List<? extends BaseEntity> getAssociatedEntity (String entityType) {
//        return restaurantDetail.getAssociatedEntities(entityType);
//    }
}
