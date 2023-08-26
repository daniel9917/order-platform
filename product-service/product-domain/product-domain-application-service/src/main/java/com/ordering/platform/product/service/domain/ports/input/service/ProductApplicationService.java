package com.ordering.platform.product.service.domain.ports.input.service;

import com.ordering.platform.product.service.domain.command.CreateProductCommand;
import com.ordering.platform.product.service.domain.response.CreateProductResponse;
import jakarta.validation.Valid;

public interface ProductApplicationService {
    CreateProductResponse createProduct (@Valid CreateProductCommand createProductCommand);
}
