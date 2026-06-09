# clinica.sql

create database clinica;
use clinica;
create table pacientes (
	idPaciente int primary key,
	nome char(25),
	idade int,
	telefone int(11)
);
create table pagamentos (
	idPagamento int primary key,
	valor float,
	idConsulta int
);
create table medicos (
	idMedico int primary key,
	nome char(25),
	telefone int,
	crm int
);
create table consultas (
	idConsulta int primary key,
	data int,
	horario int,
	idPaciente int,
	idMedico int
);
alter table pagamentos
	add constraint fkConsulta
	foreign key (idConsulta)
	references consultas(idConsulta);
alter table consultas
	add constraint fkPaciente
	foreign key (idPaciente)
	references pacientes(idPaciente);
alter table consultas
	add constraint fkMedico
	foreign key (idMedico)
	references medicos(idMedico);
