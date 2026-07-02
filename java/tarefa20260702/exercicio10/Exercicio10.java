package exercicio10;

public class Exercicio10 {
	public static void main(String[] args) {
		Celular celular = new Celular();
		celular.setModelo("Nokia 2020");
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
