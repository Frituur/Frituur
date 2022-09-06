-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: frituur.mysql.database.azure.com    Database: frituur
-- ------------------------------------------------------
-- Server version	5.7.38-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `customers`
--

DROP TABLE IF EXISTS `customers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customers` (
  `customerid` int(11) NOT NULL AUTO_INCREMENT,
  `naam` varchar(255) DEFAULT NULL,
  `address` varchar(1000) DEFAULT NULL,
  `tijdslotid` int(11) DEFAULT NULL,
  `totalprice` double DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`customerid`),
  KEY `tijdslotid` (`tijdslotid`),
  CONSTRAINT `customers_ibfk_1` FOREIGN KEY (`tijdslotid`) REFERENCES `tijdslot` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=193 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customers`
--

LOCK TABLES `customers` WRITE;
/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
INSERT INTO `customers` VALUES (166,'Bram','Brusselstraat',9,8,NULL),(167,'Bram','Brusselstraat',9,7.1,NULL),(169,'Bram','Brusselstraat',9,7.6,NULL),(172,'Bart','Brouwerijstraat',22,5.1,NULL),(173,'Bert','Brusselstraat',22,15,NULL),(174,'Arno','Hoofdstraat',NULL,7.1,NULL),(175,'Bert','Brusselstraat',NULL,3.5,NULL),(176,'Rogier','Brusselstraat',NULL,3.1,NULL),(177,'Rogier','Brusselstraat',NULL,3.1,NULL),(178,'Bert','Brouwerijstraat',NULL,8,NULL),(179,'Rogier','Brouwerijstraat',NULL,6.6,NULL),(180,'Bert','Brouwerijstraat',NULL,7.5,NULL),(181,'Bram','Brouwerijstraat',NULL,3.1,NULL),(182,'Bram','Hoofdstraat',NULL,3.5,NULL),(183,'Rogier','bROUWERIJSTRAAT',NULL,3.1,NULL),(184,'Bert','Hoofdstraat',NULL,3.1,NULL),(185,'Bram','Brusselstraat',20,7.5,NULL),(187,'Bert','bROUWERIJSTRAAT',21,3.5,NULL),(188,'Bram','Hoofdstraat',NULL,3.5,NULL),(189,'Rogier','Hoofdstraat',18,3.5,'123-456-7890'),(190,'Rogier','Klottebergstraat 8 3272 Messelbroek',NULL,3.1,NULL),(192,'tedst','test',NULL,NULL,NULL);
/*!40000 ALTER TABLE `customers` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-09-06  3:05:20
