package com.ordering.platform.dataaccess.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "orders")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    //fk userId
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    //fk restaurantId
    private RestaurantEntity restaurant;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "order")
    private List<DishEntity> dishList;

    public OrderEntity() {
    }

    public OrderEntity(UUID id, String status, UserEntity user, RestaurantEntity restaurant, List<DishEntity> dishList) {
        this.id = id;
        this.status = status;
        this.user = user;
        this.restaurant = restaurant;
        this.dishList = dishList;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public RestaurantEntity getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(RestaurantEntity restaurant) {
        this.restaurant = restaurant;
    }

    public List<DishEntity> getDishList() {
        return dishList;
    }

    public void setDishList(List<DishEntity> dishList) {
        this.dishList = dishList;
    }
}
