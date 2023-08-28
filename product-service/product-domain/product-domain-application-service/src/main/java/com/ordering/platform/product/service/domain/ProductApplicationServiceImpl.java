package com.ordering.platform.product.service.domain;

import com.ordering.platform.product.service.domain.command.CreateProductCommand;
import com.ordering.platform.product.service.domain.entity.Product;
import com.ordering.platform.product.service.domain.exception.ProductDomainException;
import com.ordering.platform.product.service.domain.mapper.ProductDataMapper;
import com.ordering.platform.product.service.domain.ports.input.service.ProductApplicationService;
import com.ordering.platform.product.service.domain.ports.output.repository.ProductRepository;
import com.ordering.platform.product.service.domain.response.CreateProductResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.UUID;

@Slf4j
@Service
@Validated
public class ProductApplicationServiceImpl implements ProductApplicationService {

    private final ProductRepository productRepository;

    private final ProductDomainService productDomainService;

    private final ProductDataMapper productDataMapper;

    @Autowired
    public ProductApplicationServiceImpl(ProductRepository productRepository,
                                         ProductDomainService productDomainService,
                                         ProductDataMapper productDataMapper) {
        this.productRepository = productRepository;
        this.productDomainService = productDomainService;
        this.productDataMapper = productDataMapper;
    }

    @Override
    @Transactional
    public CreateProductResponse createProduct(CreateProductCommand createProductCommand) {
        Product product = productDataMapper.createProductCommandToProduct(createProductCommand);
        product.setId(UUID.randomUUID());
        productDomainService.validateProduct(product);
        Product persistedProduct = productRepository.createProduct(product);
        if (persistedProduct == null) {
            log.error("Could not create order with id: {}", persistedProduct.getId());
            throw new ProductDomainException("Could not save order Command Product: " + createProductCommand.toString());
        }
        log.info("Successfully created order with Id: " + product.getId());
        return productDataMapper.productToCreateProductResponse(persistedProduct, "Successfully created Command Product: " + createProductCommand.toString());
    }
}
