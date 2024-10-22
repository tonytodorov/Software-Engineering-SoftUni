SELECT 
	flight_code,
	departure,
    CASE
		WHEN HOUR(departure) BETWEEN 5 AND 11 THEN 'Morning'
		WHEN HOUR(departure) BETWEEN 12 AND 16 THEN 'Afternoon'
		WHEN HOUR(departure) BETWEEN 17 AND 20 THEN 'Evening'
		ELSE 'Night'
	END AS day_part
FROM flights
ORDER BY flight_code DESC;