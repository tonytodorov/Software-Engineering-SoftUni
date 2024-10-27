DELIMITER $$

CREATE FUNCTION udf_average_lesson_price_by_city (city_name VARCHAR(40)) 
RETURNS DECIMAL(19, 2)
DETERMINISTIC
BEGIN
	RETURN (SELECT AVG(average_lesson_price) AS average_lesson_price
	FROM cities c
	JOIN driving_schools dc
		ON dc.city_id = c.id 
	WHERE c.name = city_name
	GROUP BY c.name);
END $$

DELIMITER ;

SELECT udf_average_lesson_price_by_city ('London');