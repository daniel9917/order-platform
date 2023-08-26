package com.ordering.platform.user.service.domain;

import com.ordering.platform.domain.exception.DomainException;
import com.ordering.platform.user.service.domain.entity.User;

public interface UserDomainService {
    void validateUser (User user) throws DomainException;
}
