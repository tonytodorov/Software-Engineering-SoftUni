DELIMITER $$

CREATE PROCEDURE usp_get_employees_by_salary_level(level_of_salary VARCHAR(10))
BEGIN
	DECLARE result VARCHAR(20);
	IF (level_of_salary = 'low') THEN	
		SELECT first_name, last_name
		FROM employees
		WHERE salary < 30000
        ORDER BY first_name DESC, last_name DESC;
	ELSEIF (level_of_salary = 'average') THEN	
		SELECT first_name, last_name
		FROM employees
		WHERE salary BETWEEN 30000 AND 50000
        ORDER BY first_name DESC, last_name DESC;
	ELSEIF (level_of_salary = 'high') THEN
    SELECT first_name, last_name
		FROM employees
		WHERE salary > 50000
        ORDER BY first_name DESC, last_name DESC;
    END IF;
END $$

DELIMITER ;

CALL usp_get_employees_by_salary_level('high');


