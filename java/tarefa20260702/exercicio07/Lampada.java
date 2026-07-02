package exercicio07;

public class Lampada {
	private boolean ligada;
	
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
