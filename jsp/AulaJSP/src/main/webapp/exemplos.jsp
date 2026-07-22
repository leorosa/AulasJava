<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*, java.text.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%=new Date()%>
	<%
		int ddia = Integer.parseInt((new SimpleDateFormat("dd")).format(new Date()));
		out.println("<br>Hoje é dia " + ddia);
	%>
	<hr />
	<%
		out.println("<h1>Hello World!</h1>");
		int xdia = Integer.parseInt((new SimpleDateFormat("dd")).format(new Date()));
		int xmes = Integer.parseInt((new SimpleDateFormat("M")).format(new Date()));
		int xano = Integer.parseInt((new SimpleDateFormat("yyyy")).format(new Date()));
		switch(xmes){
			case 1:
				out.println("Hoje é " + xdia + " de Janeiro de " + xano);
				break;
			case 2:
				out.println("Hoje é " + xdia + " de Fevereiro de " + xano);
				break;
			case 3:
				out.println("Hoje é " + xdia + " de Março de " + xano);
				break;
			default:
				out.println("Ola");
		}
	%>
	<hr />
		<%@include file="topo.jsp"%>
		<form action="trataform.jsp" method="post">
			Nome:<input type="text" name="txtnome"/><br>
			E-Mail:<input type="text" name="txtemail"/><br>
			Data de Nascimento:<input type="text" name="txtdtnasc"/><br>
			<input type="submit" value="Enviar"/>

		</form>
		<hr />
		<%@include file="rodape.jsp"%>
</body>
</html>