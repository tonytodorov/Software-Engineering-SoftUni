SELECT CONCAT_WS(' ', first_name, last_name) AS full_name, age
FROM students
WHERE first_name LIKE '%a%' AND age < 20
ORDER BY id;