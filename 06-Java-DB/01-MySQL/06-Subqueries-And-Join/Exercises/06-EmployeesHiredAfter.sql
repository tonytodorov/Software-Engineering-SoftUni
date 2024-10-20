SELECT e.first_name, e.last_name, e.hire_date, d.name AS dept_name
FROM employees e
JOIN departments d
	ON e.department_id = d.department_id
WHERE e.hire_date > '1999-01-01' AND d.name IN ('Sales', 'Finance')
ORDER BY hire_date;