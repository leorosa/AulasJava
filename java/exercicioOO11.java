import java.util.ArrayList;
import java.util.List;

public class Exercicio11 {
	public static List<Livro> livros = new ArrayList<>();
	public static List<Usuario> usuarios = new ArrayList<>();

	public static void main(String[] args) {

		Livro livro1 = new Livro();
		livro1.titulo = "O Hobbit";
		livro1.autor = "Tolkien";
		livro1.quantidadeDisponivel = 10;
		livros.add(livro1);
		Livro livro2 = new Livro();
		livro2.titulo = "O Silmarillion";
		livro2.autor = "Tolkien";
		livro2.quantidadeDisponivel = 5;
		livros.add(livro2);

		Usuario usuario = new Usuario();
		usuario.nome = "João";
		usuario.matricula = 12345;
		usuarios.add(usuario);
/*
		livro1.emprestar();
		livro2.emprestar();
		livro1.exibirLivro();
		livro2.exibirLivro();
		livro1.devolver();
		livro2.devolver();
		livro1.exibirLivro();
		livro2.exibirLivro();
*/
		emprestar("O Hobbit", "João");
		emprestar("Hobbit", "Maria");
		devolver("Hobbit", "João");
		devolver("O Hobbit", "João");
	}
	
	static boolean usuarioExiste;
	static boolean livroExiste;
	static void emprestar(String titulo, String nome) {
		usuarioExiste = false;
		usuarios.forEach(usuario -> {
			if (usuario.nome.equals(nome)) {
				usuarioExiste = true;
				livroExiste = false;
				livros.forEach(livro -> {
					if (livro.titulo.equals(titulo)) {
						livroExiste = true;
						if(livro.emprestar())
							usuario.livros.add(titulo);
					}
				});
			}
		});
		if (!usuarioExiste)
			System.out.println(nome + " não cadastrado.");
		if (!livroExiste)
			System.out.println(titulo + " não cadastrado.");
	}

	static void devolver(String titulo, String nome) {
		usuarioExiste = false;
		usuarios.forEach(usuario -> {
			if (usuario.nome.equals(nome)) {
				usuarioExiste = true;
				livroExiste = false;
				if (usuario.livros.contains(titulo)) {
					livros.forEach(livro -> {
						if (livro.titulo.equals(titulo)) {
							livroExiste = true;
							livro.devolver();
							usuario.livros.add(titulo);
						}
					});
				} else {
					System.out.println(usuario.nome + " não pegou '" + titulo + "' emprestado.");
				}
			}
		});
		if (!usuarioExiste)
			System.out.println(nome + " não cadastrado.");
		if (!livroExiste)
			System.out.println(titulo + " não cadastrado.");
	}
}

class Livro {
	String titulo;
	String autor;
	int quantidadeDisponivel;

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

class Usuario {
	String nome;
	int matricula;
	List<String> livros = new ArrayList<>();

	void exibirUsuario() {
		System.out.println("Nome: " + this.nome);
		System.out.println("Matricula: " + this.matricula);
		System.out.println("Livros emprestados: " + this.livros.toString());
	}
}
