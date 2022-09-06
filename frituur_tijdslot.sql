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
-- Table structure for table `tijdslot`
--

DROP TABLE IF EXISTS `tijdslot`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tijdslot` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `begintime` varchar(255) DEFAULT NULL,
  `isavailable` tinyint(1) DEFAULT NULL,
  `numcustomers` int(11) DEFAULT NULL,
  `maxcustomers` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tijdslot`
--

LOCK TABLES `tijdslot` WRITE;
/*!40000 ALTER TABLE `tijdslot` DISABLE KEYS */;
INSERT INTO `tijdslot` VALUES (1,'14:00:00',1,0,3),(2,'14:20:00',0,0,3),(3,'14:40:00',1,0,3),(4,'15:00:00',1,0,3),(5,'15:20:00',1,0,3),(6,'15:40:00',1,0,3),(7,'16:00:00',1,0,3),(8,'16:20:00',1,0,3),(9,'16:40:00',0,4,3),(10,'17:00:00',0,0,3),(11,'17:20:00',1,0,3),(12,'17:40:00',0,0,3),(13,'18:00:00',1,0,3),(14,'18:20:00',1,0,3),(15,'18:40:00',1,0,3),(16,'19:00:00',0,0,3),(17,'19:20:00',1,0,3),(18,'19:40:00',1,1,3),(19,'20:00:00',1,1,3),(20,'20:20:00',1,1,3),(21,'20:40:00',1,1,3),(22,'21:00:00',1,3,3),(23,'21:20:00',0,0,3),(24,'21:40:00',1,0,3),(25,'22:00:00',1,0,3);
/*!40000 ALTER TABLE `tijdslot` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-09-06  3:05:18
