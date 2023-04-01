CREATE TABLE product(
    item_id NUMBER(20) NOT NULL,
    img VARCHAR(100) NOT NULL,
    product_name VARCHAR(100) NOT NULL,
    product_url VARCHAR(100) NOT NULL,
    brand VARCHAR(50) NOT NULL,
    brand_url VARCHAR(100) NOT NULL,
    category NUMBER(5) NOT NULL,
    rank NUMBER(5) NOT NULL,
    real_price NUMBER(10) NOT NULL,
    PRIMARY KEY(item_id)
);
