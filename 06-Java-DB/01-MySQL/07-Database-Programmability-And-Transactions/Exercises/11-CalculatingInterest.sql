DELIMITER $$

CREATE PROCEDURE usp_calculate_future_value_for_account(acc_id INT, 
									interest_rate DECIMAL(12, 4))
BEGIN
	SELECT a.id AS account_id, first_name, last_name, balance AS current_balance,
		ufn_calculate_future_value(balance, interest_rate, 5) AS balance_in_5_years
	FROM accounts a
	JOIN account_holders ac
		ON a.account_holder_id = ac.id
	WHERE a.id = acc_id;
END $$

DELIMITER ;

CALL usp_calculate_future_value_for_account(12, 0.1)