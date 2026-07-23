<%@page import="dao.ClienteDao"%>
<%@page import="modelos.Cliente"%>
<%@page import="java.util.List"%>
<%
	String cpf = request.getParameter("cpf");
	String nome = request.getParameter("nome");
	String email = request.getParameter("email");
	String rua = request.getParameter("rua");
	int numero = Integer.parseInt(request.getParameter("numero"));
	String bairro = request.getParameter("bairro");
	String cep = request.getParameter("cep");
	String cidade = request.getParameter("cidade");
	String estado = request.getParameter("estado");

	Cliente cli = new Cliente(cpf, nome, email, rua, numero, bairro, cep, cidade, estado);

	ClienteDao dao = new ClienteDao();
	dao.salvar(cli);

	List<Cliente> clientes = dao.consultar();
	for (Cliente c : clientes) {
		out.print("<p>"+c.getNome()+" "+c.getEmail()+"</p>");
	}
	out.print("<hr />");
	out.print("<a href='cliente.jsp'>novo</a>");
%>