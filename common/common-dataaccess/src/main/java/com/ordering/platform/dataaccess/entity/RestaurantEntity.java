package com.ordering.platform.dataaccess.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Entity
@Builder
@Table(name = "restaurants")
public class RestaurantEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "restaurant")
//    @JoinColumn(name = "restaurant_id")
    private List<OrderEntity> orders;

    public RestaurantEntity() {
    }

    public RestaurantEntity(UUID id, String name, String address, List<OrderEntity> orders) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.orders = orders;
    }
}
