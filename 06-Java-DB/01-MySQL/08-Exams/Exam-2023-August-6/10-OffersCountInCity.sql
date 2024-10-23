DELIMITER $$

CREATE FUNCTION udf_offers_from_city_name (city_name VARCHAR(50)) 
RETURNS INT
DETERMINISTIC
BEGIN
	RETURN (SELECT COUNT(*) AS offers_count
	FROM cities c
	JOIN properties p
		ON p.city_id = c.id
	JOIN property_offers po
		ON p.id = po.property_id
	WHERE c.name = city_name);
END $$

DELIMITER ;

SELECT udf_offers_from_city_name('Vienna') AS offers_count;