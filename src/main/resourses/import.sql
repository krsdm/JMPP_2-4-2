
/*   Initial data   */

INSERT INTO `usersdb`.`users` (`name`, `surname`, `password`, `age`, `email`) VALUES ('admin', '', '123', '26', 'admin@mail.com');
INSERT INTO `usersdb`.`users` (`name`, `surname`, `password`, `age`, `email`) VALUES ('user', '', '123', '19', 'user@mail.com');
INSERT INTO `usersdb`.`users` (`name`, `surname`, `password`, `age`, `email`) VALUES ('someone', '', '123', '33', 'someone@mail.com');

INSERT INTO `usersdb`.`users` (`name`, `surname`, `password`, `age`, `email`) VALUES ('Ivan', 'Ivanov', '147', '30', 'ivanivanov@mail.com');
INSERT INTO `usersdb`.`users` (`name`, `surname`, `password`, `age`, `email`) VALUES ('Dmitry', 'Sergeev', '258', '20', 'dmitrysergeev@mail.com');
INSERT INTO `usersdb`.`users` (`name`, `surname`, `password`, `age`, `email`) VALUES ('Anna', 'Smith', '369', '15', 'annasmith@mail.com');

INSERT INTO `usersdb`.`roles` (`name`) VALUES ('ROLE_ADMIN');
INSERT INTO `usersdb`.`roles` (`name`) VALUES ('ROLE_USER');
INSERT INTO `usersdb`.`roles` (`name`) VALUES ('ROLE_SOMEONE');

INSERT INTO `usersdb`.`user_roles` (`user_id`, `role_id`) VALUES ('1', '1');
INSERT INTO `usersdb`.`user_roles` (`user_id`, `role_id`) VALUES ('2', '2');
INSERT INTO `usersdb`.`user_roles` (`user_id`, `role_id`) VALUES ('3', '3');
INSERT INTO `usersdb`.`user_roles` (`user_id`, `role_id`) VALUES ('4', '3');
INSERT INTO `usersdb`.`user_roles` (`user_id`, `role_id`) VALUES ('5', '3');
INSERT INTO `usersdb`.`user_roles` (`user_id`, `role_id`) VALUES ('6', '3');