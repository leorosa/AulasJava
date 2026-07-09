package exercicio11;

public class Livro {
	private String titulo;
	private String autor;
	private int quantidadeDisponivel = 100;

	void setTitulo(String titulo) {
		if (titulo.length()>0)
			this.titulo = titulo;
	}
	String getTitulo() {
		return this.titulo;
	}
	void setAutor(String autor) {
		if (autor.length()>0)
			this.autor = autor;
	}
	String getAutor() {
		return this.autor;
	}
	boolean emprestar() {
		if (this.quantidadeDisponivel>0) {
			this.quantidadeDisponivel -= 1;
			return true;
		} else {
			return false;
		}
	}
	void devolver() {
		this.quantidadeDisponivel += 1;
	}
	void exibirLivro() {
		System.out.println("Título: " + this.titulo);
		System.out.println("Autor: " + this.autor);
		System.out.println("Quantidade disponível: " + this.quantidadeDisponivel + " unidades");
	}
}
