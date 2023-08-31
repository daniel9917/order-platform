package com.ordering.platform.product.service.domain;

import com.ordering.platform.product.service.domain.entity.Product;
import com.ordering.platform.product.service.domain.exception.ProductDomainException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ProductDomainServiceImpl implements ProductDomainService{

    @Override
    public void validateProduct(Product product) throws ProductDomainException {
      // validate product
        log.info("Order with Id: {} has been initialized", product.getId());
    }
}
