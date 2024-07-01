-- MySQL dump 10.13  Distrib 5.6.23, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: mercado88
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.32-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
drop database mercado88;
create database mercado88;
use mercado88;
--
-- Table structure for table `carrinho`
--

DROP TABLE IF EXISTS `carrinho`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `carrinho` (
  `idCarrinho` int(11) NOT NULL AUTO_INCREMENT,
  `usuario` int(11) DEFAULT NULL,
  PRIMARY KEY (`idCarrinho`),
  KEY `usuario` (`usuario`),
  CONSTRAINT `carrinho_ibfk_1` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`idUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carrinho`
--

LOCK TABLES `carrinho` WRITE;
/*!40000 ALTER TABLE `carrinho` DISABLE KEYS */;
INSERT INTO `carrinho` VALUES (1,1),(2,2),(4,4);
/*!40000 ALTER TABLE `carrinho` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `carrinhoproduto`
--

DROP TABLE IF EXISTS `carrinhoproduto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `carrinhoproduto` (
  `idCarrinhoProduto` int(11) NOT NULL AUTO_INCREMENT,
  `carrinho` int(11) NOT NULL,
  `produto` int(11) NOT NULL,
  `quantidade` int(11) NOT NULL,
  PRIMARY KEY (`idCarrinhoProduto`),
  KEY `carrinho` (`carrinho`),
  KEY `produto` (`produto`),
  CONSTRAINT `carrinhoproduto_ibfk_1` FOREIGN KEY (`carrinho`) REFERENCES `carrinho` (`idCarrinho`),
  CONSTRAINT `carrinhoproduto_ibfk_2` FOREIGN KEY (`produto`) REFERENCES `produto` (`idProduto`)
) ENGINE=InnoDB AUTO_INCREMENT=77 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carrinhoproduto`
--

LOCK TABLES `carrinhoproduto` WRITE;
/*!40000 ALTER TABLE `carrinhoproduto` DISABLE KEYS */;
/*!40000 ALTER TABLE `carrinhoproduto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categoria` (
  `idCategoria` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  PRIMARY KEY (`idCategoria`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` VALUES (1,'produtos de limpeza'),(2,'frutas/verduras'),(3,'bebidas'),(4,'iogurtes'),(5,'lamens'),(6,'sagadinhos'),(13,'churrasco'),(14,'pó'),(15,'grãos'),(16,'carnes');
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `endereco`
--

DROP TABLE IF EXISTS `endereco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `endereco` (
  `idEndereco` int(11) NOT NULL AUTO_INCREMENT,
  `estado` varchar(20) NOT NULL,
  `cidade` varchar(50) NOT NULL,
  `cep` char(9) DEFAULT NULL,
  `bairro` varchar(30) DEFAULT NULL,
  `rua` varchar(100) NOT NULL,
  `numero` varchar(10) NOT NULL,
  PRIMARY KEY (`idEndereco`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `endereco`
--

LOCK TABLES `endereco` WRITE;
/*!40000 ALTER TABLE `endereco` DISABLE KEYS */;
INSERT INTO `endereco` VALUES (1,'PR','Londrina','86031280','Lindóia','Rua Roncador','1'),(2,'PR','Londrina','86031280','Lindóia','Rua Roncador','555'),(3,'PR','Londrina','86031280','Lindóia','Rua Roncador','555'),(4,'PR','Londrina','86031280','Lindóia','Rua Roncador','1'),(5,'PR','Londrina','86031280','Lindóia','Rua Roncador','555'),(6,'PR','Londrina','86062480','Amaro','Rua Lindóia','44'),(7,'PR','Londrina','86031280','LindÃ³ia','Rua Roncador','66'),(8,'PR','Londrina','86031280','LindÃ³ia','Rua Roncador','11'),(9,'PR','Londrina','86031280','LindÃ³ia','Rua Roncador','55'),(10,'PR','Londrina','86031280','LindÃ³ia','Rua Roncador','555'),(11,'PR','Londrina','86031280','LindÃ³ia','Rua Roncador','55'),(12,'PR','Londrina','86031280','LindÃ³ia','Rua Roncador','66'),(13,'PR','Londrina','86031280','LindÃ³ia','Rua Roncador','66'),(14,'PR','Londrina','86031280','LindÃ³ia','Rua Roncador','66'),(15,'PR','Londrina','86031280','LindÃ³ia','Rua Roncador','11'),(16,'PR','Londrina','86031280','LindÃ³ia','Rua Roncador','66');
/*!40000 ALTER TABLE `endereco` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedido`
--

DROP TABLE IF EXISTS `pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pedido` (
  `idPedido` int(11) NOT NULL AUTO_INCREMENT,
  `usuario` int(11) NOT NULL,
  `enderecoEntrega` int(11) NOT NULL,
  `dataPedido` date NOT NULL,
  `valorTotal` float DEFAULT NULL,
  `status` int(11) DEFAULT 1,
  PRIMARY KEY (`idPedido`),
  KEY `enderecoEntrega` (`enderecoEntrega`),
  KEY `usuario` (`usuario`),
  CONSTRAINT `pedido_ibfk_1` FOREIGN KEY (`enderecoEntrega`) REFERENCES `endereco` (`idEndereco`),
  CONSTRAINT `pedido_ibfk_2` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`idUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedido`
--

LOCK TABLES `pedido` WRITE;
/*!40000 ALTER TABLE `pedido` DISABLE KEYS */;
/*!40000 ALTER TABLE `pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produto`
--

DROP TABLE IF EXISTS `produto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `produto` (
  `idProduto` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `valor` float(10,2) NOT NULL,
  `desconto` float(10,2) DEFAULT 0.00,
  `quantidade` int(11) DEFAULT NULL,
  `validade` date DEFAULT NULL,
  `imagem` longblob DEFAULT NULL,
  `valorFinal` float GENERATED ALWAYS AS (`valor` - coalesce(`desconto`,0)) STORED,
  PRIMARY KEY (`idProduto`)
) ENGINE=InnoDB AUTO_INCREMENT=76 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produto`
--

LOCK TABLES `produto` WRITE;
/*!40000 ALTER TABLE `produto` DISABLE KEYS */;

/*!40000 ALTER TABLE `produto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produtocategoria`
--

DROP TABLE IF EXISTS `produtocategoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `produtocategoria` (
  `idProdutoCategoria` int(11) NOT NULL AUTO_INCREMENT,
  `produto` int(11) NOT NULL,
  `categoria` int(11) NOT NULL,
  PRIMARY KEY (`idProdutoCategoria`),
  KEY `produto` (`produto`),
  KEY `categoria` (`categoria`),
  CONSTRAINT `produtocategoria_ibfk_1` FOREIGN KEY (`produto`) REFERENCES `produto` (`idProduto`),
  CONSTRAINT `produtocategoria_ibfk_2` FOREIGN KEY (`categoria`) REFERENCES `categoria` (`idCategoria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produtocategoria`
--

LOCK TABLES `produtocategoria` WRITE;
/*!40000 ALTER TABLE `produtocategoria` DISABLE KEYS */;
/*!40000 ALTER TABLE `produtocategoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produtopedido`
--

DROP TABLE IF EXISTS `produtopedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `produtopedido` (
  `idProdutoPedido` int(11) NOT NULL AUTO_INCREMENT,
  `pedido` int(11) NOT NULL,
  `produto` int(11) NOT NULL,
  PRIMARY KEY (`idProdutoPedido`),
  KEY `pedido` (`pedido`),
  KEY `produto` (`produto`),
  CONSTRAINT `produtopedido_ibfk_1` FOREIGN KEY (`pedido`) REFERENCES `pedido` (`idPedido`),
  CONSTRAINT `produtopedido_ibfk_2` FOREIGN KEY (`produto`) REFERENCES `produto` (`idProduto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produtopedido`
--

LOCK TABLES `produtopedido` WRITE;
/*!40000 ALTER TABLE `produtopedido` DISABLE KEYS */;
/*!40000 ALTER TABLE `produtopedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `idUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `senha` varchar(100) NOT NULL,
  `cpf` char(14) DEFAULT '0',
  `telefone` varchar(15) NOT NULL,
  `data` date NOT NULL,
  `tipo` int(11) DEFAULT 2,
  PRIMARY KEY (`idUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (4,'kelvin','kelvinfaquetti1@gmail.com','92668751','31231313132','43984779051','2006-04-16',1);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ZERO_IN_DATE,NO_ZERO_DATE,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER criarCarrinho
AFTER INSERT ON usuario
FOR EACH ROW
BEGIN
    INSERT INTO carrinho (usuario) VALUES (NEW.idUsuario);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Dumping events for database 'mercado88'
--

--
-- Dumping routines for database 'mercado88'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-27  0:18:28
alter table produto drop column valorFinal;
alter table produto add column valorFinal float generated always as (valor - coalesce(desconto,0)) stored;