
public class Main {

	public static void main(String[] args) {
		Aluno al1 = new Aluno();
		al1.setNome("Ana");
		al1.setEmail("ana@gmail.com");
		al1.setMedia(7.0);
/*		System.out.println(al1.getNome());
		System.out.println(al1.getEmail());
		System.out.println(al1.getStatus()); */
		al1.display();

		Cliente cl1 = new Cliente();
		cl1.cartao = "1234 5678 4321 8765";
		cl1.setNome("João");
		cl1.setEmail("joao@gmail.com");
		System.out.println(cl1.getLimite());
	}

}
