SELECT 
	CONCAT(s.first_name, ' ', s.last_name) AS full_name,
    SUBSTRING(s.email FROM 2 FOR 10) AS username,
    REVERSE(s.phone) AS password
FROM students s
LEFT JOIN students_courses sc
	ON s.id = sc.student_id
LEFT JOIN courses c
	ON sc.course_id = c.id
WHERE sc.student_id IS NULL
ORDER BY password DESC;