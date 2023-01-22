CREATE DATABASE IF NOT EXISTS Student; 

USE Student;

CREATE TABLE `Students` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`name` varchar(255),
	`group` INT,
	`applied` INT NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Grades` (
	`code` INT NOT NULL AUTO_INCREMENT,
	`class` INT,
	`sudent` INT,
	`grade` INT,
	PRIMARY KEY (`code`)
);

CREATE TABLE `Groups` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`name` varchar(255) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Classes` (
	`code` INT NOT NULL AUTO_INCREMENT,
	`name` varchar(255) NOT NULL,
	`menthor` INT NOT NULL,
	`term` INT NOT NULL,
	`year` INT NOT NULL,
	PRIMARY KEY (`code`)
);

CREATE TABLE `Menthors` (
	`code` INT NOT NULL AUTO_INCREMENT,
	`name` varchar(255) NOT NULL,
	`department` INT NOT NULL,
	PRIMARY KEY (`code`)
);

CREATE TABLE `Departments` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`name` varchar(255) NOT NULL,
	`head` varchar(255) NOT NULL,
	PRIMARY KEY (`id`)
);

ALTER TABLE `Students` ADD CONSTRAINT `Students_fk0` FOREIGN KEY (`group`) REFERENCES `Groups`(`id`);

ALTER TABLE `Grades` ADD CONSTRAINT `Grades_fk0` FOREIGN KEY (`class`) REFERENCES `Classes`(`code`);

ALTER TABLE `Grades` ADD CONSTRAINT `Grades_fk1` FOREIGN KEY (`sudent`) REFERENCES `Students`(`id`);

ALTER TABLE `Classes` ADD CONSTRAINT `Classes_fk0` FOREIGN KEY (`menthor`) REFERENCES `Menthors`(`code`);

ALTER TABLE `Menthors` ADD CONSTRAINT `Menthors_fk0` FOREIGN KEY (`department`) REFERENCES `Departments`(`id`);







