package com.ordering.platform.product.service.domain;

import com.ordering.platform.product.service.domain.entity.Product;
import com.ordering.platform.product.service.domain.exception.ProductDomainException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProductDomainServiceImpl implements ProductDomainService{

    @Override
    public void validateProduct(Product product) throws ProductDomainException {
      // validate product
        log.info("Order with Id: {} has been initialized", product.getId());
    }
}
