SELECT COUNT(category_id)
FROM products
WHERE price > 8
GROUP BY category_id
HAVING category_id = 2;