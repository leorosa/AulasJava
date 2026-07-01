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

class Funcionario {
	private String nome;
	private double salario;

	void setNome(String nome) {
		if (nome.length()>0)
			this.nome = nome;
	}
	void setSalario(double salario) {
		if (salario>0)
			this.salario = salario;
	}
	void aumentarSalario(double percentual) {
		this.salarioAntigo = this.salario;
		this.salario *= (1+percentual/100);
	}
	void calcularSalarioAnual() {
		System.out.println("Salário anual: " + this.salario*12);
	}
	void exibirDados() {
		System.out.println("Nome: " + this.nome);
		System.out.println("Salário: R$" + this.salario);
	}
}
