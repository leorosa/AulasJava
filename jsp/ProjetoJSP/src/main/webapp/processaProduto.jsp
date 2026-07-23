<%@page import="dao.ProdutoDao"%>
<%@page import="modelos.Produto"%>
<%@page import="java.util.List"%>
<%
	String descricao = request.getParameter("cpf");
	double preco = request.getParameter("preco");
	int estoque = request.getParameter("estoque");

	Produto prod = new Produto(descricao, preco, estoque);

	ProdutoDao dao = new ProdutoDao();
	dao.salvar(prod);

	List<Produto> produtos = dao.consultar();
	for (Produto p : produtos) {
		out.print("<p>"+p.getDescricao()+" R$"+p.getPreco()+" "+p.getEstoque()+" unidades</p>");
	}
	out.print("<hr />");
	out.print("<a href='produto.jsp'>novo</a>");
%>