create table products (
    id bigserial PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    price INT
);

create table students(
    id bigserial PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    age INT NOT NULL
);

insert into products (name, price)
VALUES
('Product1', 100),
('Product2', 200),
('Product3', 300);

insert into students (name, age)
VALUES
('Petrov Ivan', 20),
('Sidorov Petr', 19),
('Ivanov Viktor', 18);

