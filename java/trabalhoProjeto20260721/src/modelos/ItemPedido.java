package modelos;

public class ItemPedido {
	private int id;
	private int idPedido;
	private int idProduto;
	private String descricaoProduto;
	private int quantidade;
//no banco de dados MySQL:
//create table lista_pedido (
//	id int primary key auto_increment,
//	id_pedido int,
//	constraint fk_pedido foreign key (id_pedido) references tb_pedidos(id),
//	id_produto int,
//	constraint fk_produto foreign key (id_produto) references tb_produtos(id),
//	quantidade int );

	public ItemPedido() {
	}
	public ItemPedido(int idPedido, int idProduto, String descricaoProduto, int quantidade) {
		setIdPedido(idPedido);
		setIdProduto(idProduto);
		setDescricaoProduto(descricaoProduto);
		setQuantidade(quantidade);
	}
	public ItemPedido(int id, int idPedido, int idProduto, String descricaoProduto, int quantidade) {
		setId(id);
		setIdPedido(idPedido);
		setIdProduto(idProduto);
		setDescricaoProduto(descricaoProduto);
		setQuantidade(quantidade);
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		if (id>0)
			this.id = id;
	}
	public int getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(int idPedido) {
		if (idPedido>0)
			this.idPedido = idPedido;
	}
	public int getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(int idProduto) {
		if (idProduto>0)
			this.idProduto = idProduto;
	}
	public String getDescricaoProduto() {
		return descricaoProduto;
	}
	public void setDescricaoProduto(String descricaoProduto) {
		if (descricaoProduto!=null && descricaoProduto.length()>0)
			this.descricaoProduto = descricaoProduto;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		if (quantidade>0)
			this.quantidade = quantidade;
	}

	public void listar() {
		System.out.println(this.getId() + " - pedido: " + this.getIdPedido() + ", produto: " + this.getDescricaoProduto() + ", quantidade: " + this.getQuantidade());
	}

}
