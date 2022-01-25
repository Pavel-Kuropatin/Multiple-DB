CREATE TABLE IF NOT EXISTS users(
    id         bigserial primary key,
    birth_date varchar(255),
    name       varchar(255)
);

CREATE TABLE IF NOT EXISTS greetings(
    id      bigserial primary key,
    message varchar(255)
);

INSERT INTO users(birth_date, name) VALUES ('12.12.1989', 'Вася');
INSERT INTO users(birth_date, name) VALUES ('01.01.1990', 'Петя');
INSERT INTO users(birth_date, name) VALUES ('14.06.1996', 'Дима');

INSERT INTO greetings(message) VALUES ('Hello world!');
INSERT INTO greetings(message) VALUES ('Hi there!');
INSERT INTO greetings(message) VALUES ('Welcome!');
INSERT INTO greetings(message) VALUES ('Nice to meet you!');
INSERT INTO greetings(message) VALUES ('Oh, hello!');

