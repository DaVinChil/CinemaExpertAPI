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
-- Table structure for table `movies_genres`
--

DROP TABLE IF EXISTS `movies_genres`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movies_genres` (
  `movie_id` int NOT NULL,
  `genre_id` int NOT NULL,
  PRIMARY KEY (`movie_id`,`genre_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movies_genres`
--

LOCK TABLES `movies_genres` WRITE;
/*!40000 ALTER TABLE `movies_genres` DISABLE KEYS */;
INSERT INTO `movies_genres` VALUES (1,1),(1,2),(2,1),(2,3),(2,4),(3,5),(3,6),(3,7),(4,1),(4,3),(4,4),(5,1),(5,3),(5,8),(6,1),(6,6),(7,1),(7,4),(7,8),(8,1),(8,5),(8,6),(8,7),(8,9),(9,1),(9,4),(9,10),(9,11),(10,1),(11,1),(11,9),(12,1),(13,3),(13,4),(13,12),(14,6),(14,7),(15,1),(15,13),(16,1),(16,5),(17,1),(17,8),(18,1),(18,5),(18,6),(18,7),(19,4),(19,6),(19,7),(20,6),(20,7),(20,13),(20,14),(21,1),(21,3),(21,4),(22,6),(22,7),(22,15),(23,1),(23,6),(23,13),(24,1),(24,8),(24,14),(24,16),(25,1),(25,5),(26,3),(26,8),(27,1),(27,5),(27,6),(27,7),(28,14),(28,17),(29,2),(29,14),(30,17),(31,2),(31,5),(32,1),(32,5),(33,1),(33,3),(33,5),(34,1),(34,5),(35,1),(36,1),(36,5),(37,2),(37,11),(37,13),(37,14),(38,2),(38,15),(39,1),(39,6),(39,8),(40,2),(40,11),(40,13),(40,14),(41,1),(41,15),(42,1),(42,8),(43,13),(43,14),(44,2),(44,11),(44,13),(44,14),(45,1),(45,5),(46,1),(46,16),(46,18),(47,1),(47,5),(48,2),(48,3),(48,14),(49,2),(49,7),(49,13),(49,14),(50,1),(50,7),(50,8),(51,1),(51,8),(52,7),(52,13),(53,1),(53,8),(53,19),(54,1),(54,4),(55,13),(55,14),(56,1),(56,5),(56,16),(57,1),(57,5),(57,7),(58,2),(58,13),(59,5),(59,7),(60,1),(60,16),(60,20),(61,1),(61,4),(62,1),(62,10),(62,12),(62,14),(62,19),(63,1),(63,5),(63,7),(63,13),(64,1),(64,5),(65,1),(66,1),(66,8),(66,16),(66,20),(67,1),(67,5),(67,13),(68,1),(68,5),(68,6),(68,7),(69,3),(69,10),(69,11),(69,14),(69,19),(70,1),(70,5),(70,6),(70,7),(71,1),(71,3),(71,4),(71,8),(72,1),(72,4),(73,1),(73,5),(73,6),(73,7),(74,11),(74,13),(74,14),(74,19),(75,1),(75,5),(76,1),(76,5),(76,6),(76,11),(77,1),(77,11),(77,13),(77,14),(78,1),(78,8),(79,2),(79,13),(80,1),(81,1),(81,11),(81,13),(81,14),(82,1),(82,11),(82,13),(82,14),(83,1),(84,1),(84,13),(84,14),(85,1),(86,3),(86,5),(87,6),(87,7),(88,3),(88,4),(89,6),(89,10),(89,11),(89,14),(89,19),(90,1),(90,8),(90,16),(90,18),(91,1),(91,5),(92,1),(92,2),(92,4),(93,1),(93,8),(93,14),(94,1),(94,6),(94,7),(94,13),(95,1),(95,6),(95,7),(96,1),(96,5),(96,7),(97,3),(97,10),(97,11),(97,14),(97,19),(98,1),(98,5),(98,7),(98,13),(99,1),(99,2),(99,6),(99,7),(100,1),(100,2),(100,14),(101,2),(101,10),(101,14),(101,19),(102,1),(102,3),(102,10),(102,14),(102,19),(103,1),(103,3),(104,1),(104,6),(105,1),(105,7),(105,13),(106,2),(106,7),(106,13),(106,14),(107,1),(107,3),(107,16),(108,1),(109,1),(109,17),(110,1),(111,3),(111,6),(111,10),(111,11),(111,14),(111,18),(111,19),(112,1),(112,18),(113,2),(113,13),(113,14),(114,1),(114,2),(114,13),(114,14),(115,2),(115,3),(115,10),(115,11),(115,13),(115,14),(115,19),(116,1),(116,4),(116,11),(116,19),(117,1),(117,7),(118,1),(118,5),(118,7),(119,1);
/*!40000 ALTER TABLE `movies_genres` ENABLE KEYS */;
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