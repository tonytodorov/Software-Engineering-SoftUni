DELIMITER $$

CREATE PROCEDURE udp_delay_flight(code VARCHAR(50))
BEGIN
	UPDATE flights
	SET departure = DATE_ADD(departure, INTERVAL 30 MINUTE), has_delay = 1
	WHERE flight_code = code;
END $$

DELIMITER ;

CALL udp_delay_flight('ZP-782');