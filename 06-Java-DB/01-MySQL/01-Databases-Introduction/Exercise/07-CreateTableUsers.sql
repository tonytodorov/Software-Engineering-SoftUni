CREATE TABLE `users` (
	`id` INT NOT NULL UNIQUE PRIMARY KEY AUTO_INCREMENT,
    `username` VARCHAR(30) NOT NULL,
    `password` VARCHAR(26) NOT NULL,
	`profile_picture` TEXT,
	`last_login_time` DATETIME,
	`is_deleted` BOOLEAN
);

INSERT INTO users (username, password, profile_picture, last_login_time, is_deleted) 
VALUES
	('john_doe', 'test', 'test', '2024-09-10 14:35:00', true),
	('jane_smith', 'pass', 'test', '2024-09-09 08:20:45', false),
	('robert_brown', '1234', 'test', NULL, false),
	('emily_davis', 'gaf', 'test', '2024-09-08 18:50:30', false),
	('michael_wilson', 'hop', 'test', NULL, true);
