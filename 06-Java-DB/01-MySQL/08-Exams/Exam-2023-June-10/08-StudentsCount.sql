SELECT COUNT(*) AS students_count, u.name AS university_name
FROM universities u
JOIN courses c
	ON c.university_id = u.id
JOIN students_courses sc
	ON sc.course_id = c.id
GROUP BY u.name
HAVING students_count >= 8
ORDER BY students_count DESC, u.name DESC;