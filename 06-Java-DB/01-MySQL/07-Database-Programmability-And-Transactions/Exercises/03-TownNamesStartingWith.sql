DELIMITER $$

CREATE PROCEDURE usp_get_towns_starting_with(`char` VARCHAR(50))
BEGIN
	SELECT name 
    FROM towns
    WHERE name LIKE CONCAT(`char`, '%')
    ORDER BY name;
END $$

DELIMITER ;

CALL usp_get_towns_starting_with('b');