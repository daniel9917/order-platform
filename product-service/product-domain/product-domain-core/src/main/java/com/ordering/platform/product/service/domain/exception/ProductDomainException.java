package com.ordering.platform.product.service.domain.exception;

import com.ordering.platform.domain.exception.DomainException;

public class ProductDomainException extends DomainException {
    public ProductDomainException(String message) {
        super(message);
    }
}
