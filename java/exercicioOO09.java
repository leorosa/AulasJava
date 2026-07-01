public class Exercicio09 {

	public static void main(String[] args) {
		ArCondicionado arcondicionado = new ArCondicionado();
		arcondicionado.temperaturaAtual = 25;
		arcondicionado.exibirTemperatura();
		arcondicionado.aumentarTemperatura(50);
		arcondicionado.exibirTemperatura();
		arcondicionado.diminuirTemperatura(100);
		arcondicionado.exibirTemperatura();
	}

}

class ArCondicionado {
	int temperaturaAtual;
	
	void aumentarTemperatura(int dif) {
		this.temperaturaAtual += dif;
		if (this.temperaturaAtual>30) {
			this.temperaturaAtual = 30;
		}
	}
	void diminuirTemperatura(int dif) {
		this.temperaturaAtual -= dif;
		if (this.temperaturaAtual<16) {
			this.temperaturaAtual = 16;
		}
	}
	void exibirTemperatura() {
		System.out.println("Temperatura atual: " + this.temperaturaAtual);
	}
}