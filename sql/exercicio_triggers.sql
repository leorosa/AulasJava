CREATE DATABASE exercicio3;
USE exercicio3;

CREATE TABLE clientes (
	id INT AUTO_INCREMENT PRIMARY KEY,
	nome VARCHAR(100),
	email VARCHAR(100)
);

CREATE TABLE log_clientes (
	id INT AUTO_INCREMENT PRIMARY KEY,
	mensagem VARCHAR(255),
	data_evento DATETIME
);

DELIMITER $$ 
CREATE TRIGGER trg_cliente_insert
AFTER INSERT ON clientes
FOR EACH ROW
BEGIN
    INSERT INTO log_clientes(
        mensagem,
        data_evento
    )
    VALUES(
        CONCAT('Cliente cadastrado: ', NEW.nome),
        NOW()
    ); 
END $$
DELIMITER ;

INSERT INTO clientes (nome,email)
	VALUES ('João','joao@email.com');

SELECT * FROM log_clientes;

##### ##### #####

CREATE TABLE produtos (
	id INT AUTO_INCREMENT PRIMARY KEY,
	nome VARCHAR(100),
	preco DECIMAL(10,2)
);

CREATE TABLE historico_preco (
	id INT AUTO_INCREMENT PRIMARY KEY,
	produto_id INT,
	preco_antigo DECIMAL(10,2),
	preco_novo DECIMAL(10,2),
	data_alteracao DATETIME
);

DELIMITER $$
CREATE TRIGGER trg_produto_update
AFTER UPDATE ON produtos
FOR EACH ROW
BEGIN
	INSERT INTO historico_preco (
		produto_id,
		preco_antigo,
		preco_novo,
		data_alteracao
	)
	VALUES (
		OLD.id,
		OLD.preco,
		NEW.preco,
		NOW()
	);
END $$
DELIMITER ;

UPDATE produtos
	SET preco = 120.00
		WHERE id = 1;

##### ##### #####

DROP TABLE produtos;
CREATE TABLE produtos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100),
    estoque INT
);

CREATE TABLE pedidos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    produto_id INT,
    quantidade INT
);

DELIMITER $$
CREATE TRIGGER trg_baixa_estoque
AFTER INSERT ON pedidos
FOR EACH ROW
BEGIN
	UPDATE produtos
		SET estoque = estoque - NEW.quantidade
		WHERE id = NEW.produto_id;
END $$
DELIMITER ;

INSERT INTO produtos (nome,estoque)
	VALUES ('Notebook',10);

INSERT INTO pedidos (produto_id,quantidade)
	VALUES (1,2);

##### ##### #####

CREATE TABLE funcionarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100),
    salario DECIMAL(10,2)
);

DELIMITER $$
CREATE TRIGGER trg_valida_salario
BEFORE INSERT ON funcionarios
FOR EACH ROW
BEGIN
    IF NEW.salario < 1500 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Salário abaixo do permitido';
    END IF;
END $$
DELIMITER ;

INSERT INTO funcionarios (nome,salario)
VALUES (
	'Maria',
	1200
);
