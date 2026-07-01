public class Exercicio08 {
	public static void main(String[] args) {
		Retangulo retangulo = new Retangulo();
		retangulo.largura = 5;
		retangulo.altura = 3;
		retangulo.exibirInformacoes();
		retangulo.calcularArea();
		retangulo.calcularPerimetro();
	}
}

class Retangulo {
	double largura;
	double altura;
	
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