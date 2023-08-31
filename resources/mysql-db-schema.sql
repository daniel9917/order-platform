DROP SCHEMA IF EXISTS order_platform CASCADE;

-- Create schema
CREATE SCHEMA order_platform;

-- Use schema
SET search_path TO order_platform;

-- Create user table
CREATE TABLE users (
    id UUID NOT NULL,
    first_name VARCHAR(20) NOT NULL,
    last_name VARCHAR(20) NOT NULL,
    email VARCHAR(25) NOT NULL,
    address VARCHAR(25) NOT NULL,
    PRIMARY KEY (id)
);

-- Create restaurant table
CREATE TABLE restaurants (
    id UUID NOT NULL,
    name VARCHAR(20) NOT NULL,
    address VARCHAR(20) NOT NULL,
    PRIMARY KEY (id)
);

-- Create order table
CREATE TABLE orders (
    id UUID NOT NULL,
    status VARCHAR(10) NOT NULL,
    user_id UUID NOT NULL,
    restaurant_id UUID NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (restaurant_id) REFERENCES restaurant (id),
    FOREIGN KEY (user_id) REFERENCES user (id) ON DELETE NO ACTION ON UPDATE NO ACTION
);

-- Create dish table
CREATE TABLE dishes (
    id UUID NOT NULL,
    quantity INT NOT NULL,
    name VARCHAR(20) NOT NULL,
    order_id UUID NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (order_id) REFERENCES order_table (id)
);

-- Create product table
CREATE TABLE products (
    id UUID NOT NULL,
    name VARCHAR(20) NOT NULL,
    PRIMARY KEY (id)
);

-- Create dish_product table
CREATE TABLE dish_product (
    product_id UUID NOT NULL,
    dish_id UUID NOT NULL,
    PRIMARY KEY (product_id, dish_id),
    FOREIGN KEY (product_id) REFERENCES product (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
    FOREIGN KEY (dish_id) REFERENCES dish (id) ON DELETE NO ACTION ON UPDATE NO ACTION
);

-- Reset search path
RESET search_path;