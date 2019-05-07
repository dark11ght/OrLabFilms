CREATE TABLE users
(
    id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    login VARCHAR(50) NOT NULL,
    pass varchar(50) NOT NULL,
    role int DEFAULT 2 NOT NULL
);
CREATE UNIQUE INDEX users_login_uindex ON users (login);

INSERT INTO `favoritefilms`.`users` (`login`, `pass`, `role`)
VALUES ('admin', '1111', 1);

INSERT INTO `favoritefilms`.`users` (`login`, `pass`, `role`)
VALUES ('user1', '1111', DEFAULT);