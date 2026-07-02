package exercicio12;

public class Carro {
	private String modelo;
	private String marca;
	private int ano;
	private boolean disponivel = true;

	void setModelo(String modelo) {
		if (modelo.length()>0)
			this.modelo = modelo;
	}
	void setMarca(String marca) {
		if (marca.length()>0)
			this.marca = marca;
	}
	void setAno(int ano) {
		if (ano>0)
			this.ano = ano;
	}
	void alugar() {
		if (this.disponivel)
			this.disponivel = false;
		else
			System.out.println("'" + this.modelo + "' não está disponível");
	}
	void devolver() {
		if (!this.disponivel)
			this.disponivel = true;
		else
			System.out.println("'" + this.modelo + "' não está alugado");
	}
	void exibirInformacoes() {
		System.out.println("Marca: " + this.marca);
		System.out.println("Modelo: " + this.modelo);
		if (!this.disponivel)
			System.out.print("in");
		System.out.println("disponível.");
	}
}
