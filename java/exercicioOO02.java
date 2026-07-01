public class Exercicio02 {

	public static void main(String[] args) {
		ContaBancaria conta = new ContaBancaria();
		conta.depositar(1000.00);
		conta.sacar(300.00);
		conta.sacar(900.00);
		conta.exibirDados();
	}
}

class ContaBancaria {
	private long numero;
	private String titular;
	private double saldo;

	void depositar(double valor) {
		this.saldo += valor;
	}

	void sacar(double valor) {
		if (this.saldo>=valor)
			this.saldo -= valor;
		else
			System.out.println("saldo insuficiente");
	}

	void consultarSaldo() {
		System.out.println("saldo atual: R$"+this.saldo);
	}

	void exibirDados() {
		System.out.println("número: "+this.numero);
		System.out.println("titular: "+this.titular);
		System.out.println("saldo atual: R$"+this.saldo);
	}
}
