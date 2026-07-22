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
        int dia = Integer.parseInt((new SimpleDateFormat("dd")).format(new Date()));
        out.println("<br>Hoje é dia " + dia);
    %>
</body>
</html>