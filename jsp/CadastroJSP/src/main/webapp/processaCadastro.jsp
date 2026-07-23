<%@page import="dao.ContatoDao"%>
<%@page import="modelos.Contato"%>
<%@page import="java.util.List"%>
<%
String nome = request.getParameter("nome");
//	out.print("<p>"+nome+"</p>");
	String email = request.getParameter("email");
//	out.print("<p>"+email+"</p>");

	Contato ct = new Contato();
	ct.setNome(nome);
	ct.setEmail(email);
//	out.print("<p>" + ct.getEmail() + "</p>");

	ContatoDao dao = new ContatoDao();
	dao.salvar(ct);

	response.sendRedirect("consulta.jsp");//página com dados em tabela
%>