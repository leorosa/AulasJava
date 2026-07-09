package exercicio08;

public class Retangulo {
	private double largura;
	private double altura;
	
	void setLargura(double largura) {
		if(largura>0)
			this.largura = largura;
	}
	void setAltura(double altura) {
		if(altura>0)
			this.altura = altura;
	}
	void calcularArea() {
		System.out.println("Área: " + (this.largura*this.altura));
	}
	void calcularPerimetro() {
		System.out.println("Perímetro: " + (2*this.largura+2*this.altura));
	}
	void exibirInformacoes() {
		System.out.println("Largura: " + this.largura);
		System.out.println("Altura:  " + this.altura);
		
	}
}
