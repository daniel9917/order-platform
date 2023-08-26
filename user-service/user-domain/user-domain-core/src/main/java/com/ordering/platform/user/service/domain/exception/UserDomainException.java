package com.ordering.platform.user.service.domain.exception;

import com.ordering.platform.domain.exception.DomainException;

public class UserDomainException extends DomainException {
    public UserDomainException(String message) {
        super(message);
    }
}
