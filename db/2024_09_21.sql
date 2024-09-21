-- MySQL dump 10.13  Distrib 8.0.35, for Win64 (x86_64)
--
-- Host: localhost    Database: members_v2
-- ------------------------------------------------------
-- Server version	8.0.35

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `app_data`
--

DROP TABLE IF EXISTS `app_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `app_data` (
  `id` int NOT NULL AUTO_INCREMENT,
  `shop_name` varchar(45) NOT NULL,
  `shop_mobile` varchar(10) NOT NULL,
  `shop_address` varchar(60) NOT NULL,
  `param1` varchar(10) DEFAULT NULL,
  `param2` varchar(10) DEFAULT NULL,
  `param3` varchar(10) DEFAULT NULL,
  `param4` varchar(10) DEFAULT NULL,
  `param5` varchar(10) DEFAULT NULL,
  `available_currencies_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_app_data_available_currencies1_idx` (`available_currencies_id`),
  CONSTRAINT `fk_app_data_available_currencies1` FOREIGN KEY (`available_currencies_id`) REFERENCES `available_currencies` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `app_data`
--

LOCK TABLES `app_data` WRITE;
/*!40000 ALTER TABLE `app_data` DISABLE KEYS */;
INSERT INTO `app_data` VALUES (1,'Mr. Gym','0766801657','Dankotuwa',NULL,NULL,NULL,NULL,NULL,14);
/*!40000 ALTER TABLE `app_data` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `before_insert_app_data` BEFORE INSERT ON `app_data` FOR EACH ROW BEGIN

	DECLARE count INT;
    
    SELECT COUNT(*) INTO count FROM `members_v2`.`app_data`;
    
    IF count > 0 THEN
		SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Please contact the vendor.';
	END IF;

END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `attendance`
--

DROP TABLE IF EXISTS `attendance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `attendance` (
  `id` int NOT NULL AUTO_INCREMENT,
  `marked_at` datetime NOT NULL,
  `subscriptions_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_attendance_subscriptions1_idx` (`subscriptions_id`),
  CONSTRAINT `fk_attendance_subscriptions1` FOREIGN KEY (`subscriptions_id`) REFERENCES `subscriptions` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attendance`
--

LOCK TABLES `attendance` WRITE;
/*!40000 ALTER TABLE `attendance` DISABLE KEYS */;
INSERT INTO `attendance` VALUES (1,'2024-09-06 20:11:59',5),(2,'2024-09-06 20:12:38',3),(3,'2024-09-06 20:14:27',5),(4,'2024-09-06 20:14:59',5),(5,'2024-09-06 20:15:03',5),(6,'2024-09-06 20:15:07',5),(7,'2024-09-06 20:15:11',5),(8,'2024-09-08 21:54:19',4),(9,'2024-09-13 15:27:11',6),(10,'2024-09-14 22:41:44',1),(11,'2024-09-15 21:53:49',9),(12,'2024-09-15 21:53:56',9),(13,'2024-09-15 21:54:01',9),(14,'2024-09-16 12:49:46',1),(15,'2024-09-16 12:49:54',6),(16,'2024-09-16 12:50:01',9),(17,'2024-09-16 12:50:04',4),(18,'2024-09-16 12:52:16',6),(19,'2024-09-16 12:52:20',1),(20,'2024-09-20 22:23:58',9);
/*!40000 ALTER TABLE `attendance` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `before_insert_attendance` BEFORE INSERT ON `attendance` FOR EACH ROW BEGIN

	SET NEW.marked_at = NOW();

END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `available_currencies`
--

DROP TABLE IF EXISTS `available_currencies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `available_currencies` (
  `id` int NOT NULL AUTO_INCREMENT,
  `value` varchar(5) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `available_currencies`
--

LOCK TABLES `available_currencies` WRITE;
/*!40000 ALTER TABLE `available_currencies` DISABLE KEYS */;
INSERT INTO `available_currencies` VALUES (12,'USD'),(13,'EUR'),(14,'LKR'),(15,'GBP'),(16,'JPY'),(17,'AUD'),(18,'CAD'),(19,'CHF'),(20,'CNY'),(21,'INR'),(22,'SGD');
/*!40000 ALTER TABLE `available_currencies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customers`
--

DROP TABLE IF EXISTS `customers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customers` (
  `id` varchar(15) NOT NULL,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `mobile1` varchar(10) NOT NULL,
  `mobile2` varchar(10) DEFAULT NULL,
  `email` varchar(60) DEFAULT NULL,
  `nic` varchar(16) DEFAULT NULL,
  `created_at` datetime NOT NULL,
  `cardId` varchar(15) NOT NULL,
  `gender_id` int NOT NULL,
  `statuses_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_customers_gender1_idx` (`gender_id`),
  KEY `fk_customers_statuses1_idx` (`statuses_id`),
  CONSTRAINT `fk_customers_gender1` FOREIGN KEY (`gender_id`) REFERENCES `gender` (`id`),
  CONSTRAINT `fk_customers_statuses1` FOREIGN KEY (`statuses_id`) REFERENCES `statuses` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customers`
--

LOCK TABLES `customers` WRITE;
/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
INSERT INTO `customers` VALUES ('cus-1','Alexander','Williams','0791890122',NULL,NULL,'2006419850','2024-09-05 17:38:50','cus-1',2,2),('cus-10','William','Davis','0728813112',NULL,NULL,'2007144595','2024-09-05 17:40:00','cus-10',2,3),('cus-11','Sophia','Gonzalez','0784948928','','','2004371244','2024-09-05 17:40:00','cus-11',1,1),('cus-12','Jane','Anderson','0791139525',NULL,NULL,'2004141728','2024-09-05 17:40:00','cus-12',2,3),('cus-13','John','Wilson','0754045572',NULL,NULL,'2006456745','2024-09-05 17:40:00','cus-13',1,3),('cus-2','John','Gonzalez','0789088850',NULL,NULL,'2001580514','2024-09-05 17:38:50','cus-2',1,3),('cus-3','William','Rodriguez','0786360121',NULL,NULL,'2000280133','2024-09-05 17:38:50','cus-3',2,3),('cus-4','Isabella','Williams','0763692661',NULL,NULL,'2002241459','2024-09-05 17:38:50','cus-4',2,1),('cus-5','James','Rodriguez','0746524462',NULL,NULL,'2006301062','2024-09-05 17:38:50','cus-5',1,2),('cus-6','William','Davis','0730611705','','','2007436878','2024-09-05 17:38:50','cus-6',2,3),('cus-7','Emily','Gonzalez','0724253727','','emily@example.com','2001827742','2024-09-05 17:38:50','cus-7',2,1),('cus-8','Wishva','Chandrasekara','0768116541','','','2004170901','2024-09-05 17:39:45','cus-8',2,1),('cus-9','James','Anderson','0730417734',NULL,NULL,'2005816745','2024-09-05 17:39:45','cus-9',1,1);
/*!40000 ALTER TABLE `customers` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `before_insert_customer` BEFORE INSERT ON `customers` FOR EACH ROW BEGIN

	DECLARE total INT;
    DECLARE nicTotal INT;
    
    IF NEW.nic != '' THEN
		SELECT COUNT(*) INTO nicTotal FROM `members_v2`.`customers` WHERE `nic` = NEW.nic;
        
        IF nicTotal > 0 THEN
			SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'There is already a member with the same NIC.';
        END IF;
	END IF;
    
    SELECT COUNT(*) INTO total FROM `members_v2`.`customers`;
    
    SET NEW.id = CONCAT('cus-', total + 1);
    SET NEW.created_at = NOW();
    SET NEW.cardId = CONCAT('cus-', total + 1);

END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `before_update_customer` BEFORE UPDATE ON `customers` FOR EACH ROW BEGIN

	DECLARE nicTotal INT;
    DECLARE emailTotal INT;
    
    IF NEW.nic != OLD.nic THEN
    
		SELECT COUNT(*) INTO nicTotal FROM `customers` WHERE `nic` = NEW.nic;
        
        IF nicTotal > 0 THEN
            
			SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'There is a customer with the same NIC.';
		END IF;
	END IF;
    
    IF NEW.email != OLD.email THEN
    
		SELECT COUNT(*) INTO emailTotal FROM `customers` WHERE `email` = NEW.email;
        
        IF emailTotal > 0 THEN
			SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'There is a customer with the same Email.';
		END IF;
	END IF;

END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `debug_log`
--

DROP TABLE IF EXISTS `debug_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `debug_log` (
  `id` int NOT NULL AUTO_INCREMENT,
  `message` varchar(255) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `debug_log`
--

LOCK TABLES `debug_log` WRITE;
/*!40000 ALTER TABLE `debug_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `debug_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employees`
--

DROP TABLE IF EXISTS `employees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employees` (
  `id` varchar(7) NOT NULL,
  `username` varchar(25) DEFAULT NULL,
  `password` varchar(25) DEFAULT NULL,
  `created_at` datetime NOT NULL,
  `user_roles_id` int DEFAULT NULL,
  `mobile1` varchar(10) NOT NULL,
  `mobile2` varchar(10) DEFAULT NULL,
  `address1` varchar(100) NOT NULL,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `nic` varchar(15) NOT NULL,
  `statuses_id` int NOT NULL,
  `gender_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_system_login_user_roles1_idx` (`user_roles_id`),
  KEY `fk_employees_statuses1_idx` (`statuses_id`),
  KEY `fk_employees_gender1_idx` (`gender_id`),
  CONSTRAINT `fk_employees_gender1` FOREIGN KEY (`gender_id`) REFERENCES `gender` (`id`),
  CONSTRAINT `fk_employees_statuses1` FOREIGN KEY (`statuses_id`) REFERENCES `statuses` (`id`),
  CONSTRAINT `fk_system_login_user_roles1` FOREIGN KEY (`user_roles_id`) REFERENCES `user_roles` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employees`
--

LOCK TABLES `employees` WRITE;
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT INTO `employees` VALUES ('emp-1','super','123456789','2024-09-04 10:24:08',1,'0766801658',NULL,'Dankotuwa','Wishva','Chandrasekara','200330010768',1,1),('emp-2','melani','123456789','2024-09-04 10:37:33',4,'0766801654','','Wennappuwa','Sophia','Gonsalez','200330010762',1,2),('emp-3',NULL,NULL,'2024-09-16 14:40:29',NULL,'0766801652','','United States','John','Doe','200330010761',1,1);
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `before_create_employee` BEFORE INSERT ON `employees` FOR EACH ROW BEGIN

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

END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `gender`
--

DROP TABLE IF EXISTS `gender`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gender` (
  `id` int NOT NULL AUTO_INCREMENT,
  `value` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gender`
--

LOCK TABLES `gender` WRITE;
/*!40000 ALTER TABLE `gender` DISABLE KEYS */;
INSERT INTO `gender` VALUES (1,'Male'),(2,'Female'),(3,'Other');
/*!40000 ALTER TABLE `gender` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `packages`
--

DROP TABLE IF EXISTS `packages`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `packages` (
  `id` varchar(7) NOT NULL,
  `title` varchar(45) NOT NULL,
  `price` double NOT NULL,
  `validity` int NOT NULL,
  `statuses_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_packages_statuses1_idx` (`statuses_id`),
  CONSTRAINT `fk_packages_statuses1` FOREIGN KEY (`statuses_id`) REFERENCES `statuses` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `packages`
--

LOCK TABLES `packages` WRITE;
/*!40000 ALTER TABLE `packages` DISABLE KEYS */;
INSERT INTO `packages` VALUES ('pkg-1','Monthly Plan',4500,30,1),('pkg-2','Mr. One Day',450,1,1),('pkg-3','Annual Plan',50000,365,2);
/*!40000 ALTER TABLE `packages` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `before_insert_package` BEFORE INSERT ON `packages` FOR EACH ROW BEGIN

	DECLARE totalCount INT;
    DECLARE titleCount INT;
    
    SELECT COUNT(*) INTO titleCount FROM members_v2.packages WHERE title = NEW.title;
    
    IF titleCount != 0 THEN
		SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'There is already a package with the same title';
    END IF;
    
    SELECT COUNT(*) INTO totalCount FROM members_v2.packages;
    
    SET NEW.id = CONCAT('pkg-', totalCount + 1);

END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `before_update_package` BEFORE UPDATE ON `packages` FOR EACH ROW BEGIN

	DECLARE total INT;
    
    IF NEW.title != OLD.title THEN
    
		SELECT COUNT(*) INTO total FROM `members_v2`.`packages` WHERE `title` = NEW.title;
		IF total > 0 THEN
			SIGNAL SQLSTATE '45000'
			SET MESSAGE_TEXT = 'There is already a package with the same title.';
		END IF;
    END IF;

END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `statuses`
--

DROP TABLE IF EXISTS `statuses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `statuses` (
  `id` int NOT NULL AUTO_INCREMENT,
  `value` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `statuses`
--

LOCK TABLES `statuses` WRITE;
/*!40000 ALTER TABLE `statuses` DISABLE KEYS */;
INSERT INTO `statuses` VALUES (1,'Active'),(2,'Inactive'),(3,'Deleted');
/*!40000 ALTER TABLE `statuses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subscriptions`
--

DROP TABLE IF EXISTS `subscriptions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subscriptions` (
  `id` int NOT NULL AUTO_INCREMENT,
  `paid_amount` double NOT NULL,
  `start` date NOT NULL,
  `end` date NOT NULL,
  `created_at` datetime NOT NULL,
  `employees_id` varchar(7) NOT NULL,
  `packages_id` varchar(7) NOT NULL,
  `customers_id` varchar(15) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_subscriptions_employees1_idx` (`employees_id`),
  KEY `fk_subscriptions_packages1_idx` (`packages_id`),
  KEY `fk_subscriptions_customers1_idx` (`customers_id`),
  CONSTRAINT `fk_subscriptions_customers1` FOREIGN KEY (`customers_id`) REFERENCES `customers` (`id`),
  CONSTRAINT `fk_subscriptions_employees1` FOREIGN KEY (`employees_id`) REFERENCES `employees` (`id`),
  CONSTRAINT `fk_subscriptions_packages1` FOREIGN KEY (`packages_id`) REFERENCES `packages` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subscriptions`
--

LOCK TABLES `subscriptions` WRITE;
/*!40000 ALTER TABLE `subscriptions` DISABLE KEYS */;
INSERT INTO `subscriptions` VALUES (1,4500,'2024-09-05','2024-10-04','2024-09-05 23:46:14','emp-1','pkg-1','cus-7'),(3,450,'2024-09-06','2024-09-06','2024-09-06 16:38:40','emp-1','pkg-2','cus-9'),(4,4500,'2024-09-07','2024-10-06','2024-09-06 16:39:29','emp-1','pkg-1','cus-9'),(5,450,'2024-09-07','2024-09-07','2024-09-06 17:30:19','emp-1','pkg-2','cus-8'),(6,4500,'2024-08-13','2024-10-12','2024-08-13 15:26:36','emp-1','pkg-1','cus-4'),(7,450,'2024-10-05','2024-10-05','2024-09-14 22:21:17','emp-1','pkg-2','cus-7'),(8,450,'2024-10-13','2024-10-13','2024-09-15 19:23:28','emp-1','pkg-2','cus-4'),(9,4500,'2024-09-08','2024-10-07','2024-09-15 21:53:40','emp-1','pkg-1','cus-8'),(10,450,'2024-10-08','2024-10-08','2024-09-15 22:21:43','emp-1','pkg-2','cus-8'),(11,4500,'2024-10-07','2024-11-05','2024-09-16 15:20:07','emp-1','pkg-1','cus-9'),(12,450,'2024-09-17','2024-09-17','2024-09-17 21:01:17','emp-1','pkg-2','cus-11'),(13,4500,'2024-10-06','2024-11-04','2024-09-18 11:51:41','emp-1','pkg-1','cus-7');
/*!40000 ALTER TABLE `subscriptions` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `before_insert_subscription` BEFORE INSERT ON `subscriptions` FOR EACH ROW BEGIN

	SET NEW.created_at = NOW();

END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `user_roles`
--

DROP TABLE IF EXISTS `user_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_roles` (
  `id` int NOT NULL AUTO_INCREMENT,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_roles`
--

LOCK TABLES `user_roles` WRITE;
/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;
INSERT INTO `user_roles` VALUES (1,'SA'),(2,'Owner'),(3,'Manager'),(4,'Front');
/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-09-21 21:08:21
