# Create tables
CREATE TABLE `minions` (
	`id` INT NOT NULL UNIQUE PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(255),
    `age` INT
);

CREATE TABLE `towns` (
	`town_id` INT NOT NULL UNIQUE PRIMARY KEY AUTO_INCREMENT ,
    `name` VARCHAR(255)
);
