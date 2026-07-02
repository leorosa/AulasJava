package exercicio12;

public class Exercicio12 {
	public static void main(String[] args) {
		Carro carro = new Carro();
		carro.setModelo("308");
		carro.setMarca("Peugeot");
		carro.setAno(2010);
		carro.exibirInformacoes();
		carro.alugar();
		carro.exibirInformacoes();
		carro.devolver();
		carro.exibirInformacoes();
	}
}
