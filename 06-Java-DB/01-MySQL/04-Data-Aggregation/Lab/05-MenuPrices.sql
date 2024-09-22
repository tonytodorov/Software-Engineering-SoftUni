SELECT category_id, ROUND(AVG(price), 2), MIN(price), MAX(price)
FROM products
GROUP BY category_id;