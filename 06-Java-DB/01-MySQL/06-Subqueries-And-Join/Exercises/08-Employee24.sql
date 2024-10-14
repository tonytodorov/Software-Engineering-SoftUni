SELECT e.employee_id, e.first_name, 
	CASE
		WHEN p.start_date >= '2005-01-01' THEN NULL
        ELSE p.name
	END AS project_name
FROM projects p
JOIN employees_projects ep
	ON p.project_id = ep.project_id
JOIN employees e
	ON e.employee_id = ep.employee_id
WHERE e.employee_id = 24
ORDER BY p.name;