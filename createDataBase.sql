#Create database
CREATE DATABASE `projetoIntegrado` /*!40100 DEFAULT CHARACTER SET latin1 */;

use projetoIntegrado;

CREATE TABLE `Cliente` (
  `idCliente` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) DEFAULT NULL,
  `saldo` decimal(20,0) DEFAULT NULL,
  PRIMARY KEY (`idCliente`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;


CREATE TABLE `Movimentacao` (
  `idMovimentacao` int(11) NOT NULL AUTO_INCREMENT,
  `valor` decimal(20,0) NOT NULL,
  `data` datetime NOT NULL,
  `contaDestino` varchar(45) DEFAULT NULL,
  `agenciaDestino` varchar(45) DEFAULT NULL,
  `tipo` varchar(45) NOT NULL,
  `idCliente` int(11) NOT NULL,
  PRIMARY KEY (`idMovimentacao`),
  KEY `idCliente_idx` (`idCliente`),
  CONSTRAINT `idCliente` FOREIGN KEY (`idCliente`) REFERENCES `Cliente` (`idCliente`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;


