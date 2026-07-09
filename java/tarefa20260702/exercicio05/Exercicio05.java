package exercicio05;

public class Exercicio05 {
	public static void main(String[] args) {
		Livro livro = new Livro();
		livro.setTitulo("Cem Anos de Solidão");
		livro.setAutor("Gabriel Garcia Marques");
		livro.emprestar();
		livro.emprestar();
		livro.devolver();
	}
}
