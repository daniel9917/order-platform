package com.ordering.platform.restaurant.service.dataaccess.repository;

import com.ordering.platform.restaurant.service.dataaccess.entity.RestaurantEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RestaurantJpaRepository extends CrudRepository<RestaurantEntity, UUID> {
}
