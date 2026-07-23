<%
	String nome = request.getParameter("nome");
	out.print("<p>"+nome+"</p>");
	String email = request.getParameter("email");
	out.print("<p>"+email+"</p>");
%>