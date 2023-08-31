package com.ordering.platform.dataaccess.repository;

import com.ordering.platform.dataaccess.entity.OrderEntity;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@AllArgsConstructor
public class OrderEntityManagerRepository {
    private EntityManager entityManager;

    @Transactional
    public OrderEntity save (OrderEntity orderEntity) {
        OrderEntity createdEntity = entityManager.merge(orderEntity);
        return createdEntity;
    }
}
