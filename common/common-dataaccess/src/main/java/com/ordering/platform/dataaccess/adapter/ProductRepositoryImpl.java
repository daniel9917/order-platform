package com.ordering.platform.dataaccess.adapter;

import com.ordering.platform.dataaccess.mapper.ProductDataAccessMapper;
import com.ordering.platform.dataaccess.repository.ProductJpaRepository;
import com.ordering.platform.product.service.domain.entity.Product;
import com.ordering.platform.product.service.domain.ports.output.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductRepositoryImpl implements ProductRepository {

    private final ProductJpaRepository productJpaRepository;

    private final ProductDataAccessMapper productDataAccessMapper;

    @Autowired
    public ProductRepositoryImpl(ProductJpaRepository productJpaRepository, ProductDataAccessMapper productDataAccessMapper) {
        this.productJpaRepository = productJpaRepository;
        this.productDataAccessMapper = productDataAccessMapper;
    }

    @Override
    public Product createProduct(Product product) {
        return productDataAccessMapper.productEntityToProduct(
                productJpaRepository.save(
                        productDataAccessMapper.productToProductEntity(product)
                )
        );
    }
}
