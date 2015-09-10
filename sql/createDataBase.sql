#Create database
CREATE DATABASE `projetoIntegrado` /*!40100 DEFAULT CHARACTER SET latin1 */;

use projetoIntegrado;

CREATE TABLE `Cliente` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) DEFAULT NULL,
  `saldo` decimal(18,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;


CREATE TABLE `Movimentacao` (
  `idMovimentacao` int(11) NOT NULL AUTO_INCREMENT,
  `valor` decimal(18,2) NOT NULL,
  `data` datetime NOT NULL,
  `idCliente` int(11) NOT NULL,
  `idClienteDestino` int(11) NOT NULL,
  PRIMARY KEY (`idMovimentacao`),
  KEY `idCliente_idx` (`idCliente`),
  CONSTRAINT `idCliente` FOREIGN KEY (`idCliente`) REFERENCES `Cliente` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;










