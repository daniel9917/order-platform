package com.ordering.platform.product.service.application.rest;

import com.ordering.platform.product.service.domain.command.CreateProductCommand;
import com.ordering.platform.product.service.domain.ports.input.service.ProductApplicationService;
import com.ordering.platform.product.service.domain.response.CreateProductResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductApplicationService productApplicationService;

    public ProductController(ProductApplicationService productApplicationService) {
        this.productApplicationService = productApplicationService;
    }

    @PostMapping("/create")
    public ResponseEntity<CreateProductResponse> createProductResponse (@RequestBody CreateProductCommand createProductCommand){
        return new ResponseEntity<>(productApplicationService.createProduct(createProductCommand), HttpStatus.CREATED);
    }


}
