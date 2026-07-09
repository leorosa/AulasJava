package exercicio05;

public class Livro {
	private String titulo;
	private String autor;
	boolean disponivel = true;

	void setTitulo(String titulo) {
		if (titulo.length()>0)
			this.titulo = titulo;
	}
	void setAutor(String autor) {
		if (autor.length()>0)
			this.autor = autor;
	}
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
