SHOW GRANTS;

CREATE DATABASE loja;
USE loja;

CREATE USER 'vendedor'@'localhost' IDENTIFIED BY '123';
GRANT SELECT, INSERT, UPDATE ON loja.* TO 'vendedor'@'localhost';

SHOW GRANTS FOR 'vendedor'@'localhost';

REVOKE UPDATE ON loja.* FROM 'vendedor'@'localhost';
