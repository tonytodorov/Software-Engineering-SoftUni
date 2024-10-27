SELECT CONCAT_WS(' ', first_name, last_name) AS full_name, 
TIMESTAMPDIFF(DAY, start_date, '2024-01-01') AS days_of_experience
FROM workers
WHERE TIMESTAMPDIFF(YEAR, start_date, '2024-01-01') > 5
ORDER BY days_of_experience DESC
LIMIT 10;


SELECT TIMESTAMPDIFF(DAY, start_date, '2024-01-01') FROM workers