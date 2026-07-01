public class Exercicio10 {
	public static void main(String[] args) {
		Celular celular = new Celular();
		celular.modelo = "Nokia 2020";
		celular.carregar();
		celular.mostrarBateria();
		celular.usar(50);
		celular.mostrarBateria();
		celular.usar(25);
		celular.mostrarBateria();
		celular.usar(50);
		celular.mostrarBateria();
	}
}

class Celular {
	String modelo;
	int bateria;
	
	void carregar() {
		this.bateria = 100;
	}
	
	void usar(int percentual) {
		if (percentual<=100)
			this.bateria -= percentual;
		if (this.bateria<0)
			this.bateria = 0;
	}
	void mostrarBateria() {
		System.out.println("Bateria atual: " + this.bateria + "%");
	}
}