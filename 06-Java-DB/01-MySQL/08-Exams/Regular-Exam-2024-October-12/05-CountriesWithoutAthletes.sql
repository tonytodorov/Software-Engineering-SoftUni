SELECT c.id, c.name 
FROM countries c
LEFT JOIN athletes a
	ON a.country_id = c.id
WHERE a.country_id IS NULL
ORDER BY c.name DESC
LIMIT 15;