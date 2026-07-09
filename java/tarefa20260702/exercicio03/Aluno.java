package exercicio03;

public class Aluno {
	private String nome;
	private double nota1;
	private double nota2;

	void setNome(String nome) {
		if (nome.length()>0)
			this.nome = nome;
	}
	void setNota1(double nota) {
		if (nota>=0)
			this.nota1 = nota;
	}
	void setNota2(double nota) {
		if (nota>=0)
			this.nota2 = nota;
	}
	double calcularMedia() {
		return (nota1+nota2)/2;
	}
	void verificarSituacao() {
		double media = calcularMedia();
		if (media>=7)
			System.out.println(this.nome + " está Aprovado");
		else if (media>=5)
			System.out.println(this.nome + " está em Recuperação");
		else
			System.out.println(this.nome + " está Reprovado");
	}
