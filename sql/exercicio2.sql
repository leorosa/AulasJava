CREATE DATABASE exercicio2;
USE exercicio2;

CREATE TABLE produto (
	id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100),
    preco DECIMAL(10,2)
);

DELIMITER $$
CREATE PROCEDURE listarProdutos()
BEGIN
	SELECT * FROM produto;
END $$
DELIMITER ;

CALL listarProdutos;

DELIMITER $$
CREATE PROCEDURE cadastrarProduto (
	IN p_nome VARCHAR(100),
    IN p_preco DECIMAL(10,2)
)
BEGIN
	INSERT INTO produto (nome, preco)
    VALUES (p_nome, p_preco);
END $$
DELIMITER ;

CALL cadastrarProduto('Notebook', 3500.00);

DELIMITER $$
CREATE PROCEDURE totalProdutos (OUT quantidade INT)
BEGIN
	SELECT COUNT(*) INTO quantidade
    FROM produto;
END $$
DELIMITER ;

CALL totalProdutos(@total);
SELECT @total;		-- @ similar a ponteiros em C

DELIMITER $$
CREATE PROCEDURE verificarPreco( IN p_preco DECIMAL(10,2) )
BEGIN
	IF p_preco >= 1000 THEN
		SELECT 'Produto caro';
	ELSE
		SELECT 'Produto barato';
	END IF;
END $$
DELIMITER ;

CALL verificarPreco(2500);

DELIMITER $$
CREATE PROCEDURE contar()
BEGIN
	DECLARE i INT DEFAULT 1;
    WHILE i <= 5 DO
		SELECT i;
        SET i = i + 1;
	END WHILE;
END $$
DELIMITER ;

CALL contar();

##### ##### #####

CREATE TABLE estoque (
	id INT PRIMARY KEY AUTO_INCREMENT,
    produto VARCHAR(100),
    quantidade INT
);

DELIMITER $$
CREATE PROCEDURE adicionarEstoque (
	IN p_produto VARCHAR(100),
    IN p_quantidade INT
)
BEGIN
	DECLARE qtAtual INT;
    SELECT quantidade
		FROM estoque
        WHERE produto = p_produto;
	IF qtAtual IS NULL THEN
		INSERT INTO estoque (produto, quantidade)
			VALUES (p_produto, p_quantidade);
	ELSE
		UPDATE estoque
			SET quantidade = quantidade + p_quantidade
            WHERE produto = p_produto;
	END IF;
END $$
DELIMITER ;

CALL adicionarEstoque('Mouse', 10);

SELECT * FROM estoque;

SHOW PROCEDURE STATUS;
SHOW CREATE PROCEDURE listarProdutos;
#DROP PROCEDURE nomeProcedure;
