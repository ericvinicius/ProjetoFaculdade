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

    INSERT INTO Movimentacao (valor, data, novoSaldo, tipo, agenciaDestino, contaDestino, idCliente) VALUES (
		12.30, '2015-08-03 12:43:22', 500.00, 'transferencia', '2345-6', '23.456-7', v1
	);

	INSERT INTO Movimentacao (valor, data, novoSaldo, tipo, agenciaDestino, contaDestino, idCliente) VALUES (
		123.50, '2015-08-02 01:17:30', 377.00, 'transferencia', '3456-7', '34.567-8', v1
	);

	INSERT INTO Movimentacao (valor, data, novoSaldo, tipo, idCliente) VALUES (
		150.00, '2015-08-01 10:00:59', 226.00, 'saque', v1
	);	
    
    INSERT INTO Movimentacao (valor, data, novoSaldo, tipo, idCliente) VALUES (
		10.00, '2015-08-01 17:50:59', 6.00, 'saque', v1
	);	
    
    SET v1 = v1 + 1;
  END WHILE;
END; //
delimiter ;

call dowhile();

select * from Cliente;
select * from Movimentacao;

