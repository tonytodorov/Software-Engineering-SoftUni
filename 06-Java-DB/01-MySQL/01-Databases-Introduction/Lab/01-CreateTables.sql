# If not use software and want to select current database
USE gamebar;

# Create database
CREATE DATABASE gamebar;

# Create tables
CREATE TABLE `employees` 
(
	`id` INT AUTO_INCREMENT PRIMARY KEY,
    `first_name` VARCHAR(50) NOT NULL,
	`last_name` VARCHAR(50) NOT NULL
);

CREATE TABLE `categories` 
(
	`id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(50) NOT NULL
);

CREATE TABLE `products` 
(
	`id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(50) NOT NULL,
    `category_id` INT NOT NULL
);