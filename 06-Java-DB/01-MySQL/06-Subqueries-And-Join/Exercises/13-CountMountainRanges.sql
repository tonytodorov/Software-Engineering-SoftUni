SELECT mc.country_code, COUNT(*) AS mountain_range
FROM mountains_countries mc
JOIN mountains m
	ON mc.mountain_id = m.id
WHERE mc.country_code IN ('BG', 'RU', 'US')
GROUP BY mc.country_code
ORDER BY mountain_range DESC;