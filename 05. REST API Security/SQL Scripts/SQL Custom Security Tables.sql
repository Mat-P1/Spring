CREATE DATABASE IF NOT EXISTS `employee_directory`;

USE `employee_directory`;

DROP TABLE IF EXISTS `employee`;
DROP TABLE IF EXISTS `roles`;
DROP TABLE IF EXISTS `members`;

CREATE TABLE `employee` (
  `id` INT NOT NULL AUTO_INCREMENT,
     `first_name` VARCHAR(45) DEFAULT NULL,
     `last_name` VARCHAR(45) DEFAULT NULL,
     `email` VARCHAR(45) DEFAULT NULL,
     PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
 
INSERT INTO `employee` VALUES
 (1, 'Leslie', 'Andrews', 'leslie@gmail.com'),
 (2, 'Emma', 'Baumgarten', 'emma@gmail.com'),
 (3, 'Avani', 'Gupta', 'avani@gmail.com'),
 (4, 'Yuri', 'Petrov', 'yuri@gmail.com'),
 (5, 'Juan', 'Vega', 'juan@gmail.com');
 
 CREATE TABLE `members` (
	`user_id` VARCHAR(50) NOT NULL,
    `pw` CHAR(68) NOT NULL,
    `active` TINYINT NOT NULL,
    PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `members`
VALUES
('john', '{bcrypt}$2a$10$pR1ReiD8/aw3pSNLhxUyvOwtiYdMZpBsZoe4kyL35qY.qyLRp6dW6', 1),
('mary', '{bcrypt}$2a$10$pR1ReiD8/aw3pSNLhxUyvOwtiYdMZpBsZoe4kyL35qY.qyLRp6dW6', 1),
('susan', '{bcrypt}$2a$10$pR1ReiD8/aw3pSNLhxUyvOwtiYdMZpBsZoe4kyL35qY.qyLRp6dW6', 1);

CREATE TABLE `roles` (
	`user_id` VARCHAR(50) NOT NULL,
    `role` VARCHAR(50) NOT NULL,
    UNIQUE KEY `authorities_idx_1` (`user_id`, `role`),
    CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `members` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `roles`
VALUES
('john', 'ROLE_EMPLOYEE'),
('mary', 'ROLE_EMPLOYEE'),
('mary', 'ROLE_MANAGER'),
('susan', 'ROLE_EMPLOYEE'),
('susan', 'ROLE_MANAGER'),
('susan', 'ROLE_ADMIN');