CREATE DATABASE  IF NOT EXISTS `gestione_aule` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `gestione_aule`;
-- MySQL dump 10.13  Distrib 8.0.46, for Win64 (x86_64)
--
-- Host: localhost    Database: gestione_aule
-- ------------------------------------------------------
-- Server version	8.0.46

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
-- Table structure for table `aule`
--

DROP TABLE IF EXISTS `aule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `aule` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `capienza` int NOT NULL,
  `edificio` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aule`
--

LOCK TABLES `aule` WRITE;
/*!40000 ALTER TABLE `aule` DISABLE KEYS */;
INSERT INTO `aule` VALUES (1,250,'Edificio Centrale','Aula Magna'),(2,100,'Blocco A','Aula 101'),(3,80,'Blocco A','Aula 102'),(4,45,'Blocco A','Aula 103'),(5,120,'Blocco B','Aula 201'),(6,95,'Blocco B','Aula 202'),(7,35,'Area Laboratori','Laboratorio Informatica 1'),(8,30,'Area Laboratori','Laboratorio Informatica 2'),(9,25,'Area Laboratori','Laboratorio Fisica'),(10,150,'Blocco C','Aula 301'),(11,65,'Blocco C','Aula 302'),(12,200,'Edificio Nord','Aula 401'),(13,55,'Edificio Nord','Aula 402'),(14,15,'Edificio Centrale','Sala Riunioni A'),(15,300,'Edificio Nord','Auditorium Nord');
/*!40000 ALTER TABLE `aule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `docenti`
--

DROP TABLE IF EXISTS `docenti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `docenti` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `cognome` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKpabq2hxsn2ga5rwb1j2xpuh6m` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `docenti`
--

LOCK TABLES `docenti` WRITE;
/*!40000 ALTER TABLE `docenti` DISABLE KEYS */;
INSERT INTO `docenti` VALUES (1,'Rossi','mario.rossi@universita.it','Mario','Rossi2024!'),(2,'Bianchi','laura.bianchi@universita.it','Laura','BianchiPass99'),(3,'Verdi','giuseppe.verdi@universita.it','Giuseppe','VerdiSinfonia'),(4,'Neri','anna.neri@universita.it','Anna','NeriTop123'),(5,'Moretti','marco.moretti@universita.it','Marco','MorettiFast'),(6,'Fontana','elena.fontana@universita.it','Elena','FontanaAcqua'),(7,'Gallo','roberto.gallo@universita.it','Roberto','GalloChicco'),(8,'Esposito','sofia.esposito@universita.it','Sofia','EspositoNapoli'),(9,'Romano','antonio.romano@universita.it','Antonio','RomanoImperium'),(10,'Colombo','chiara.colombo@universita.it','Chiara','ColomboDiscovery');
/*!40000 ALTER TABLE `docenti` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prenotazioni`
--

DROP TABLE IF EXISTS `prenotazioni`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prenotazioni` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `data` date DEFAULT NULL,
  `ora` int NOT NULL,
  `aula_id` bigint NOT NULL,
  `docente_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKp5jfrl2kmompoh6002qea09bd` (`aula_id`),
  KEY `FKdfhlrnurpy5drwv5aw7r2a9yy` (`docente_id`),
  CONSTRAINT `FKdfhlrnurpy5drwv5aw7r2a9yy` FOREIGN KEY (`docente_id`) REFERENCES `docenti` (`id`),
  CONSTRAINT `FKp5jfrl2kmompoh6002qea09bd` FOREIGN KEY (`aula_id`) REFERENCES `aule` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prenotazioni`
--

LOCK TABLES `prenotazioni` WRITE;
/*!40000 ALTER TABLE `prenotazioni` DISABLE KEYS */;
INSERT INTO `prenotazioni` VALUES (1,'2026-05-09',8,12,5),(2,'2026-05-09',9,12,5),(3,'2026-05-08',14,10,4),(7,'2026-05-03',12,1,1);
/*!40000 ALTER TABLE `prenotazioni` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prenotazioni_studenti`
--

DROP TABLE IF EXISTS `prenotazioni_studenti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prenotazioni_studenti` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `prenotazione_id` bigint NOT NULL,
  `studente_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKswbsuyj3ynamrrlbus72f0y62` (`prenotazione_id`),
  KEY `FK6umo7s167knmgfmarqew2rrhe` (`studente_id`),
  CONSTRAINT `FK6umo7s167knmgfmarqew2rrhe` FOREIGN KEY (`studente_id`) REFERENCES `studenti` (`id`),
  CONSTRAINT `FKswbsuyj3ynamrrlbus72f0y62` FOREIGN KEY (`prenotazione_id`) REFERENCES `prenotazioni` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prenotazioni_studenti`
--

LOCK TABLES `prenotazioni_studenti` WRITE;
/*!40000 ALTER TABLE `prenotazioni_studenti` DISABLE KEYS */;
INSERT INTO `prenotazioni_studenti` VALUES (10,1,1),(11,2,1),(12,3,1),(14,7,6),(15,2,6);
/*!40000 ALTER TABLE `prenotazioni_studenti` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `studenti`
--

DROP TABLE IF EXISTS `studenti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `studenti` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `cognome` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK8gs14ypv5estf6biayppbejap` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `studenti`
--

LOCK TABLES `studenti` WRITE;
/*!40000 ALTER TABLE `studenti` DISABLE KEYS */;
INSERT INTO `studenti` VALUES (1,'Neri','luca.neri@studenti.it','Luca','NeriPass!26'),(2,'Gialli','martina.gialli@studenti.it','Martina','GialliMarty99'),(3,'Russo','alessandro.russo@studenti.it','Alessandro','RussoAlex_20'),(4,'Ferrari','beatrice.ferrari@studenti.it','Beatrice','BeaFerrari#1'),(5,'Esposito','carlo.esposito@studenti.it','Carlo','EspositoC@rlo'),(6,'Bianchi','diana.bianchi@studenti.it','Diana','DianaB_2026'),(7,'Romano','edoardo.romano@studenti.it','Edoardo','EdoRomano!'),(8,'Colombo','francesca.colombo@studenti.it','Francesca','FraColombo98'),(9,'Ricci','gabriele.ricci@studenti.it','Gabriele','GabriRicci77'),(10,'Marino','ilaria.marino@studenti.it','Ilaria','IlaMarino_00');
/*!40000 ALTER TABLE `studenti` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-05-04 10:42:42
