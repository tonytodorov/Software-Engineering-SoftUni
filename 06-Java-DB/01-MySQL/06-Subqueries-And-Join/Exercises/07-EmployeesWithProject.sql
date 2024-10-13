SELECT e.employee_id, e.first_name, p.name AS project_name
FROM projects p
JOIN employees_projects ep
	ON p.project_id = ep.project_id
JOIN employees e
	ON e.employee_id = ep.employee_id
WHERE p.start_date >= '2002-08-14' AND p.end_date IS NULL
ORDER BY e.first_name, p.name
LIMIT 5;