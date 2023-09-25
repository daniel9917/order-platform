package com.ordering.platform.dataaccess.repository;

import com.ordering.platform.dataaccess.entity.OrderEntity;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Repository
@AllArgsConstructor
public class OrderEntityManagerRepository {
    private EntityManager entityManager;

    @Transactional
    public OrderEntity save (OrderEntity orderEntity) {
        OrderEntity createdEntity = entityManager.merge(orderEntity);
        return createdEntity;
    }

    public Optional<OrderEntity> findById (UUID orderId) {
        return Optional.of(entityManager.find(OrderEntity.class, orderId));
    }

    @Transactional
    public OrderEntity update (OrderEntity orderEntity){
        return entityManager.merge(orderEntity);
    }
}
