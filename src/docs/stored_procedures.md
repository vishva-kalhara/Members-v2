```
DROP PROCEDURE IF EXISTS `get_profit_of_yr_and_month`;

DELIMITER $$

CREATE PROCEDURE get_profit_of_yr_and_month(IN inputYr INT, IN inputMonth INT)
BEGIN

	SELECT SUM(`paid_amount`) AS `monthlyTotal` FROM subscriptions WHERE YEAR(`created_at`) = inputYr AND MONTH(`created_at`) = inputMonth;

END$$

DELIMITER ;
```