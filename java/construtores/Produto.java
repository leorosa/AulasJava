
public class Produto {
	private int id;
	private String descricao;
	private double preco;
	private int estoque;

	public Produto() {
		//
	}
	public Produto(int id, String descricao) {
		this.id = id;
		this.descricao = descricao;
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
		if (preco<=0) {
			System.out.println("Preço inválido.");
			return;
		}
		this.preco = preco;
	}
	public int getEstoque() {
		return estoque;
	}
	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}

}
