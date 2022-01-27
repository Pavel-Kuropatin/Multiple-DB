CREATE TABLE IF NOT EXISTS users(
    id         bigserial primary key,
    birth_date varchar(255),
    name       varchar(255)
);

CREATE TABLE IF NOT EXISTS products(
    id    bigserial primary key,
    name  varchar(255),
    price integer
);

INSERT INTO users(birth_date, name) VALUES ('12.12.1989', 'Вася');
INSERT INTO users(birth_date, name) VALUES ('01.01.1990', 'Петя');
INSERT INTO users(birth_date, name) VALUES ('14.06.1996', 'Дима');

INSERT INTO products(name, price) VALUES ('Ручка',    100);
INSERT INTO products(name, price) VALUES ('Карандаш', 80);
INSERT INTO products(name, price) VALUES ('Тетрадь',  200);