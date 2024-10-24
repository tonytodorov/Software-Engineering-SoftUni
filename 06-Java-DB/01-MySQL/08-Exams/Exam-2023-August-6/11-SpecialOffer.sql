DELIMITER $$

CREATE PROCEDURE udp_special_offer(name VARCHAR(50)) 
BEGIN
	UPDATE property_offers po
	JOIN agents a
		ON po.agent_id = a.id
	SET po.price = po.price * 0.9
	WHERE a.first_name = name;
END $$

DELIMITER ;

CALL udp_special_offer('Hans');