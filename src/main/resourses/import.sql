
/*   Initianal data   */

INSERT INTO `usersdb`.`users` (`name`, `surname`, `password`, `age`, `email`) VALUES ('Dmitry', 'Krasilniov', '123', '40', 'dmitrykrasilnikov@mail.com');
INSERT INTO `usersdb`.`users` (`name`, `surname`, `password`, `age`, `email`) VALUES ('Ivan', 'Ivanov', '456', '30', 'ivanivanov@mail.com');
INSERT INTO `usersdb`.`users` (`name`, `surname`, `password`, `age`, `email`) VALUES ('Elena', 'Popova', '789', '20', 'elenapopova@mail.com');

INSERT INTO `usersdb`.`roles` (`name`) VALUES ('ROLE_USER');
INSERT INTO `usersdb`.`roles` (`name`) VALUES ('ROLE_USER');
INSERT INTO `usersdb`.`roles` (`name`) VALUES ('ROLE_ADMIN');

INSERT INTO `usersdb`.`users_roles` (`users_id`, `roles_id`) VALUES ('1', '3');
INSERT INTO `usersdb`.`users_roles` (`users_id`, `roles_id`) VALUES ('2', '2');
INSERT INTO `usersdb`.`users_roles` (`users_id`, `roles_id`) VALUES ('3', '1');