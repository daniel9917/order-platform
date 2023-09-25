package com.ordering.platform.dataaccess.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "dishes")
public class DishEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "name")
    private String name;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private OrderEntity order;

    @ManyToMany(
            cascade = {
//                    CascadeType.PERSIST,
//                    CascadeType.DETACH,
//                    CascadeType.MERGE,
//                    CascadeType.REFRESH
            },
            fetch = FetchType.EAGER)
    @JoinTable(
            name = "dish_product",
            joinColumns = @JoinColumn(name = "dish_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<ProductEntity> productList;

    public DishEntity() {
    }

    public DishEntity(UUID id, int quantity, String name, OrderEntity order, List<ProductEntity> productList) {
        this.id = id;
        this.quantity = quantity;
        this.name = name;
        this.order = order;
        this.productList = productList;
    }
}
