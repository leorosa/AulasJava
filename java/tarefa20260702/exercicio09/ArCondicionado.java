package exercicio09;

public class ArCondicionado {
	private int temperaturaAtual = 25;

	void setTemperaturaAtual(int temperatura) {
		if(temperatura>=16 && temperatura<=30)
			this.temperaturaAtual = temperatura;
	}
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
