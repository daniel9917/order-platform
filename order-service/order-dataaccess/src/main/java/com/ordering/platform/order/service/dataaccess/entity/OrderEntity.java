package com.ordering.platform.order.service.dataaccess.entity;

import com.ordering.platform.order.service.domain.entity.Dish;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class OrderEntity {

    @Id
    private UUID id;

    @Column(name = "status")
    private String status;

    @Transient
    private Dish dish;
}
