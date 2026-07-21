package modelos;

import java.util.Scanner;

public class ListaPedido {
	private int id;
	private int idPedido;
	private int idProduto;
	private int quantidade;
//no banco de dados MySQL:
//create table lista_pedido (
//    id int primary key auto_increment,
//    id_pedido int,
//    constraint fk_pedido foreign key (id_pedido) references tb_pedidos(id),
//    id_produto int,
//    constraint fk_produto foreign key (id_produto) references tb_produtos(id),
//    quantidade int );

	public ListaPedido() {
	}
	public ListaPedido(int idPedido, int idProduto, int quantidade) {
		setIdPedido(idPedido);
		setIdProduto(idProduto);
		setQuantidade(quantidade);
	}
	public ListaPedido(int id, int idPedido, int idProduto, int quantidade) {
		setId(id);
		setIdPedido(idPedido);
		setIdProduto(idProduto);
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
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		if (quantidade>0)
			this.quantidade = quantidade;
	}

	public void listar() {
		System.out.println(this.getId() + " - pedido: " + this.getIdPedido() + ", produto: " + this.getIdProduto() + ", quantidade: " + this.getQuantidade());
	}
	public void editar() {
		Scanner sc = new Scanner(System.in);
		System.out.print("id pedido: ");
		this.setIdPedido(sc.nextInt());
		System.out.print("id produto: ");
		this.setIdProduto(sc.nextInt());
		System.out.print("quantidade: ");
		this.setQuantidade(sc.nextInt());
		sc.nextLine(); // consome nova linhe ignorada por sc.nextInt()
//		sc.close();
	}
}
