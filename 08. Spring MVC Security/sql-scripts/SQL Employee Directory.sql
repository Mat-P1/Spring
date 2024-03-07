CREATE DATABASE IF NOT EXISTS `employee_directory`;

USE `employee_directory`;

DROP TABLE IF EXISTS `employee`;
DROP TABLE IF EXISTS `authorities`;
DROP TABLE IF EXISTS `users`;

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
 
 CREATE TABLE `users` (
	`username` VARCHAR(50) NOT NULL,
    `password` CHAR(68) NOT NULL,
    `enabled` TINYINT NOT NULL,
    PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `users`
VALUES
('john', '{bcrypt}$2a$10$/pLkVYobPYmWxhuit4qt3u1FSXdSUrM/2S3Uipb9Uf4cSnmFEfaLi', 1),
('mary', '{bcrypt}$2a$10$/pLkVYobPYmWxhuit4qt3u1FSXdSUrM/2S3Uipb9Uf4cSnmFEfaLi', 1),
('susan', '{bcrypt}$2a$10$/pLkVYobPYmWxhuit4qt3u1FSXdSUrM/2S3Uipb9Uf4cSnmFEfaLi', 1);

CREATE TABLE `authorities` (
	`username` VARCHAR(50) NOT NULL,
    `authority` VARCHAR(50) NOT NULL,
    UNIQUE KEY `authorities_idx_1` (`username`, `authority`),
    CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `authorities`
VALUES
('john', 'ROLE_EMPLOYEE'),
('mary', 'ROLE_EMPLOYEE'),
('mary', 'ROLE_MANAGER'),
('susan', 'ROLE_EMPLOYEE'),
('susan', 'ROLE_MANAGER'),
('susan', 'ROLE_ADMIN');