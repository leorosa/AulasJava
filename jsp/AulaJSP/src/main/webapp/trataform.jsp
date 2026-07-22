<%@page contentType="text/html" import="java.util.*,
java.text.*, java.lang.String" pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>JSP Page</title>
	</head>
	<body>
		<%@include file="topo.jsp"%>
		Dados do formulario<br>
		<%
		String nome = request.getParameter("txtnome");
		if(nome=="")
			out.println("Nome não foi digitato");
		else
			out.println("Seu nome é " + nome);
		%>

		<br>E-Mail: <%=request.getParameter("txtemail")%><br>
		Data de Nascimento: <%=request.getParameter("txtdtnasc")%><br>
		<%@include file="rodape.jsp"%>
	</body>
</html>