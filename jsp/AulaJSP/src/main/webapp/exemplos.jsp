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
        int dia = Integer.parseInt((new SimpleDateFormat("dd")).format(new Date()));
        int mes = Integer.parseInt((new SimpleDateFormat("M")).format(new Date()));
        int ano = Integer.parseInt((new SimpleDateFormat("yyyy")).format(new Date()));
        switch(mes){
            case 1:
                out.println("Hoje é " + dia + " de Janeiro de " + ano);
                break;
            case 2:
                out.println("Hoje é " + dia + " de Fevereiro de " + ano);
                break;
            case 3:
                out.println("Hoje é " + dia + " de Março de " + ano);
                break;
            default:
                out.println("Ola");
                }
	%>
</body>
</html>