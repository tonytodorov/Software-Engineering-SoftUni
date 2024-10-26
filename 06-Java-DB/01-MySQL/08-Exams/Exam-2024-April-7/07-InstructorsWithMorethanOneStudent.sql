SET sql_mode = (SELECT REPLACE(@@sql_mode, 'ONLY_FULL_GROUP_BY', ''));

SELECT i.first_name, i.last_name, COUNT(*) AS students_count, c.name
FROM instructors i
JOIN instructors_students `is` ON i.id = `is`.instructor_id
JOIN instructors_driving_schools idc ON i.id = idc.instructor_id
JOIN driving_schools dc ON idc.driving_school_id = dc.id
JOIN cities c ON dc.city_id = c.id
GROUP BY i.id
HAVING students_count > 1
ORDER BY students_count DESC, i.first_name;
