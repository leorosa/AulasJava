<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- https://www.devmedia.com.br/introducao-ao-java-server-pages-jsp/25602 -->
<!-- usar servidor Apache Tomcat 10.1 -->
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Ola</h1>
	<%
		String nome = "Fulano";
		out.print("seu nome é " + nome);
	%>
	<%
		int idade = 50;
	%>
	<p>
	<%
		if (idade>18) {
			out.print(nome + " é maior de idade");
		}
	%>
	</p>
	<hr />
	<a href="cadastro.jsp">cadastro</a>
	<a href="exemplos.jsp">exemplos</a>
	<a href="trataform.jsp">trataform</a>
</body>
</html>