create table tb_produtos (
	id_produto int primary key auto increment,
	descricao varchar(200),
	preco decimal(10,2),
	estoque int
);
--	alter table tb_produtos add column estoque int;

create table tb_clientes (
	id int primary key auto_increment,
	cpf varchar(14),
	nome varchar(200),
	email varchar(200),
	rua varchar(200),
	numero int,
	bairro varchar(200),
	cep varchar(9),
	cidade varchar(200),
	estado varchar(2)
);

create table tb_produtos (
	id int primary key auto_increment,
	nome varchar(100),
	preco decimal(10,2),
	estoque int
);

create table tb_status (
	id int primary key auto_increment,
	descricao varchar(100)
);
--rename table status to tb_status;
--insert into tb_status (descricao) values ("aberto");
--insert into tb_status (descricao) values ("finalizado");
--insert into tb_status (descricao) values ("cancelado");

create table lista_pedido (
	id int primary key auto_increment,
	id_pedido int,
		constraint fk_pedido foreign key (id_pedido)
		references tb_pedidos(id),
	id_produto int,
		constraint fk_produto foreign key (id_produto)
		references tb_produtos(id),
	quantidade int
);

--rename table lista_items to lista_pedido
--alter table lista_pedido drop foreign key fk_pedido;
--alter table lista_pedido add constraint fk_pedido foreign key (id_pedido) references tb_pedidos(id);
--alter table lista_pedido drop foreign key fk_produto;
--alter table lista_pedido add constraint fk_produto foreign key (id_produto) references tb_produtos(id);

create table tb_pedidos (
	id int primary key auto_increment,
	data date,
	id_status int,
		constraint fk_status foreign key (id_status)
		references tb_status(id),
	id_cliente int,
		constraint fk_cliente foreign key (id_cliente)
		references tb_clientes(id)
);
--alter table tb_pedidos drop foreign key fk_cliente;
--alter table tb_pedidos add constraint fk_cliente foreign key (cliente) references tb_clientes(id);
--alter table tb_pedidos modify column status int;
--alter table tb_pedidos add constraint fk_status foreign key (status) references tb_status(id);

--	lista int,
--		constraint fk_lista foreign key (lista)
--		references tb_lista_items(id)
--alter table tb_pedidos add column lista int;
--alter table tb_pedidos add constraint fk_lista foreign key (lista) references lista_items(id);
