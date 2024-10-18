DELIMITER $$

CREATE PROCEDURE usp_get_holders_with_balance_higher_than(supplied_number INT)
BEGIN
	SELECT ah.first_name, ah.last_name
	FROM account_holders ah
	JOIN accounts a
		ON a.account_holder_id = ah.id
	GROUP BY a.account_holder_id
	HAVING SUM(a.balance) > supplied_number
    ORDER BY ah.id;
END $$

DELIMITER ;

CALL usp_get_holders_with_balance_higher_than(7000);

