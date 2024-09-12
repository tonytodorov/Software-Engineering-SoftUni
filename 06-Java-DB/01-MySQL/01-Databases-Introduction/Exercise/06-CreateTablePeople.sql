CREATE TABLE `people` (
	`id` INT NOT NULL UNIQUE PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(200) NOT NULL,
    `picture` TEXT,
    `height` DECIMAL(10, 2),
    `weight` DECIMAL(10, 2),
    `gender` CHAR(1) NOT NULL,
    `birthdate` DATE NOT NULL,
    `biography` TEXT
);

INSERT INTO people (name, picture, height, weight, gender, birthdate, biography) 
VALUES ('John Doe', 'TEST', 1.90, 75.00, 'm', '1990-05-15', 'John Doe is a software developer with over 10 years of experience in web development.'),
	   ('Jane Smith', 'TEST', 1.65, 60.50, 'f', '1985-08-20', 'Jane Smith is a graphic designer who specializes in creating logos and branding materials for startups.'),
	   ('Robert Brown', 'TEST', 1.86, 82.10, 'm', '1992-11-02', 'Robert Brown is a professional photographer with a passion for capturing landscapes.'),
	   ('Emily Davis', 'TEST', 1.60, 55.00, 'f', '1998-02-10', 'Emily Davis is a recent graduate from art school, focusing on digital illustration.'),
       ('Michael Wilson', 'TEST', 1.94, 90.25, 'm', '1988-07-07', 'Michael Wilson is a fitness trainer who works with athletes and professionals to optimize their performance.');
