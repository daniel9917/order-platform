package com.ordering.platform.order.service.domain.exception;

import com.ordering.platform.domain.exception.DomainException;

public class OrderDomainException extends DomainException {

    public OrderDomainException(String message) {
        super(message);
    }
}
