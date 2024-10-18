DELIMITER $$

CREATE FUNCTION ufn_calculate_future_value(initial_sum DECIMAL(20, 4), 
										   year_interest_rate DECIMAL(12, 2),
                                           years INT)
RETURNS DECIMAL(12, 4) 
DETERMINISTIC
BEGIN
    RETURN (SELECT initial_sum * POW(1 + year_interest_rate, years));
END $$

DELIMITER ;

SELECT ufn_calculate_future_value(1000, 0.5, 5);
