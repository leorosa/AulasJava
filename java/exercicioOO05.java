public class Exercicio05 {
	public static void main(String[] args) {
		Livro livro = new Livro();
		livro.titulo = "Cem Anos de Solidão";
		livro.autor = "Gabriel Garcia Marques";
		livro.disponivel = true;
		livro.emprestar();
		livro.emprestar();
		livro.devolver();
	}
}

class Livro {
	String titulo;
	String autor;
	boolean disponivel;
	
	void emprestar() {
		if (this.disponivel)
			this.disponivel = false;
		else
			System.out.println("'" + this.titulo + "' não está disponível");
	}
	void devolver() {
		if (!this.disponivel)
			this.disponivel = true;
		else
			System.out.println("'" + this.titulo + "' não está emprestado");
	}
}