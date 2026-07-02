package exercicio04;

public class Exercicio04 {
	public static void main(String[] args) {
		Funcionario funcionario = new Funcionario();
		funcionario.setNome("João");
		funcionario.setSalario(2500);
		funcionario.exibirDados();
		funcionario.aumentarSalario(15);
		funcionario.calcularSalarioAnual();
		funcionario.exibirDados();
	}
}

