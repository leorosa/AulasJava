drop database exemplo;
create database exemplo;
use exemplo;
set sql_safe_updates = 0;

create table tb_categorias (
	id int primary key auto_increment,
	nome varchar(25) not null
);
insert into tb_categorias(nome) value('frutas');
insert into tb_categorias(nome) value('cereais');
select * from tb_categorias;

create table tb_produtos (
	id int primary key auto_increment,
	descricao varchar(30),
	preco decimal(6,2)
);

insert into tb_produtos(descricao,preco) values ('milho', 4500.85);
insert into tb_produtos(descricao) values ('tomate');
update tb_produtos
	set preco = 1.50
	where descricao = 'tomate';
select * from tb_produtos;

alter table tb_produtos add column id_categoria int;
alter table tb_produtos add constraint fk_categoria
foreign key (id_categoria)
references tb_categorias(id);
insert into tb_produtos (descricao,preco,id_categoria) values ('maçã', 4.5, 1);
select * from tb_produtos;
select * from tb_categorias;

insert into tb_produtos(descricao, preco, id_categoria) values ('feijão', 7.48, 2);
insert into tb_produtos(descricao, preco, id_categoria) values ('arroz', 2.48, 2);
insert into tb_produtos(descricao, preco, id_categoria) values ('laranja', 1.48, 1);

update tb_produtos set id_categoria=2 where id=1;
update tb_produtos set id_categoria=1 where descricao='milho';
select tb_produtos.id, descricao as Descrição, preco as 'R$ unitário', nome
	from tb_produtos, tb_categorias
	where tb_produtos.id_categoria = tb_categorias.id;

select tb_produtos.id, descricao as Descrição, preco as 'R$ unitário', nome as 'Categoria'
	from tb_produtos
	inner join tb_categorias on tb_produtos.id_categoria = tb_categorias.id;
