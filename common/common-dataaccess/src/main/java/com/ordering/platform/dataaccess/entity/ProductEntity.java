package com.ordering.platform.dataaccess.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;
import java.util.UUID;

@Data
@Entity
@Builder
@Table(name = "products")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "quantity")
    private Integer quantity;

    @Transient
//    @Column(name = "type")
    private String type;

    @ManyToMany(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.REFRESH
            },
            fetch = FetchType.LAZY)
    @JoinTable(
            name = "dish_product",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "dish_id")
    )
    private List<DishEntity> dishList;

    public ProductEntity() {
    }

    public ProductEntity(UUID id, String name, Integer quantity, String type, List<DishEntity> dishList) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.dishList = dishList;
    }
}
