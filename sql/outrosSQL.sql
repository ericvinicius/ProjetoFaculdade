#Outros

#Exemplo de select com where
select * from Cliente where idCliente = 1;


#Exemplo de update
update Cliente set saldo = 89 where idCliente = 1;


select * from Cliente c join Movimentacao m on c.idCliente = m.idCliente where c.idCliente = 1
