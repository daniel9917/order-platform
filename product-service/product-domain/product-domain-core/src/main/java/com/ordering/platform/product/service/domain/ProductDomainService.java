package com.ordering.platform.product.service.domain;

import com.ordering.platform.product.service.domain.entity.Product;
import com.ordering.platform.product.service.domain.exception.ProductDomainException;

public interface ProductDomainService {
    void validateProduct(Product product) throws ProductDomainException;
}
