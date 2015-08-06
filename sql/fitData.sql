#Fit Data

truncate Movimentacao;

SET FOREIGN_KEY_CHECKS = 0; 
TRUNCATE Cliente; 
SET FOREIGN_KEY_CHECKS = 1;

INSERT INTO Cliente (nome, saldo) VALUES ('Mister Satan', 1234.00);
INSERT INTO Cliente (nome, saldo) VALUES ('Carlinhos', -12.98);
INSERT INTO Cliente (nome, saldo) VALUES ('Joao Carlos', 732.15);
INSERT INTO Cliente (nome, saldo) VALUES ('Cara Fudido', -192374.99);
INSERT INTO Cliente (nome, saldo) VALUES ('luck man', 324.00);

DROP PROCEDURE IF EXISTS dowhile;
delimiter //
CREATE PROCEDURE dowhile()
BEGIN
	DECLARE v1 INT DEFAULT 1;
	WHILE v1 < 6 DO
    
    INSERT INTO Movimentacao (valor, data, contaDestino, agenciaDestino, idCliente, tipo, novoSaldo) VALUES (
		12.00, '2015-08-03 12:43:22', '23.456-7', '2345-6', v1, 'transferencia', 500.00
	);

	INSERT INTO Movimentacao (valor, data, contaDestino, agenciaDestino, idCliente, tipo,  novoSaldo) VALUES (
		123.00, '2015-08-02 01:17:30', '34.567-8', '3456-7', v1, 'transferencia', 377.00
	);

	INSERT INTO Movimentacao (valor, data, idCliente, tipo, novoSaldo) VALUES (
		150.50, '2015-08-01 10:00:59', v1, 'saque', 226.50
	);

	INSERT INTO Movimentacao (valor, data, idCliente, tipo, novoSaldo) VALUES (
		1000.00, '2015-05-31 19:13:12', v1, 'deposito',  1226.50
	);	
    
    SET v1 = v1 + 1;
  END WHILE;
END; //
delimiter ;

call dowhile();

select * from Cliente;
select * from Movimentacao;

