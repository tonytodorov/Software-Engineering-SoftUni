INSERT INTO athletes(first_name, last_name, age, country_id)
SELECT 
	UPPER(first_name),
    CONCAT(last_name, ' comes from ', c.name),
    age + country_id,
    country_id
FROM athletes a
JOIN countries c
	ON c.id = a.country_id
WHERE c.name LIKE 'A%'