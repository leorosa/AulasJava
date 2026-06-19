import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Colecoes {

	public static void main(String[] args) {
//		lista();
		listaLinkada();
	}
	
	public static void lista() {
		List<String> carros = new ArrayList<>();
		carros.add("Etios");
		carros.add("Volvo");
		carros.add("BMW");
		carros.add("Mercedes");
		carros.add("Volvo");
		carros.add("BMW");
		carros.add("Mercedes");
		System.out.println(carros.size());
		System.out.println(carros.getFirst());
		System.out.println(carros.get(1));
		System.out.println(carros.getLast());
		carros.remove(0);
		carros.remove("Mercedes"); // remove apenas o primeiro
		carros.add(3, "Fusca"); // insere na 5a posição, preservando restantes em índices incrementados
		carros.set(carros.indexOf("Volvo"), "TL");
		System.out.println(carros.toString());
	}

	public static void listaLinkada() {
		LinkedList<String> carros = new LinkedList<String>(); // OO: instanciando objeto 'carros', e acessando seus métodos...
		carros.add("Fuke");
		carros.addFirst("TL");
		System.out.println(carros.toString());
	}
}
