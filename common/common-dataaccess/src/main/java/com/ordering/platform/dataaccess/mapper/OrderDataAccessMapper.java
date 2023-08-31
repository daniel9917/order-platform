package com.ordering.platform.dataaccess.mapper;

import com.ordering.platform.dataaccess.entity.*;
import com.ordering.platform.order.service.domain.entity.Dish;
import com.ordering.platform.order.service.domain.entity.Order;
import com.ordering.platform.order.service.domain.entity.OrderStatus;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderDataAccessMapper {

    public Order orderEntityToOrder (OrderEntity orderEntity) {
        return new Order(
                orderEntity.getId(),
                orderEntity.getDishList().stream()
                        .map(dishEntity ->
                            new Dish(
                                    dishEntity.getName(),
                                    dishEntity.getQuantity(),
                                    dishEntity.getProductList().stream().map(ProductEntity::getId).toList()))
                        .toList(),
                OrderStatus.valueOf(orderEntity.getStatus()),
                orderEntity.getRestaurant().getId(),
                orderEntity.getUser().getId());
    }

    public OrderEntity orderToOrderEntity (Order order) {
        OrderEntity mappedOrderEntity = new OrderEntity(
                order.getId(),
                OrderStatus.PROCESSING.toString(),
                UserEntity.builder().id(order.getUserId()).build(),
                RestaurantEntity.builder().id(order.getRestaurantId()).build(),
                List.of()
                );

        List<DishEntity> dishEntityList = order.getDish().stream()
                .map(dish ->
                        new DishEntity(
                                dish.getId(),
                                dish.getQuantity(),
                                dish.getName(),
                                mappedOrderEntity,
                                dish.getProductList().stream().map(p -> ProductEntity.builder().id(p).build()).toList()
                                )).toList();

        mappedOrderEntity.setDishList(dishEntityList);
        return mappedOrderEntity;
    }


}
