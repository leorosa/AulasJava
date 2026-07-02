package exercicio06;

public class Carro {
	private String modelo;
	private String marca;
	private int velocidadeAtual = 100;

	void setModelo(String modelo) {
		if (modelo.length()>0)
			this.modelo = modelo;
	}
	void setMarca(String marca) {
		if (marca.length()>0)
			this.marca = marca;
	}
	void acelerar(int velocidade) {
		this.velocidadeAtual += velocidade;
	}
	void frear(int velocidade) {
		if (this.velocidadeAtual>=velocidade)
			this.velocidadeAtual -= velocidade;
		else
			this.velocidadeAtual = 0;
	}
	void exibirVelocidade() {
		System.out.println("velocidade atual: " + this.velocidadeAtual);
	}
}
