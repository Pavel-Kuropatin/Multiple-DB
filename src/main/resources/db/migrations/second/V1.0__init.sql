CREATE TABLE IF NOT EXISTS greetings(
    id      bigserial primary key,
    message varchar(255)
);

INSERT INTO greetings(message) VALUES ('Hello world!');
INSERT INTO greetings(message) VALUES ('Hi there!');
INSERT INTO greetings(message) VALUES ('Welcome!');
INSERT INTO greetings(message) VALUES ('Nice to meet you!');
INSERT INTO greetings(message) VALUES ('Oh, hello!');