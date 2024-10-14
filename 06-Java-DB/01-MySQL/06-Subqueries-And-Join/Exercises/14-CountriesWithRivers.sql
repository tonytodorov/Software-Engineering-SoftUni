SELECT cts.country_name, r.river_name
FROM countries cts
LEFT JOIN countries_rivers cr
	ON cts.country_code = cr.country_code
LEFT JOIN rivers r
	ON r.id = cr.river_id 
WHERE cts.continent_code IN ('AF')
ORDER BY cts.country_name
LIMIT 5;
