DELIMITER $$

CREATE FUNCTION udf_count_flights_from_country(country VARCHAR(50)) 
RETURNS INT
DETERMINISTIC
BEGIN
	RETURN (SELECT COUNT(*) AS flights_count
	FROM flights f
	JOIN countries c
		ON f.departure_country = c.id
	WHERE c.name = country);
END $$

DELIMITER ;

SELECT udf_count_flights_from_country('Brazil') AS 'flights_count';