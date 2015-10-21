#Fit Data
SET FOREIGN_KEY_CHECKS = 0; 
truncate Movimentacao;
TRUNCATE Cliente; 
SET FOREIGN_KEY_CHECKS = 1;

INSERT INTO Cliente (nome) VALUES ('Mister Satan');
INSERT INTO Cliente (nome) VALUES ('Carlinhos');
INSERT INTO Cliente (nome) VALUES ('Joao Carlos');
INSERT INTO Cliente (nome) VALUES ('Cara Fudido');
INSERT INTO Cliente (nome) VALUES ('luck man');

insert into Conta (idCliente, conta, agencia, saldo) values (1, '12.345-6', '1234-5', 1704.20);
insert into Conta (idCliente, conta, agencia, saldo) values (2, '23.456-7', '2345-5', 1704.20);
insert into Conta (idCliente, conta, agencia, saldo) values (3, '34.567-8', '3456-7', 1704.20);
insert into Conta (idCliente, conta, agencia, saldo) values (4, '45.678-9', '4567-8', 1704.20);
insert into Conta (idCliente, conta, agencia, saldo) values (5, '11.111-1', '1111-1', 1704.20);
insert into Conta (idCliente, conta, agencia, saldo) values (6, '22.222-2', '2222-2', 1704.20);

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

select * from Cliente;
select * from Movimentacao;
select * from Conta;

