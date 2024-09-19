SELECT name, 
CASE
	WHEN HOUR(start) < 12 THEN 'Morning'
    WHEN HOUR(start) < 18 THEN 'Afternoon'
    WHEN HOUR(start) < 24 THEN 'Evening'
END as `Part of the Day`,
CASE
	WHEN duration <= 3 THEN 'Extra Short'
	WHEN duration <= 6 THEN 'Short'
	WHEN duration <= 10 THEN 'Long'
    ELSE 'Extra Long'
END as `Duration`
FROM games;

