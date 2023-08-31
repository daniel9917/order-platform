package com.ordering.platform.dataaccess.repository;

import com.ordering.platform.dataaccess.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserJpaRepository extends CrudRepository<UserEntity, UUID> {
}
