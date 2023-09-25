package com.ordering.platform.product.service.domain.ports.output.repository;

import com.ordering.platform.product.service.domain.entity.Product;

import java.util.List;
import java.util.UUID;

public interface ProductRepository {
    Product createProduct (Product product);

    Product findProductById (UUID uuid);

    List<Product> findProductsByIdList(List<UUID> uuidList);
}
