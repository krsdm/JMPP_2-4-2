
/*   Initial data   */

INSERT INTO `usersdb`.`users` (`name`, `surname`, `password`, `age`, `email`) VALUES ('Ivan', 'Ivanov', '456', '30', 'ivanivanov@mail.com');
INSERT INTO `usersdb`.`users` (`name`, `surname`, `password`, `age`, `email`) VALUES ('Elena', 'Popova', '789', '20', 'elenapopova@mail.com');
INSERT INTO `usersdb`.`users` (`name`, `surname`, `password`, `age`, `email`) VALUES ('Anna', 'Snith', '963', '99', 'annasmith@mail.com');

INSERT INTO `usersdb`.`roles` (`name`) VALUES ('ROLE_USER');
INSERT INTO `usersdb`.`roles` (`name`) VALUES ('ROLE_ADMIN');
INSERT INTO `usersdb`.`roles` (`name`) VALUES ('ROLE_HR');

INSERT INTO `usersdb`.`user_roles` (`user_id`, `role_id`) VALUES ('1', '1');
INSERT INTO `usersdb`.`user_roles` (`user_id`, `role_id`) VALUES ('2', '2');
INSERT INTO `usersdb`.`user_roles` (`user_id`, `role_id`) VALUES ('3', '3');