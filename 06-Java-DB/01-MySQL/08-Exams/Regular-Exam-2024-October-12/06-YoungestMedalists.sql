SELECT CONCAT_WS(' ', a.first_name, a.last_name) AS full_name, a.age
FROM athletes a
JOIN disciplines_athletes_medals dam
	ON a.id = dam.athlete_id
JOIN medals m
	ON dam.medal_id = m.id
WHERE a.age < 18
ORDER BY a.id;