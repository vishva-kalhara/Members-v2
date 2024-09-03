```
DROP TRIGGER IF EXISTS `before_create_employee`;

DELIMITER $$

CREATE TRIGGER `before_create_employee`
BEFORE INSERT ON `members`.`employees`
FOR EACH ROW
BEGIN

	DECLARE newId INT;
    DECLARE nicCount INT;
    DECLARE usernameCount INT;
    
    SELECT count(*) INTO nicCount FROM `members`.`employees` WHERE `nic` = NEW.nic;
    IF nicCount != 0 THEN
		SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'There is already an employee with the same NIC!';
        
	ELSE IF NEW.username IS NOT NULL AND NEW.username != '' THEN
		
		SELECT count(*) INTO usernameCount FROM `members`.`employees` WHERE `username` = NEW.`username`;
			
		IF usernameCount != 0 THEN 
			SIGNAL SQLSTATE '45000'
			SET MESSAGE_TEXT = 'Username is already taken!';
		END IF;
	END IF;
    END IF;

    
    SELECT count(*) INTO newId FROM `members`.`employees`;
    
    SET NEW.id = CONCAT('emp-', newId + 1);
    SET NEW.created_at = NOW();

END$$

DELIMITER ;
```

```
DROP TRIGGER IF EXISTS `before_insert_package`;

DELIMITER $$

CREATE TRIGGER `before_insert_package`
BEFORE INSERT ON members.packages
FOR EACH ROW
BEGIN

	DECLARE totalCount INT;
    DECLARE titleCount INT;
    
    SELECT COUNT(*) INTO titleCount FROM members.packages WHERE title = NEW.title;
    
    IF titleCount != 0 THEN
		SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'There is already a package with the same title';
    END IF;
    
    SELECT COUNT(*) INTO totalCount FROM members.packages;
    
    SET NEW.id = CONCAT('pkg-', totalCount + 1);

END$$

DELIMITER ;
```

```
DROP TRIGGER IF EXISTS `before_update_package`;

DELIMITER $$

CREATE TRIGGER `before_update_package`
BEFORE UPDATE ON `members`.`packages`
FOR EACH ROW
BEGIN

	DECLARE total INT;
    
    IF NEW.title != OLD.title THEN
    
		SELECT COUNT(*) INTO total FROM `members`.`packages` WHERE `title` = NEW.title;
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
BEFORE INSERT ON `members`.`app_data`
FOR EACH ROW
BEGIN

	DECLARE count INT;
    
    SELECT COUNT(*) INTO count FROM `members`.`app_data`;
    
    IF count > 0 THEN
		SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Please contact the vendor.';
	END IF;

END$$

DELIMITER ;
```

```
DROP TRIGGER IF EXISTS `before_insert_member`;

DELIMITER $$

CREATE TRIGGER `before_insert_member`
BEFORE INSERT ON `members`.`members`
FOR EACH ROW
BEGIN

	DECLARE total INT;
    
    SELECT COUNT(*) INTO total FROM `members`.`members`;
    
    SET NEW.id = CONCAT('mbr-', total + 1);
    SET NEW.created_at = NOW();
    SET NEW.card_id = CONCAT('mbr-', total + 1);

END$$

DELIMITER ;
```