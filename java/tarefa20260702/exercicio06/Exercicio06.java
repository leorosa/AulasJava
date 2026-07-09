package exercicio06;

public class Exercicio06 {
	public static void main(String[] args) {
		Carro carro = new Carro();
		carro.setModelo("308");
		carro.setMarca("Peugeot");
		carro.exibirVelocidade();
		carro.acelerar(20);
		carro.exibirVelocidade();
		carro.frear(50);
		carro.exibirVelocidade();
		carro.frear(100);
		carro.exibirVelocidade();
	}
}
