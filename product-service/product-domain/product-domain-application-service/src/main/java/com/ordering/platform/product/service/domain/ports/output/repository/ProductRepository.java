package com.ordering.platform.product.service.domain.ports.output.repository;

import com.ordering.platform.product.service.domain.entity.Product;

public interface ProductRepository {
    Product createProduct (Product product);
}
