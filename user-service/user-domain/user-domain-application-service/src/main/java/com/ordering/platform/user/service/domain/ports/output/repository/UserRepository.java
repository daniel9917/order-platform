package com.ordering.platform.user.service.domain.ports.output.repository;

import com.ordering.platform.user.service.domain.entity.User;

public interface UserRepository {
    User createUser(User user);
}
