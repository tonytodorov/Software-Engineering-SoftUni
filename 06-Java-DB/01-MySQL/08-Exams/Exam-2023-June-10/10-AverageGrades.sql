DELIMITER $$

CREATE FUNCTION udf_average_alumni_grade_by_course_name(course_name VARCHAR(60))
RETURNS DECIMAL(4, 2)
DETERMINISTIC
BEGIN
	RETURN (SELECT ROUND(AVG(sc.grade), 2) AS average_alumni_grade 
	FROM students s
	JOIN students_courses sc
		ON sc.student_id = s.id
	JOIN courses c
		ON c.id = sc.course_id
	WHERE is_graduated = 1 AND c.name = course_name);	
END $$

DELIMITER ;

SELECT c.name, udf_average_alumni_grade_by_course_name('Quantum Physics') AS average_alumni_grade 
FROM courses c 
WHERE c.name = 'Quantum Physics';

