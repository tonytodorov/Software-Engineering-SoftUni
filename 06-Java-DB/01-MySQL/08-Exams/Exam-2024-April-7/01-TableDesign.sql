CREATE DATABASE go_roadie;
USE go_roadie;

CREATE TABLE students (
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(40) NOT NULL,
    last_name VARCHAR(40) NOT NULL UNIQUE,
    age INT,
    phone_number VARCHAR(20) UNIQUE
);

CREATE TABLE cities (
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(40) NOT NULL UNIQUE
);

CREATE TABLE cars (
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	brand VARCHAR(20) NOT NULL,
    model VARCHAR(20) NOT NULL UNIQUE
);

CREATE TABLE driving_schools (
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(40) NOT NULL UNIQUE,
    night_time_driving TINYINT(1),
    average_lesson_price DECIMAL(10, 2),
    car_id INT NOT NULL,
    city_id INT NOT NULL,
    
    CONSTRAINT fk_driving_schools_cars
    FOREIGN KEY (car_id)
    REFERENCES cars(id),
    
    CONSTRAINT fk_driving_schools_cities
    FOREIGN KEY (city_id)
    REFERENCES cities(id)
);

CREATE TABLE instructors (
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	first_name VARCHAR(40) NOT NULL,
	last_name VARCHAR(40) NOT NULL UNIQUE,
	has_a_license_from DATE NOT NULL
);

CREATE TABLE instructors_driving_schools (
	instructor_id INT,
    driving_school_id INT NOT NULL,
    
    CONSTRAINT instructors_driving_schools_instructors
    FOREIGN KEY (instructor_id)
    REFERENCES instructors(id),
    
    CONSTRAINT instructors_driving_schools_driving_schools
    FOREIGN KEY (driving_school_id)
    REFERENCES driving_schools(id)
);

CREATE TABLE instructors_students (
	instructor_id INT NOT NULL,
    student_id INT NOT NULL,
    
    CONSTRAINT instructors_students_instructors
    FOREIGN KEY (instructor_id)
    REFERENCES instructors(id),
    
	CONSTRAINT instructors_students_students
    FOREIGN KEY (student_id)
    REFERENCES students(id)
);