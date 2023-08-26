DROP SCHEMA IF EXISTS `order-platform`;

CREATE SCHEMA `order-platform`;

use `order-platform`;

SET FOREIGN_KEY_CHECKS = 0;

CREATE TABLE `user` (
    `id` VARCHAR(36) NOT NULL,
    `first_name` VARCHAR(20) NOT NULL,
    `last_name` VARCHAR(20) NOT NULL,
    `email` VARCHAR(25) NOT NULL,
    `address` VARCHAR(25) NOT NULL,
    
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `restaurant` (
    `id` VARCHAR(36) NOT NULL,
    `name` VARCHAR(20) NOT NULL,
    `address` VARCHAR(20) NOT NULL,

    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `order` (
    `id` VARCHAR(36) NOT NULL,
    `status` VARCHAR(10) NOT NULL,
    `user_id` VARCHAR(36) NOT NULL,
    `restaurant_id` VARCHAR(36) NOT NULL,

    PRIMARY KEY (`id`),

    KEY `FK_RESTAURANT_idx` (`restaurant_id`),
    CONSTRAINT `FK_RESTAURANT`
    FOREIGN KEY (`restaurant_id`)
    REFERENCES `restaurant` (`id`),

    KEY `FK_USER_idx` (`user_id`),
    CONSTRAINT `FK_USER`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)

    ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `dish` (
    `id` VARCHAR(36) NOT NULL,
    `quantity` INT NOT NULL,
    `name` VARCHAR(20) NOT NULL,
    `order_id` VARCHAR(36) NOT NULL,

    PRIMARY KEY (`id`),

    KEY `FK_ORDER_idx` (`order_id`),
    CONSTRAINT `FK_ORDER`
    FOREIGN KEY (`order_id`)
    REFERENCES `order` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `product` (
    `id` VARCHAR(36) NOT NULL,
    `name` VARCHAR(20) NOT NULL,

    PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `dish_product` (
    `product_id` VARCHAR(36) NOT NULL,
    `dish_id` VARCHAR(36) NOT NULL,

    PRIMARY KEY (`product_id`, `dish_id`),

    KEY `FK_DISH_idx` (`dish_id`),
    KEY `FK_PRODUCT_idx` (`product_id`),


    CONSTRAINT `FK_PRODUCT` FOREIGN KEY (`product_id`)
    REFERENCES `product` (`id`)
    ON DELETE NO ACTION ON UPDATE NO ACTION,

    CONSTRAINT `FK_DISH` FOREIGN KEY (`dish_id`)
    REFERENCES `dish` (`id`)
    ON DELETE NO ACTION ON UPDATE NO ACTION
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

SET FOREIGN_KEY_CHECKS = 1;