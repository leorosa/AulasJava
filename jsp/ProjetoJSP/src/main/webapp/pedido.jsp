<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pedido</title>
</head>
<body>
	<h1>Cadastro Pedido</h1>
	<form action='processaPedido.jsp' method='post'>
		<label>Data</label>
		<input type='text' placeholder='ex. 2026-07-23' name='data'/>
		<br>
		<label>Cliente</label>
		<input type='text' placeholder='ex. José' name='cliente'/>
		<br>
		<button>Gravar</button>
	</form>

</body>
</html>