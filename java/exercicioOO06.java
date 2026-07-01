public class Exercicio06 {
	public static void main(String[] args) {
		Carro carro = new Carro();
		carro.modelo = "308";
		carro.marca = "Peugeot";
		carro.velocidadeAtual = 100;
		carro.exibirVelocidade();
		carro.acelerar(20);
		carro.exibirVelocidade();
		carro.frear(50);
		carro.exibirVelocidade();
		carro.frear(100);
		carro.exibirVelocidade();
	}
}

class Carro {
	String modelo;
	String marca;
	int velocidadeAtual;
	
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