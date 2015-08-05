show databases;
create database tutorial;
use tutorial;
show tables;
drop table new_table;

CREATE TABLE `tutorial`.`cliente` (
  `id` INT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `fone` VARCHAR(45) NULL,
  PRIMARY KEY (`id`)
)ENGINE = InnoDB;

describe cliente;


create table `tutorial`.`pedido` (
  `id` INT NOT NULL,
  `data` date NOT NULL,
  `valor` numeric(10, 2) NOT NULL,
  `id_cliente` INT NOT NULL,
  PRIMARY KEY (`id`)
)ENGINE = InnoDB;

alter table pedido add foreign key (id_cliente)
references cliente(id)
on delete restrict
on update restrict;

describe pedido;

insert into cliente values(101, 'ze das couves', 1127991999);
insert into cliente values
	(102, 'Maria das couves', NULL),
	(103, 'Antonio das couves', 1127199990),
	(104, 'Ana das couves', 1122334455);

select * from cliente;
select * from cliente order by nome;
select * from cliente order by nome desc;
select * from cliente order by 3;
select id, nome from cliente where fone is null;
select id, nome from cliente where fone is not null;
select * from cliente where nome like '%couves';
select * from cliente where nome like 'A%';
select * from cliente where nome like '%a%';

update cliente set fone = '50116658' where id = 102;
delete from cliente where id = 104;

drop table pedido;

insert into pedido values(1001, '2010-06-15', 300.00, 102);
insert into pedido values(1002, '2010-06-15', 1250.00, 104);
insert into pedido values(1000, '2010-06-15', 120.00, 104);
insert into pedido values(999, '2010-06-15', 150.00, 104);

insert into pedido values
	(1003, '2010-06-15', 200.00, 102),
	(1004, '2010-06-16', 230.00, 101),
	(1005, '2010-06-17', 430.00, 101),
	(1006, '2010-06-18', 90.00, 103),
	(1007, '2010-06-19', 720.00, 104);



select * from pedido;
select count(*) as total from pedido;
select max(valor) as maior, avg(valor) as media, min(valor) as menor from pedido;
select * from pedido where data > '2010-06-15'; 

select * from cliente, pedido where cliente.id = pedido.id_cliente;
select c.id, p.id from cliente c, pedido p where c.id = p.id_cliente;
select c.nome, p.data, p.valor from cliente c 
	inner join pedido p on c.id = p.id_cliente where p.valor in (select valor from pedido where valor > 500);
    
select c.nome, p.data, p.valor from cliente c 
	inner join pedido p on c.id = p.id_cliente where exists (select valor from pedido where valor > 50000);

select id_cliente, sum(valor) from pedido group by id_cliente;




 


