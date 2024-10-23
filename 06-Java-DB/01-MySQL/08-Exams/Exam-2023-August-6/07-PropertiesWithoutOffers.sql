SELECT LEFT(address, 6) AS agent_name, 
	CHAR_LENGTH(address) * 5430 AS price FROM properties p
LEFT JOIN property_offers po
	ON p.id = po.property_id
WHERE property_id IS NULL
ORDER BY agent_name DESC, price DESC;
