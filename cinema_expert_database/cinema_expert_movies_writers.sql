-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: cinema_expert
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Table structure for table `movies_writers`
--

use cinema_expert;

DROP TABLE IF EXISTS `movies_writers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movies_writers` (
  `movie_id` bigint NOT NULL,
  `person_id` bigint NOT NULL,
  PRIMARY KEY (`movie_id`,`person_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movies_writers`
--

LOCK TABLES `movies_writers` WRITE;
/*!40000 ALTER TABLE `movies_writers` DISABLE KEYS */;
INSERT INTO `movies_writers` VALUES (1,95),(2,29),(3,95),(4,29),(5,29),(6,23),(7,191),(8,121),(9,141),(10,145),(11,121),(12,14),(13,11),(13,192),(14,9),(15,14),(16,162),(17,13),(18,121),(19,9),(20,9),(21,121),(22,9),(23,262),(24,48),(25,289),(26,13),(27,14),(28,160),(29,13),(30,160),(31,13),(32,76),(33,154),(34,76),(35,151),(36,59),(37,49),(38,115),(39,76),(40,259),(41,13),(42,109),(43,61),(44,277),(45,81),(46,151),(47,160),(48,125),(49,27),(50,261),(51,13),(52,165),(53,320),(54,325),(55,61),(56,59),(57,146),(58,27),(59,62),(60,61),(61,125),(62,211),(62,285),(63,25),(64,62),(65,144),(66,41),(67,101),(68,85),(69,204),(70,185),(71,134),(72,189),(73,90),(74,288),(75,258),(76,144),(77,156),(78,61),(79,330),(79,331),(80,85),(81,156),(82,156),(83,207),(84,115),(85,201),(86,209),(87,295),(88,93),(89,288),(90,110),(91,272),(91,281),(92,241),(93,62),(94,299),(95,197),(96,59),(97,327),(98,295),(99,295),(100,295),(101,199),(102,230),(102,300),(103,250),(104,328),(105,295),(106,295),(107,292),(107,324),(108,349),(109,62),(110,329),(111,327),(111,363),(112,365),(113,310),(113,311),(114,310),(114,311),(115,304),(115,307),(115,357),(116,348),(117,218),(118,301),(119,353);
/*!40000 ALTER TABLE `movies_writers` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-08-15 13:06:10
