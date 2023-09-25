package com.ordering.platform.product.service.domain;

import com.ordering.platform.product.service.domain.entity.Product;
import com.ordering.platform.product.service.domain.exception.ProductDomainException;
import com.ordering.platform.product.service.domain.ports.output.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ProductValidator {

    private final ProductRepository productRepository;

    public void validateProductAmount(UUID productId, int quantity) throws ProductDomainException {
        Product p = productRepository.findProductById(productId);
        if (p.getQuantity() < quantity){
            throw new ProductDomainException("Product amount is lower than requested.");
        }
    }

    public void validateProducts (Map<UUID, Integer> productAmounts) throws ProductDomainException {
        List<Product> products = productRepository.findProductsByIdList(productAmounts.keySet().stream().toList());
        for (Product p : products) {
            if (productAmounts.get(p.getId()) > p.getQuantity()){
                throw new ProductDomainException("Insufficient products to fulfill order");
            }
        }
    }
}
