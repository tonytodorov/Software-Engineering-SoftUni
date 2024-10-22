SELECT 
	CONCAT(UPPER(SUBSTRING(p.last_name FROM 1 FOR 2)), country_id) AS flight_code,
	CONCAT(p.first_name, ' ', p.last_name) AS full_name,
    p.country_id
FROM passengers p
LEFT JOIN flights_passengers fp
	ON fp.passenger_id = p.id
LEFT JOIN flights f
	ON f.id = fp.flight_id
WHERE fp.flight_id IS NULL
ORDER BY p.country_id;