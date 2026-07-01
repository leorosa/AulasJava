public class Exercicio07 {
	public static void main(String[] args) {
		Lampada lampada = new Lampada();
		lampada.ligar();
		lampada.mostrarEstado();
		lampada.desligar();
		lampada.mostrarEstado();
	}
}

class Lampada {
	boolean ligada;
	
	void ligar() {
		this.ligada = true;
	}
	void desligar() {
		this.ligada = false;
	}
	void mostrarEstado() {
		System.out.print("A lâmpada está ");
		if (!this.ligada)
			System.out.print("des");
		System.out.println("ligada.");
	}
}