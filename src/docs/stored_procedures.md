```
DROP PROCEDURE IF EXISTS `get_profit_of_yr_and_month`;

DELIMITER $$

CREATE PROCEDURE get_profit_of_yr_and_month(IN inputYr INT, IN inputMonth INT)
BEGIN

	SELECT SUM(`paid_amount`) AS `monthlyTotal` FROM subscriptions WHERE YEAR(`created_at`) = inputYr AND MONTH(`created_at`) = inputMonth;

END$$

DELIMITER ;
```

```
DROP PROCEDURE IF EXISTS get_count_of_package;

DELIMITER $$

CREATE PROCEDURE get_count_of_package(IN packageId VARCHAR(7), IN isThisPackage TINYINT, IN yr INT, IN mo INT)
BEGIN

	IF isThisPackage = 1 THEN
		SELECT COUNT(*) AS count FROM members_v2.subscriptions WHERE `packages_id` = packageId AND YEAR(`created_at`) = yr AND MONTH(`created_at`) = mo;
	ELSE 
		SELECT COUNT(*) AS count FROM members_v2.subscriptions WHERE `packages_id` != packageId AND YEAR(`created_at`) = yr AND MONTH(`created_at`) = mo;
	END IF;

END $$

DELIMITER ;
```