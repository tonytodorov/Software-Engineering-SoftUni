CREATE DATABASE movies;

CREATE TABLE directors(
	id INT NOT NULL UNIQUE PRIMARY KEY AUTO_INCREMENT,
    director_name VARCHAR(100) NOT NULL,
    notes TEXT
);

CREATE TABLE genres(
	id INT NOT NULL UNIQUE PRIMARY KEY AUTO_INCREMENT,
    genre_name VARCHAR(100) NOT NULL,
    notes TEXT
);

CREATE TABLE categories(
	id INT NOT NULL UNIQUE PRIMARY KEY AUTO_INCREMENT,
    category_name VARCHAR(100) NOT NULL,
    notes TEXT
);

CREATE TABLE movies(
	id INT NOT NULL UNIQUE PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(250) NOT NULL,
    director_id INT,
    copyright_year DATE,
    length DECIMAL(10, 2),
    genre_id INT,
    category_id INT,
    rating DECIMAL(5,2),
    notes TEXT
);

INSERT INTO directors(director_name, notes)
VALUES 
	('Pesho', 'Mladost'),
    ('Ivan', 'Mladost'),
    ('Gosho', 'Mladost'),
    ('Mimi', 'Mladost'),
    ('Eri', 'Mladost');
    
    
INSERT INTO genres(genre_name, notes)
VALUES 
	('Sci-Fi', 'Mladost'),
    ('Action', 'Mladost'),
    ('Drama', 'Mladost'),
    ('Trailer', 'Mladost'),
    ('Romantic', 'Mladost');
    

INSERT INTO categories(category_name, notes)
VALUES 
	('Above 18', 'Mladost'),
    ('Below 18', 'Mladost'),
    ('Gosho', 'Mladost'),
    ('Mimi', 'Mladost'),
    ('Eri', 'Mladost');
    
INSERT INTO movies
VALUES 
	(1, 'HP', 1, '2003-12-12', 2.30, 3, 2, 9.5, 'Potter'),
    (2, 'Castle', 1, '2003-12-12', 2.30, 3, 2, 9.5, 'Potter'),
    (3, 'Test', 1, '2003-12-12', 2.30, 3, 2, 9.5, 'Potter'),
    (4, 'In Time', 1, '2003-12-12', 2.30, 3, 2, 9.5, 'Potter'),
    (5, 'Nobody', 1, '2003-12-12', 2.30, 3, 2, 9.5, 'Potter');
    