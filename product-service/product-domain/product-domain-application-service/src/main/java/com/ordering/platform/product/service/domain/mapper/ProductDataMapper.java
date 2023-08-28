package com.ordering.platform.product.service.domain.mapper;

import com.ordering.platform.product.service.domain.command.CreateProductCommand;
import com.ordering.platform.product.service.domain.entity.Product;
import com.ordering.platform.product.service.domain.entity.ProductType;
import com.ordering.platform.product.service.domain.response.CreateProductResponse;
import org.springframework.stereotype.Component;

@Component
public class ProductDataMapper {
    public Product createProductCommandToProduct (CreateProductCommand createProductCommand) {
        return
                new Product(
                        createProductCommand.getName(),
                        ProductType.valueOf(createProductCommand.getType()));
    }

    public CreateProductResponse productToCreateProductResponse (Product product, String message){
        return new CreateProductResponse(product.getId(), message);
    }
}
