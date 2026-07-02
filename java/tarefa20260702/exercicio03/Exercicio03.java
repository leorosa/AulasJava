package exercicio03;

public class Exercicio03 {
	public static void main(String[] args) {
		Aluno aluno = new Aluno();
		aluno.setNome("João");
		aluno.setNota1(8);
		aluno.setNota2(7.55);
		System.out.println(aluno.calcularMedia());
		aluno.verificarSituacao();
	}
}
