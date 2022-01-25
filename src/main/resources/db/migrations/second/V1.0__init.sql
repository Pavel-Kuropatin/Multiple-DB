CREATE TABLE IF NOT EXISTS products(
    id    bigserial primary key,
    name  varchar(255),
    price integer
);

INSERT INTO products(name, price) VALUES ('Ручка',    100);
INSERT INTO products(name, price) VALUES ('Карандаш', 80);
INSERT INTO products(name, price) VALUES ('Тетрадь',  200);