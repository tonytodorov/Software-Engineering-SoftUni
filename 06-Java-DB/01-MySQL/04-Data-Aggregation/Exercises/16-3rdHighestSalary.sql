SELECT e.department_id, (
	SELECT DISTINCT ssalary 
	FROM employees
	WHERE department_id = e.department_id
	ORDER BY salary DESC
	LIMIT 1 OFFSET 2
) AS third_highest_salary
FROM employees AS e
GROUP BY e.department_id
HAVING third_highest_salary IS NOT NULL
ORDER BY e.department_id;

/* SELECT DISTINCT salary 
FROM employees
WHERE department_id = 1
ORDER BY salary DESC
LIMIT 1 OFFSET 2 */