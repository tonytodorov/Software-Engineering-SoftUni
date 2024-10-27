DELIMITER $$

CREATE PROCEDURE udp_find_school_by_car(brand_name VARCHAR(20))
BEGIN
	SELECT name, average_lesson_price
	FROM driving_schools dc
	JOIN cars c
		ON c.id = dc.car_id
	WHERE c.brand = brand_name
	ORDER BY average_lesson_price DESC;
END $$

DELIMITER ;