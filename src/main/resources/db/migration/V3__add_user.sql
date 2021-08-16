INSERT INTO users(id, archive, email, name, password, role, bucket_id)
VALUES (2, false, 'user@mail.ru', 'user', 'pass', 'CLIENT', null);

ALTER SEQUENCE user_seq RESTART with 2;