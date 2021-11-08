CREATE SCHEMA IF NOT EXISTS `student`;

CREATE TABLE `student`.`student` (
                                     `id` INT NOT NULL AUTO_INCREMENT,
                                     `name` VARCHAR(45) NOT NULL,
                                     `age` INT NOT NULL,
                                     PRIMARY KEY (`id`));

INSERT INTO `student`.`student` (`name`, `age`) VALUES ('Макар', '18');
INSERT INTO `student`.`student` (`name`, `age`) VALUES ('Геннадий', '22');
INSERT INTO `student`.`student` (`name`, `age`) VALUES ('Светлана', '20');
INSERT INTO `student`.`student` (`name`, `age`) VALUES ('Александр', '21');
INSERT INTO `student`.`student` (`name`, `age`) VALUES ('Юлия', '19');