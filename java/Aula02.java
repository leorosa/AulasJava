// Aula 02

import java.util.Scanner; // Import the Scanner class
import javax.swing.JOptionPane;

public class Aula02 {
	public static void main(String[] args) {
//		entradaComScanner();
		entradaComJoptionPane();
	}

	static void entradaComJoptionPane() {
		String nome = JOptionPane.showInputDialog("Informe seu nome");
		int idade = Integer.parseInt( JOptionPane.showInputDialog("Informe sua idade") );
		JOptionPane.showMessageDialog(null, nome + " tem " + idade + " anos.");
	}

	static void entradaComScanner() {
		Scanner entradaUser = new Scanner(System.in); // Create a Scanner object
		System.out.print("informe seu nome: ");
		String nome = entradaUser.nextLine();
//		System.out.println("hello " + nome);

		System.out.print("informe a sua idade: ");
		int idade = entradaUser.nextInt();

		System.out.print("informe a sua altura: ");
		float altura = entradaUser.nextFloat();

		System.out.print("'" + nome + "' tem " + idade + " anos");
		System.out.println(" e " + altura + "m de altura");
		entradaUser.close();
	}
}

