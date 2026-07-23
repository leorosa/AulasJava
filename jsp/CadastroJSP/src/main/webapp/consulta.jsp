<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<%@page import="dao.ContatoDao" %>
<%@page import="modelos.Contato" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	ContatoDao dao = new ContatoDao();
	List<Contato> contatos = dao.consultar();
%>
	<table>
		<thead>
			<tr>
				<th>Id</th>
				<th>Nome</th>
				<th>Email</th>
				<th>Ações</th>
			</tr>
		</thead>
		<tbody>
		<%
			for(Contato c : contatos){
				out.print("<tr>");
				out.print("<td>"+ c.getId() +"</td>");
				out.print("<td>"+ c.getNome() +"</td>");
				out.print("<td>"+ c.getEmail() +"</td>");
				out.print("<td><a href='excluir.jsp?id="+c.getId()+"'>excluir</a></td>");
				out.print("<td><button>Editar</button></td>");
				out.print("</tr>");
			}
		%>
		</tbody>
	</table>
<%
	out.print("<hr />");
	out.print("<a href='index.jsp'>home</a> ");
	out.print("<a href='cadastro.jsp'>novo</a>");
%>
</body>
</html>