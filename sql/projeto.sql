drop database projeto;
create database projeto;
use projeto;
create table dados (
	idDado char(25) primary key,
	nome char(25),
	telefone int,
	endereco char(25),
	cidade char(25),
	idVeiculo char(7)
);
create table veiculos (
	idVeiculo char(25) primary key,
	modelo char(25),
	cor char(7)
);
create table locais (
	idLocal char(25) primary key,
	nome char(25),
	telefone int,
	abertura int,
	fechamento int,
	latitude float,
	longitude float,
	idDado char(25),
	idServico int,
	idArea int,
	idFuncionario char(25)
);
create table funcionarios (
	idFuncionario char(25) primary key,
	idServico int,
	idDado char(25)
);
create table areas (
	idArea int primary key,
	idServico int
);
create table agenda (
	idAgenda int primary key,
	dia int,
	hora char,
	idServico int,
	idLocal char(25),
	idArea int,
	idFuncionario char(25),
	idDados char(25),
	idVeiculo char(7)
);
create table avaliacoes (
	idAgenda int primary key,
	notaMedia float,
	numAvaliacoes int,
	idServico int,
	idLocal char(25),
	idFuncionario char(25)
);
create table area (
	idArea int primary key,
	idServico int
);
create table servicos (
	idServico int primary key auto_increment,
	nome char(25),
	tempoExecucao int,
	valor float
);
alter table dados
	add constraint fkVeiculo
	foreign key (idVeiculo)
	references veiculos(idVeiculo);
alter table locais
	add constraint fkDados
	foreign key (idDado)
	references dados(idDado);
alter table locais
	add constraint fkServico
	foreign key (idServico)
	references servicos(idServico);
alter table locais
	add constraint fkArea
	foreign key (idArea)
	references areas(idArea);
alter table locais
	add constraint fkFuncionario
	foreign key (idFuncionario)
	references funcionarios(idFuncionario);
alter table funcionarios
	add constraint fkServico_
	foreign key (idServico)
	references servicos(idServico);
alter table funcionarios
	add constraint fkDado_
	foreign key (idDado)
	references dados(idDado);
alter table area
	add constraint fkServico__
	foreign key (idServico)
	references servicos(idServico);
alter table avaliacoes
	add constraint fkServico___
	foreign key (idServico)
	references servicos(idServico);
alter table avaliacoes
	add constraint fkLocal
	foreign key (idLocal)
	references locais(idLocal);
alter table avaliacoes
	add constraint fkFuncionario_
	foreign key (idFuncionario)
	references funcionarios(idFuncionario)