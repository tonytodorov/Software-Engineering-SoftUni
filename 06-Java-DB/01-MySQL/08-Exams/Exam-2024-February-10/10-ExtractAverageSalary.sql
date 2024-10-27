DELIMITER $$

CREATE FUNCTION udf_average_salary_by_position_name (position_name VARCHAR(40))
RETURNS DECIMAL(19, 2)
DETERMINISTIC
BEGIN
	RETURN (SELECT ROUND(AVG(w.salary), 2) AS position_average_salary 
	FROM positions p
	JOIN workers w
		ON w.position_id = p.id
	WHERE p.name = position_name
	GROUP BY p.name);
END $$

DELIMITER ;

SELECT p.name, udf_average_salary_by_position_name('Forester') 
AS position_average_salary 
FROM positions p  
WHERE p.name = 'Forester';
