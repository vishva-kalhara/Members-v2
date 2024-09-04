```
DROP TRIGGER IF EXISTS `before_create_employee`;

DELIMITER $$

CREATE TRIGGER `before_create_employee`
BEFORE INSERT ON `members_v2`.`employees`
FOR EACH ROW
BEGIN

	DECLARE newId INT;
    DECLARE nicCount INT;
    DECLARE usernameCount INT;
    
    SELECT count(*) INTO nicCount FROM `members_v2`.`employees` WHERE `nic` = NEW.nic;
    IF nicCount != 0 THEN
		SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'There is already an employee with the same NIC!';
        
	ELSE IF NEW.username IS NOT NULL AND NEW.username != '' THEN
		
		SELECT count(*) INTO usernameCount FROM `members_v2`.`employees` WHERE `username` = NEW.`username`;
			
		IF usernameCount != 0 THEN 
			SIGNAL SQLSTATE '45000'
			SET MESSAGE_TEXT = 'Username is already taken!';
		END IF;
	END IF;
    END IF;

    
    SELECT count(*) INTO newId FROM `members_v2`.`employees`;
    
    SET NEW.id = CONCAT('emp-', newId + 1);
    SET NEW.created_at = NOW();

END$$

DELIMITER ;
```

```
DROP TRIGGER IF EXISTS `before_insert_package`;

DELIMITER $$

CREATE TRIGGER `before_insert_package`
BEFORE INSERT ON `members_v2`.packages
FOR EACH ROW
BEGIN

	DECLARE totalCount INT;
    DECLARE titleCount INT;
    
    SELECT COUNT(*) INTO titleCount FROM `members_v2`.packages WHERE title = NEW.title;
    
    IF titleCount != 0 THEN
		SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'There is already a package with the same title';
    END IF;
    
    SELECT COUNT(*) INTO totalCount FROM `members_v2`.packages;
    
    SET NEW.id = CONCAT('pkg-', totalCount + 1);

END$$

DELIMITER ;
```

```
DROP TRIGGER IF EXISTS `before_update_package`;

DELIMITER $$

CREATE TRIGGER `before_update_package`
BEFORE UPDATE ON `members_v2`.`packages`
FOR EACH ROW
BEGIN

	DECLARE total INT;
    
    IF NEW.title != OLD.title THEN
    
		SELECT COUNT(*) INTO total FROM `members_v2`.`packages` WHERE `title` = NEW.title;
		IF total > 0 THEN
			SIGNAL SQLSTATE '45000'
			SET MESSAGE_TEXT = 'There is already a package with the same title.';
		END IF;
    END IF;

END$$

DELIMITER ;
```

```
DROP TRIGGER IF EXISTS `before_insert_app_data`;

DELIMITER $$

CREATE TRIGGER `before_insert_app_data`
BEFORE INSERT ON `members_v2`.`app_data`
FOR EACH ROW
BEGIN

	DECLARE count INT;
    
    SELECT COUNT(*) INTO count FROM `members_v2`.`app_data`;
    
    IF count > 0 THEN
		SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Please contact the vendor.';
	END IF;

END$$

DELIMITER ;
```

```
DROP TRIGGER IF EXISTS `before_insert_customer`;

DELIMITER $$

CREATE TRIGGER `before_insert_customer`
BEFORE INSERT ON `customers`
FOR EACH ROW
BEGIN

	DECLARE total INT;
    
    SELECT COUNT(*) INTO total FROM `members_v2`.`customers`;
    
    SET NEW.id = CONCAT('cus-', total + 1);
    SET NEW.created_at = NOW();
    SET NEW.cardId = CONCAT('cus-', total + 1);

END$$

DELIMITER ;
```