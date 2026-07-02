package exercicio10;

public class Celular {
	private String modelo;
	private int bateria;

	void setModelo(String modelo) {
		if (modelo.length()>0)
			this.modelo = modelo;
	}
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
