DELIMITER $$

CREATE FUNCTION ufn_is_word_comprised(set_of_letters VARCHAR(50), word VARCHAR(50))
RETURNS TINYINT
NO SQL
BEGIN
	DECLARE result TINYINT;
    SET result = (
		SELECT word REGEXP CONCAT('^[', set_of_letters ,']+$')
	);
    RETURN result;
END $$

DELIMITER ;

SELECT ufn_is_word_comprised('oistmiahf', 'Sofia');