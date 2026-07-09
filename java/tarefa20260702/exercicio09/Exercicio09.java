package exercicio09;

public class Exercicio09 {

	public static void main(String[] args) {
		ArCondicionado arcondicionado = new ArCondicionado();
		arcondicionado.setTemperaturaAtual(25);
		arcondicionado.exibirTemperatura();
		arcondicionado.aumentarTemperatura(50);
		arcondicionado.exibirTemperatura();
		arcondicionado.diminuirTemperatura(100);
		arcondicionado.exibirTemperatura();
	}

}
