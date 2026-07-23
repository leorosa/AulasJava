<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Cadastro</h1>
	<form action='processaCadastro.jsp' method='post'>
		<label>informe nome</label>
		<input type='text' placeholder='ex. josé' name='nome'/>

		<label>informe email</label>
		<input type='text' placeholder='ex. jose@gmail.com' name='email'/>

		<button>Gravar</button>
	</form>
</body>
</html>