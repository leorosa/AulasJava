package modelos;

import utils.ConectaDB;

public class Produto {
	private int id;
	private String descricao;
	private double preco;

	public Produto() {
	}
	public Produto(String descricao, double preco) {
		setDescricao(descricao);
		setPreco(preco);
		if (ConectaDB.conectar() != null)
			System.out.println("conectado");
	}
	public Produto(int id, String descricao, double preco) {
		setId(id);
		setDescricao(descricao);
		setPreco(preco);
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
		this.descricao = descricao;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
}
