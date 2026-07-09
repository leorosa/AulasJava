package exercicio11;

import java.util.ArrayList;
import java.util.List;

public class Exercicio11 {
	public static List<Livro> livros = new ArrayList<>();
	public static List<Usuario> usuarios = new ArrayList<>();

	public static void main(String[] args) {

		Livro livro1 = new Livro();
		livro1.setTitulo("O Hobbit");
		livro1.setAutor("Tolkien");
		livros.add(livro1);
		Livro livro2 = new Livro();
		livro2.setTitulo("O Silmarillion");
		livro2.setAutor("Tolkien");
		livros.add(livro2);

		Usuario usuario = new Usuario();
		usuario.setNome("João");
		usuarios.add(usuario);

		emprestar(livros.get(0), usuarios.get(0));
		emprestar(livros.get(1), usuarios.get(0));
		emprestar(livros.get(0), usuarios.get(0));
		devolver(livros.get(0), usuarios.get(0));
		devolver(livros.get(0), usuarios.get(0));
	}
	

	static void emprestar(Livro livro, Usuario usuario) { // falta: anotar datas de empréstimo e devolução
		if(livro.emprestar())
			usuario.addLivro(livro);
	}

	static void devolver(Livro livro, Usuario usuario) {
		if (usuario.remLivro(livro))
			livro.devolver();
	}
}

/*
	public static void main(String[] args) {

		Livro livro1 = new Livro();
		livro1.setTitulo("O Hobbit");
		livro1.setAutor("Tolkien");
		livros.add(livro1);
		Livro livro2 = new Livro();
		livro2.setTitulo("O Silmarillion");
		livro2.setAutor("Tolkien");
		livros.add(livro2);

		Usuario usuario = new Usuario();
		usuario.setNome("João");
		usuarios.add(usuario);
/ *
		livro1.emprestar();
		livro2.emprestar();
		livro1.exibirLivro();
		livro2.exibirLivro();
		livro1.devolver();
		livro2.devolver();
		livro1.exibirLivro();
		livro2.exibirLivro();
* /
		emprestar("O Hobbit", "João");
		emprestar("Hobbit", "Maria");
		devolver("Hobbit", "João");
		devolver("O Hobbit", "João");
	}
	
	static boolean usuarioExiste;
	static boolean livroExiste;
	static void emprestarAntigo(String titulo, String nome) {
		usuarioExiste = false;
		usuarios.forEach(usuario -> {
			if (usuario.getNome().equals(nome)) {
				usuarioExiste = true;
				livroExiste = false;
				livros.forEach(livro -> {
					if (livro.getTitulo().equals(titulo)) {
						livroExiste = true;
						if(livro.emprestar())
							usuario.addLivro(titulo);
					}
				});
			}
		});
		if (!usuarioExiste)
			System.out.println(nome + " não cadastrado.");
		if (!livroExiste)
			System.out.println(titulo + " não cadastrado.");
	}

	static void devolverAntigo(String titulo, String nome) {
		usuarioExiste = false;
		usuarios.forEach(usuario -> {
			if (usuario.getNome().equals(nome)) {
				usuarioExiste = true;
				livroExiste = false;
				livros.forEach(livro -> {
					if (livro.getTitulo().equals(titulo)) {
						livroExiste = true;
						livro.devolver();
						usuario.remLivro(titulo);
					}
				});
			}
		});
		if (!usuarioExiste)
			System.out.println(nome + " não cadastrado.");
		if (!livroExiste)
			System.out.println(titulo + " não cadastrado.");
	}
*/

