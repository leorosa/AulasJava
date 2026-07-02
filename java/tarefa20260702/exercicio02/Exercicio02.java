package exercicio02;

public class Exercicio02 {

	public static void main(String[] args) {
		ContaBancaria conta = new ContaBancaria();
		conta.depositar(1000.00);
		conta.sacar(300.00);
		conta.sacar(900.00);
		conta.exibirDados();
	}
}


