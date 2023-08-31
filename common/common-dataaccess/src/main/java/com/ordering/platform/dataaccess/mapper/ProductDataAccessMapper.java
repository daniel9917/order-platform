package com.ordering.platform.dataaccess.mapper;

import com.ordering.platform.dataaccess.entity.ProductEntity;
import com.ordering.platform.product.service.domain.entity.Product;
import com.ordering.platform.product.service.domain.entity.ProductType;
import org.springframework.stereotype.Component;

@Component
public class ProductDataAccessMapper {
    public Product productEntityToProduct (ProductEntity productEntity) {
        return new Product(
                productEntity.getId(),
                productEntity.getName(),
                ProductType.valueOf(productEntity.getType())
        );
    }

    public ProductEntity productToProductEntity (Product product) {
        return ProductEntity.builder()
                .id(product.getId())
                .type(product.getProductType().toString())
                .name(product.getName())
                .build();
    }
}
