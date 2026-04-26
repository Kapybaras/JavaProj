-- MySQL dump 10.13  Distrib 8.0.40, for Win64 (x86_64)
--
-- Host: mysql.cs.bangor.ac.uk    Database: lkg24ndq
-- ------------------------------------------------------
-- Server version	5.5.5-10.5.9-MariaDB

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
-- Table structure for table `nouns`
--

DROP TABLE IF EXISTS `nouns`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nouns` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `welsh` varchar(100) DEFAULT NULL,
  `english` varchar(100) DEFAULT NULL,
  `gender` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nouns`
--

LOCK TABLES `nouns` WRITE;
/*!40000 ALTER TABLE `nouns` DISABLE KEYS */;
INSERT INTO `nouns` VALUES (1,'bachgen','Boy','Masculine'),(2,'brawd','Brother','Masculine'),(3,'ceffyl','Horse','Masculine'),(4,'ci','Dog','Masculine'),(5,'coron','Coin of old money','Masculine'),(6,'De','South','Masculine'),(7,'dyn','Man','Masculine'),(8,'Gaeaf','Winter','Masculine'),(9,'Gwaith','Work','Masculine'),(10,'Haf','Summer','Masculine'),(11,'Meddyg','Doctor','Masculine'),(12,'Plentyn','Child','Masculine'),(13,'Porth','Door','Masculine'),(14,'Tarw','Bull','Masculine'),(15,'Pysgod','Fish','Masculine'),(16,'Mwnci','Monkey','Masculine'),(17,'Isaf','Underwear','Masculine'),(18,'Ty','house','Masculine'),(19,'Arfer','Habit','Feminine'),(20,'Bont','Bridge','Feminine'),(21,'Cadair','Chair','Feminine'),(22,'Caseg','Mare','Feminine'),(23,'Cath','Cat','Feminine'),(24,'Cegin','Kitchen','Feminine'),(25,'Dinas','City','Feminine'),(26,'Fford','Road','Feminine'),(27,'Gardd','Garden','Feminine'),(28,'Llaw','Hand','Feminine'),(29,'Llori','Lorry','Feminine'),(30,'Mam','Mother','Feminine'),(31,'SÃªr','Star','Feminine'),(32,'Merch','Girl','Feminine'),(33,'Sgwrs','Conversation','Feminine'),(34,'Buwch','Cow','Feminine'),(35,'Ysgol','School','Feminine'),(36,'Moron','Carrot','Feminine');
/*!40000 ALTER TABLE `nouns` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-04-26 18:56:33
