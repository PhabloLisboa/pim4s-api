INSERT INTO `role` (`description`) VALUES ('Admin');
INSERT INTO `role` (`description`) VALUES ('Funcionario');
INSERT INTO `role` (`description`) VALUES ('Cliente');

INSERT INTO `pim`.`user` (`email`, `password`, `phone`, `role_id`) VALUES ('Admin@email', '$2a$10$ICpYSWscq8DUbL7oB1jh3.kAC1Wui31VpzlqIT.EQTO1alp9geQg6', '00000', '1');
INSERT INTO `pim`.`funcionario` (`matricula`, `name`, `user_id`) VALUES ('0000000', 'Admin', '1');
