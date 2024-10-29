DELIMITER $$

CREATE FUNCTION udf_total_medals_count_by_country (country_name VARCHAR(40))
RETURNS INT
DETERMINISTIC
BEGIN
	RETURN (SELECT COUNT(*) AS count_of_medals
	FROM disciplines_athletes_medals dam
	JOIN athletes a
		ON a.id = dam.athlete_id
	JOIN countries c
		ON c.id = a.country_id
	WHERE c.name = country_name);
END $$

DELIMITER ;

SELECT c.name, udf_total_medals_count_by_country ('Bahamas') as count_of_medals
FROM countries c
WHERE c.name = 'Bahamas';