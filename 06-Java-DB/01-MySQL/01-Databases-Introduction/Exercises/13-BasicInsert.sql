CREATE DATABASE soft_uni;

CREATE TABLE towns
(
	id INT NOT NULL UNIQUE PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE addresses 
(
	id INT NOT NULL UNIQUE PRIMARY KEY AUTO_INCREMENT, 
    address_text VARCHAR(150),
    town_id INT,
    
    FOREIGN KEY(town_id) REFERENCES towns(id)
);

CREATE TABLE departments
(
	id INT NOT NULL UNIQUE PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE employees 
(
	id INT NOT NULL UNIQUE PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50) NOT NULL,
    middle_name VARCHAR(50), 
	last_name VARCHAR(50) NOT NULL,
    job_title VARCHAR(100),
    department_id INT,
    hire_date DATE,
    salary DECIMAL(10,2),
    address_id INT,
    
    FOREIGN KEY(department_id) REFERENCES departments(id),
    FOREIGN KEY(address_id) REFERENCES addresses(id)
); 

INSERT INTO towns (name)
VALUES ('Sofia'),
	   ('Plovdiv'),
       ('Varna'),
       ('Burgas');

INSERT INTO departments (name)
VALUES ('Engineering'),
	   ('Sales'),
       ('Marketing'),
       ('Software Development'),
       ('Quality Assurance');

INSERT INTO employees (first_name, middle_name, last_name, job_title, department_id, hire_date, salary)
VALUES ('Ivan', 'Ivanov', 'Ivanov', '.NET Developer', 4, '2013-02-01', 3500.00),
	   ('Petar', 'Petrov', 'Petrov', 'Senior Engineer', 1, '2004-03-02', 4000.00),
       ('Maria', 'Petrova', 'Ivanova', 'Intern', 5, '2016-08-28', 525.25),
       ('Georgi', 'Terziev', 'Ivanov', 'CEO', 2, '2007-12-09', 3000.00),
       ('Peter', 'Pan', 'Pan', 'Intern', 3, '2016-08-28', 599.88);
       