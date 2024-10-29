SELECT a.id, a.first_name, a.last_name
FROM athletes a
LEFT JOIN disciplines_athletes_medals dam
	ON a.id = dam.athlete_id
LEFT JOIN medals m
	ON dam.medal_id = m.id
WHERE m.id IS NULL
ORDER BY a.id;