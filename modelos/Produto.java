package modelos;

import java.util.Scanner;

public class Produto {
	private int id;
	private String descricao;
	private double preco;
// no banco de dados MySQL:
//      alter table tb_produtos add column estoque int;
	private int estoque;

	public Produto() {
	}
	public Produto(String descricao, double preco, int estoque) {
		setDescricao(descricao);
		setPreco(preco);
		setEstoque(estoque);
	}
	public Produto(int id, String descricao, double preco, int estoque) {
		setId(id);
		setDescricao(descricao);
		setPreco(preco);
		setEstoque(estoque);
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		if (descricao.length()>0)
			this.descricao = descricao;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		if (estoque>0) // nao ha nada gratis
			this.preco = preco;
	}
	public int getEstoque() {
		return estoque;
	}
	public void setEstoque(int estoque) {
		if (estoque>=0)
			this.estoque = estoque;
	}

	public void listar() {
		System.out.println(this.getId() + " - " + this.getDescricao() + ": R$" + this.getPreco() + ", " + this.getEstoque() + " unidades");
	}
	public void editar() {
		Scanner sc = new Scanner(System.in);
		System.out.print("descrição: ");
		this.setDescricao(sc.nextLine());
		System.out.print("preço: ");
		this.setPreco(sc.nextFloat());
		System.out.print("estoque: ");
		this.setEstoque(sc.nextInt());
//		sc.close();
	}
}
