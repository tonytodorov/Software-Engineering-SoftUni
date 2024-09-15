CREATE DATABASE car_rental;

CREATE TABLE categories 
(
	id INT NOT NULL UNIQUE PRIMARY KEY AUTO_INCREMENT,
	category VARCHAR(100) NOT NULL,
    daily_rate DECIMAL(10,2),
    weekly_rate DECIMAL(10,2),
    monthly_rate DECIMAL(10,2),
    weekend_rate DECIMAL(10,2)
);

CREATE TABLE cars 
(	
	id INT NOT NULL UNIQUE PRIMARY KEY AUTO_INCREMENT,
    plate_number INT NOT NULL,
    make VARCHAR(100),
    model VARCHAR(50),
    car_year DATE,
    category_id INT NOT NULL,
    doors INT,
    picture TEXT,
    car_condition TEXT,
    available BOOLEAN
);

CREATE TABLE employees
(
	id INT NOT NULL UNIQUE PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    title VARCHAR(100),
    notes TEXT
);

CREATE TABLE customers
(
	id INT NOT NULL UNIQUE PRIMARY KEY AUTO_INCREMENT,
    driver_licence_number VARCHAR(50) NOT NULL,
    full_name VARCHAR(100) NOT NULL,
    address VARCHAR(255),
    city VARCHAR(100), 
    zip_code INT,
    notes TEXT
);

CREATE TABLE rental_orders 
(
	id INT NOT NULL UNIQUE PRIMARY KEY AUTO_INCREMENT,
    employee_id INT NOT NULL,
    customer_id INT NOT NULL,
    car_id INT NOT NULL,
    car_condition VARCHAR(50),
    tank_level VARCHAR(50),
    kilometrage_start INT,
    kilometrage_end INT,
    total_kilometrage INT, 
    start_date DATETIME,
    end_date DATETIME,
    total_days INT,
    rate_applied DECIMAL(10,2), 
    tax_rate DECIMAL(10,2),
    order_status VARCHAR(50),
    notes TEXT
);

INSERT INTO categories (category, daily_rate, weekly_rate, monthly_rate, weekend_rate) 
VALUES 
('Economy', 30.00, 180.00, 700.00, 50.00),
('SUV', 50.00, 300.00, 1200.00, 80.00),
('Luxury', 100.00, 600.00, 2400.00, 150.00);

INSERT INTO cars (plate_number, make, model, car_year, category_id, doors, picture, car_condition, available) 
VALUES 
(123456, 'Toyota', 'Corolla', '2020-01-01', 1, 4, 'https://example.com/corolla.png', 'Excellent', TRUE),
(654321, 'Ford', 'Explorer', '2019-06-15', 2, 4, 'https://example.com/explorer.png', 'Good', TRUE),
(987654, 'BMW', '7 Series', '2021-05-30', 3, 4, 'https://example.com/7series.png', 'Excellent', FALSE);

INSERT INTO employees (first_name, last_name, title, notes) 
VALUES 
('John', 'Doe', 'Sales Manager', 'Over 10 years of experience'),
('Jane', 'Smith', 'Rental Agent', 'Specializes in customer service'),
('Mike', 'Brown', 'Mechanic', 'Responsible for vehicle maintenance');

INSERT INTO customers (driver_licence_number, full_name, address, city, zip_code, notes) 
VALUES 
('D12345678', 'Alice Johnson', '123 Main St', 'Springfield', 12345, 'Frequent renter'),
('D87654321', 'Bob Williams', '456 Oak St', 'Shelbyville', 67890, 'New customer'),
('D11223344', 'Charlie Adams', '789 Pine St', 'Capital City', 54321, 'Prefers luxury cars');

INSERT INTO rental_orders (employee_id, customer_id, car_id, car_condition, tank_level, kilometrage_start, kilometrage_end, total_kilometrage, start_date, end_date, total_days, rate_applied, tax_rate, order_status, notes) 
VALUES 
(1, 1, 1, 'Good', 'Full', 10000, 10500, 500, '2024-09-01 09:00:00', '2024-09-07 09:00:00', 6, 180.00, 10.00, 'Completed', 'No issues during rental'),
(2, 2, 2, 'Excellent', 'Half', 15000, 15500, 500, '2024-09-05 10:00:00', '2024-09-10 10:00:00', 5, 300.00, 12.00, 'Completed', 'Customer returned the car in good condition'),
(3, 3, 3, 'Excellent', 'Full', 20000, 20300, 300, '2024-09-02 08:00:00', '2024-09-06 08:00:00', 4, 400.00, 15.00, 'In Progress', 'Luxury car rental for VIP customer');
