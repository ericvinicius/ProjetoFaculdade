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

	if v1 != 2 then
		INSERT INTO Movimentacao (valor, data, idCliente, idClienteDestino) VALUES (
			12.30, '2015-08-01 12:43:22', v1, 2
		);
	
		INSERT INTO Movimentacao (valor, data, idCliente, idClienteDestino) VALUES (
			123.50, '2015-08-01 01:17:30', 2, v1
		);
    end if;

	INSERT INTO Movimentacao (valor, data, idCliente, idClienteDestino) VALUES (
		150.00, '2015-08-02 10:00:59', v1, v1
	);	
    
    INSERT INTO Movimentacao (valor, data, idCliente, idClienteDestino) VALUES (
		10.00, '2015-08-03 17:50:59', v1, v1
	);	
    
    SET v1 = v1 + 1;
  END WHILE;
END; //
delimiter ;

call dowhile();

INSERT INTO Cliente (nome, saldo) VALUES ('Sr. Saldo Negativo', -1704.20);

select * from Cliente;
select * from Movimentacao;

