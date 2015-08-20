#Outros

#Exemplo de select com where
select * from Cliente where idCliente = 2;

select * from Cliente;

select * from Movimentacao;
select * from Movimentacao where idCliente = 2 OR idClienteDestino = 2;

select * from Movimentacao m join Cliente c on c.idCliente = m.idCliente where m.idCliente = 2 OR m.idClienteDestino = 2;

select * from Cliente c join Movimentacao m on c.idCliente = m.idCliente where m.idCliente = 1 or m.idClienteDestino = 1;
select c.*, "-" , m.* from Cliente c join Movimentacao m on c.id = m.idCliente where m.idCliente = 2 or m.idClienteDestino = 2 order by m.data ASC;
select c.*, "-" , m.* from Cliente c join Movimentacao m on c.id = m.idCliente where m.idCliente = 1 or m.idClienteDestino = 1 order by m.data ASC;
