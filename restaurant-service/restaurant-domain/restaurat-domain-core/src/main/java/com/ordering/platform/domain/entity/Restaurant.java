package com.ordering.platform.domain.entity;


import java.util.List;
import java.util.UUID;

public class Restaurant extends BaseEntity {

    private final String name;

    private final String address;

//    private final RestaurantDetail restaurantDetail;

    public Restaurant(
            UUID id,
            String name,
            String address
//            RestaurantDetail restaurantDetail
    ) {
        super.setId(id);
        this.name = name;
        this.address = address;
//        this.restaurantDetail = restaurantDetail;
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
