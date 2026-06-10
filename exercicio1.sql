create database exercicio1;
use exercicio1;
set sql_safe_updates = 0;

create table produtos (
	id_produto int primary key auto_increment,
    nome varchar(100),
    preco decimal(10,2),
    estoque int
);

create table pedidos(
	id_pedido int primary key auto_increment,
    data_pedido date,
    nome_cliente varchar(100)
);

create table item_pedido(
	id_item int primary key auto_increment,
    id_pedido int,
		constraint fk_pedido foreign key (id_pedido)
		references pedidos(id_pedido),
    id_produto int,
		constraint fk_produto foreign key (id_produto)
		references produtos(id_produto),
    quantidade int,
    valor_unitario decimal(10,2)
);

insert into produtos (nome,preco,estoque) values ('arroz',25.00,15);
insert into produtos (nome,preco,estoque) values ('feijão',8.50,8);
insert into produtos (nome,preco,estoque) values ('macarrão',6.00,25);
insert into produtos (nome,preco,estoque) values ('refrigerante',9.90,32);
insert into produtos (nome,preco,estoque) values ('chocolate',4.50,10);

insert into pedidos (data_pedido,nome_cliente) values ('2026/06/10', 'João');

insert into item_pedido (id_pedido,id_produto,quantidade) values (1, 3, 1);
insert into item_pedido (id_pedido,id_produto,quantidade) values (1, 4, 3);
insert into item_pedido (id_pedido,id_produto,quantidade) values (1, 5, 2);

select * from produtos;
select * from produtos where estoque>10;
select * from produtos order by preco;

select * from pedidos where id_pedido=1;

select id_pedido,nome from item_pedido, produtos
	where id_pedido=1 and item_pedido.id_produto=produtos.id_produto;

update produtos set preco = 26 where nome = 'arroz';
update produtos set preco = 26 where id_produto = 1;
update produtos set estoque = 24 where id_produto = 3;
update produtos set nome = 'suco' where id_produto = 4;

update pedidos set nome_cliente = 'Maria' where id_pedido = 1;

select id_pedido, nome_cliente, data_pedido from pedidos where id_pedido=1;

select pedidos.id_pedido,nome_cliente,data_pedido , nome,quantidade,preco , quantidade*preco from pedidos, item_pedido, produtos
	where pedidos.id_pedido=1 and item_pedido.id_produto=produtos.id_produto;

select sum(quantidade*preco) from item_pedido, produtos
	where id_pedido=1 and item_pedido.id_produto=produtos.id_produto;
