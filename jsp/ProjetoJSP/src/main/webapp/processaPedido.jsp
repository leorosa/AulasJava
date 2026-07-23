<%@page import="dao.PedidoDao"%>
<%@page import="modelos.Pedido"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="java.sql.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%
	String dataStr = request.getParameter("cpf");
	String cliente = request.getParameter("nome");

	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	java.util.Date utilDate = formatter.parse(dataStr);
	java.sql.Date data = new java.sql.Date(utilDate.getTime());

	int idCliente = 1;
	Pedido ped = new Pedido(data, 1, idCliente, "nomeCliente");

	PedidoDao dao = new PedidoDao();
	dao.salvar(ped);

	List<Pedido> pedidos = dao.consultar();
	for (Pedido p : pedidos) {
		out.print("<p>"+p.getData()+" "+p.getNomeCliente()+"</p>");
	}
	out.print("<hr />");
	out.print("<a href='pedido.jsp'>novo</a>");
%>