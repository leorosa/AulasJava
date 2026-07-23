<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cliente</title>
</head>
<body>
	<h1>Cadastro de Cliente</h1>
	<form action='processaCliente.jsp' method='post'>
		<label>CPF</label>
		<input type='text' placeholder='ex. 000.000.000-00' name='cpf'/>
		<br>
		<label>Nome</label>
		<input type='text' placeholder='ex. José' name='nome'/>
		<br>
		<label>Email</label>
		<input type='text' placeholder='ex. jose@gmail.com' name='email'/>
		<br>
		<label>Rua</label>
		<input type='text' placeholder='ex. jose@gmail.com' name='email'/>
		<br>
		<label>Número</label>
		<input type='text' placeholder='ex. 123' name='numero'/>
		<br>
		<label>Bairro</label>
		<input type='text' placeholder='ex. Centro' name='bairro'/>
		<br>
		<label>CEP</label>
		<input type='text' placeholder='ex. 00000-000' name='cep'/>
		<br>
		<label>Cidade</label>
		<input type='text' placeholder='ex. Blumenau' name='cidade'/>
		<br>
		<label>Estado</label>
		<input type='text' placeholder='ex. SC' name='estado'/>
		<br>
		<button>Gravar</button>
	</form>

</body>
</html>