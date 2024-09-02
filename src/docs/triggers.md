
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