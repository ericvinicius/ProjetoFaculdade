#Fit Data
SET FOREIGN_KEY_CHECKS = 0; 
truncate Movimentacao;
TRUNCATE Cliente; 
SET FOREIGN_KEY_CHECKS = 1;

INSERT INTO Cliente (nome, saldo) VALUES ('Mister Satan', 1704.20);
INSERT INTO Cliente (nome, saldo) VALUES ('Carlinhos', 1704.20);
INSERT INTO Cliente (nome, saldo) VALUES ('Joao Carlos', 1704.20);
INSERT INTO Cliente (nome, saldo) VALUES ('Cara Fudido', 1704.20);
INSERT INTO Cliente (nome, saldo) VALUES ('luck man', 1704.20);

DROP PROCEDURE IF EXISTS dowhile;
delimiter //
CREATE PROCEDURE dowhile()
BEGIN
	DECLARE v1 INT DEFAULT 1;
	WHILE v1 < 6 DO

    INSERT INTO Movimentacao (valor, data, novoSaldo, tipo, agenciaDestino, contaDestino, idCliente) VALUES (
		12.30, '2015-08-01 12:43:22', 1987.70, 'transferencia', '2345-6', '23.456-7', v1
	);

	INSERT INTO Movimentacao (valor, data, novoSaldo, tipo, agenciaDestino, contaDestino, idCliente) VALUES (
		123.50, '2015-08-01 01:17:30', 1864.20, 'transferencia', '3456-7', '34.567-8', v1
	);

	INSERT INTO Movimentacao (valor, data, novoSaldo, tipo, idCliente) VALUES (
		150.00, '2015-08-02 10:00:59', 1714.20, 'saque', v1
	);	
    
    INSERT INTO Movimentacao (valor, data, novoSaldo, tipo, idCliente) VALUES (
		10.00, '2015-08-03 17:50:59', 1704.20, 'saque', v1
	);	
    
    SET v1 = v1 + 1;
  END WHILE;
END; //
delimiter ;

call dowhile();

INSERT INTO Cliente (nome, saldo) VALUES ('Sr. Saldo Negativo', -1704.20);

select * from Cliente;
select * from Movimentacao;

