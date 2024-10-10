SET FOREIGN_KEY_CHECKS = 0;

CREATE TABLE teachers (
	teacher_id INT NOT NULL PRIMARY KEY,
    name VARCHAR(50),
    manager_id INT,
    
    CONSTRAINT sr_teacher_manager
    FOREIGN KEY (manager_id)
    REFERENCES teachers(teacher_id)
);

INSERT INTO teachers (teacher_id, name, manager_id) 
VALUES (101, 'John', NULL),
	   (102, 'Maya', 106),
       (103, 'Silvia', 106),
       (104, 'Ted', 105),
       (105, 'Mark', 101),
       (106, 'Greta', 101);