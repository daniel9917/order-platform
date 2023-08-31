package com.ordering.platform.dataaccess;

import com.ordering.platform.dataaccess.entity.OrderEntity;
import com.ordering.platform.dataaccess.repository.OrderEntityManagerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping(value = "/tests")
public class TestController {

    private final OrderEntityManagerRepository orderEntityManagerRepository;

    // Test endpoint to check order creation, JPA mappings and associations
    @PostMapping("/create")
    public ResponseEntity<OrderEntity> createOrder(@RequestBody OrderEntity orderEntity) {
        return new ResponseEntity<>(orderEntityManagerRepository.save(orderEntity), HttpStatus.CREATED);
    }
}

