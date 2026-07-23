import java.util.ArrayList;
import java.util.List;

class Main {
	public static void main(String[] args) {
		List<Pessoa> pessoas = new ArrayList();
		Pessoa p1 = new Pessoa(); // instanciar objeto
		p1.nome = "Ana";
		p1.email = "ana@gmail.com";
//		System.out.println(p.nome + " " + p.email);
		pessoas.add(p1);

		Pessoa p2 = new Pessoa(); // instanciar objeto p2
		p2.nome = "João";
		p2.email = "joao@gmail.com";
//		System.out.println(p2.nome + " " + p2.email);
		pessoas.add(p2);

		Pessoa p3 = new Pessoa(); // instanciar objeto p2
		p3.nome = "Pedro";
		p3.email = "pedro@gmail.com";
//		System.out.println(p2.nome + " " + p2.email);
		pessoas.add(p3);

		for (Pessoa p : pessoas) {
			p.display();
		}
	}
}

class Pessoa {
	String nome;
	String email;

	void display() {
		System.out.println(this.nome + " " + this.email);
	}
}
