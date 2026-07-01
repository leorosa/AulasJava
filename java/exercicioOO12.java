public class Exercicio12 {
	public static void main(String[] args) {
		Carro carro = new Carro();
		carro.modelo = "308";
		carro.marca = "Peugeot";
		carro.ano = 2010;
		carro.exibirInformacoes();
		carro.alugar();
		carro.exibirInformacoes();
		carro.devolver();
		carro.exibirInformacoes();
	}
}

class Carro {
	String modelo;
	String marca;
	int ano;
	boolean disponivel = true;
	int velocidadeAtual;

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