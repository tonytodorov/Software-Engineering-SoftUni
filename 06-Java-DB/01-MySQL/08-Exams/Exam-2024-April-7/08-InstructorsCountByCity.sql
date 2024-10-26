SELECT c.name, COUNT(*) AS instructors_count
FROM cities c
JOIN driving_schools dc
	ON dc.city_id = c.id
JOIN instructors_driving_schools idc
	ON idc.driving_school_id = dc.id
JOIN instructors i
	ON i.id = idc.instructor_id
GROUP BY c.name
ORDER BY instructors_count DESC;