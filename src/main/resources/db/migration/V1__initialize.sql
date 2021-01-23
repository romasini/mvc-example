create table products (
    id bigserial PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    price INT
);

insert into products (name, price)
VALUES
('Product1', 100),
('Product2', 200),
('Product3', 300);