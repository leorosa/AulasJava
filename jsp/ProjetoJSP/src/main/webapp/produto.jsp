<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Produto</title>
</head>
<body>
	<h1>Cadastro de Produto</h1>
	<form action='processaProduto.jsp' method='post'>
		<label>Descrição</label>
		<input type='text' placeholder='ex. banana' name='descricao'/>
		<br>
		<label>Preço</label>
		<input type='text' placeholder='ex. 9.99' name='preco'/>
		<br>
		<label>Estoque</label>
		<input type='text' placeholder='ex. 100' name='estoque'/>
		<br>
		<button>Gravar</button>
	</form>

</body>
</html>