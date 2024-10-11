CREATE TABLE clients (
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    client_name VARCHAR(100)
);

CREATE TABLE employees (
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	first_name VARCHAR(30) NOT NULL,
    last_name VARCHAR(30) NOT NULL,
	project_id INT NOT NULL
);

CREATE TABLE projects (
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    client_id INT NOT NULL,
    project_lead_id INT NOT NULL
);

ALTER TABLE projects
ADD CONSTRAINT fk_projects_clients
FOREIGN KEY (project_lead_id)
REFERENCES clients(id);

ALTER TABLE projects
ADD CONSTRAINT fk_projects_employees
FOREIGN KEY (client_id)
REFERENCES employees(id);

ALTER TABLE employees
ADD CONSTRAINT fk_employees_projects
FOREIGN KEY (project_id)
REFERENCES projects(id);