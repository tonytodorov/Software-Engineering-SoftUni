SELECT a.id, a.first_name, a.last_name, COUNT(*) AS medals_count, s.name
FROM athletes a
JOIN disciplines_athletes_medals dam
	ON a.id = dam.athlete_id
JOIN medals m
	ON dam.medal_id = m.id
JOIN disciplines d
	ON d.id = dam.discipline_id
JOIN sports s
	ON d.sport_id = s.id
GROUP BY a.id, s.name
ORDER BY medals_count DESC, a.first_name
LIMIT 10;