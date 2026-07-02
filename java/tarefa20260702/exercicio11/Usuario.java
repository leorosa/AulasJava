package exercicio11;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	private String nome;
	private int matricula;
	private List<Livro> livros = new ArrayList<>();

	void setNome(String nome) {
		if (nome.length()>0)
			this.nome = nome;
	}
	String getNome() {
		return this.nome;
	}
	void addLivro(Livro livro) {
		if (this.livros.contains(livro))
			System.out.println(this.nome + " já pegou emprestado " + livro.getTitulo());
		else
			this.livros.add(livro);
	}
	boolean remLivro(Livro livro) {
		if (this.livros.contains(livro)) {
			this.livros.remove(livro); //Integer.valueOf(titulo));
			return true;
		} else {
			System.out.println(livro.getTitulo() + " não está emprestado para " + this.nome);
			return false;
		}
	}
	void exibirUsuario() {
		System.out.println("Nome: " + this.nome);
		System.out.println("Matricula: " + this.matricula);
		System.out.println("Livros emprestados: " + this.livros.toString());
	}
}
