INSERT INTO users(id, archive, email, name, password, role)
VALUES (1, false, 'mail@mail.ru', 'admin', '$2a$10$uBLZsxmGVl9DRJXL7ciLfOJuB4wemHveD9u/VUCly5TyYafpfZuba', 'ADMIN');

ALTER SEQUENCE user_seq RESTART with 2;