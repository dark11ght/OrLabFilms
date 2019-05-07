CREATE TABLE public.users
(
    id serial NOT NULL,
    login VARCHAR(50) NOT NULL,
    pass VARCHAR(50) NOT NULL,
    role int DEFAULT 2 NOT NULL
);
CREATE UNIQUE INDEX favoritefilms_login_uindex ON public.favoritefilms (login);

INSERT INTO "public".users ("id", "login", "pass", "role") VALUES (DEFAULT, 'admin', '1111', 1);
INSERT INTO "public".users ("id", "login", "pass", "role") VALUES (DEFAULT, 'user1', '1111', 2);
INSERT INTO "public".users ("id", "login", "pass", "role") VALUES (DEFAULT, 'user2', '1111', 2);