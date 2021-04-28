CREATE TABLE products_tbl (
    product_id       bigserial PRIMARY KEY,
    title_fld        VARCHAR(255),
    price_fld        INT
    );
INSERT INTO products_tbl (title_fld, price_fld)
VALUES
('Re', 2900),
('StM', 3200),
('LaW1', 4500);

