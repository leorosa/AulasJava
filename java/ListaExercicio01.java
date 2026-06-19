import java.util.Scanner; // Import the Scanner class 

public class ListaExercicio1 {

	public static void main(String[] args) {
//		exercicio01();
//		exercicio02();
//		exercicio03();
//		exercicio04();
//		exercicio05();
//		exercicio06();
//		exercicio07();
//		exercicio08();
//		exercicio09();
//		exercicio10();
//		exercicio11();
//		exercicio12();
//		exercicio13();
//		exercicio14();
//		exercicio15();
//		exercicio16();
//		exercicio17();
		exercicio18();
	}

	static void exercicio01() {
		int val = 10;
		System.out.println("valor: " + val );
	}

	static void exercicio02() {
		String nome = "Leonardo";
		int idade = 48;
//		float altura = 1.81f;
		double altura = 1.81;
		System.out.println( nome + " possui " + idade + " e " + altura + " metros de altura." );
	}

	static void exercicio03() {
		int val1 = 5;
		int val2 = 11;
		System.out.println( "a soma das variáveis é " + (val1 + val2) + "." );
	}

	static void exercicio04() {
		double preco = 1.81;
		System.out.println("o produto custa R$" + preco + ".");
	}

///// ///// /////

	static void exercicio05() {
		Scanner entradaUser = new Scanner(System.in); // Create a Scanner object
		System.out.print("informe seu nome: ");
		String nome = entradaUser.nextLine();
		System.out.println("olá " + nome + ".");
		entradaUser.close();
	}

	static void exercicio06() {
		Scanner entradaUser = new Scanner(System.in);
		System.out.print("informe a sua idade: ");
		int idade = entradaUser.nextInt();
		System.out.println("você terá " + (idade+10) + " daqui a 10 anos.");
		entradaUser.close();
	}

	static void exercicio07() {
		Scanner entradaUser = new Scanner(System.in);
		System.out.print("informe dois números inteiros: ");
		int val1 = entradaUser.nextInt();
		int val2 = entradaUser.nextInt();
		System.out.println("a soma dos números é: " + (val1+val2) + ".");
		entradaUser.close();
	}

	static void exercicio08() {
		Scanner entradaUser = new Scanner(System.in);
		System.out.print("informe um número decimal: ");
		float val = entradaUser.nextFloat();
		System.out.println("o dobro desse número é: " + (2*val) + ".");
		entradaUser.close();
	}

///// ///// /////

	static void exercicio09() {
		Scanner entradaUser = new Scanner(System.in);
		System.out.print("informe o valor do produto: ");
		float val = entradaUser.nextFloat();
		System.out.println("o valor com desconto de 10% é: R$" + (val*0.9) + ".");
		entradaUser.close();
	}

	static void exercicio10() {
		Scanner entradaUser = new Scanner(System.in);
		System.out.print("informe a altura e a largura de um retângulo: ");
		float altura = entradaUser.nextFloat();
		float largura = entradaUser.nextFloat();
		System.out.println("a área do retângulo é: " + (altura*largura) + ".");
		entradaUser.close();
	}

	static void exercicio11() {
		Scanner entradaUser = new Scanner(System.in);
		System.out.print("informe as três notas do aluno: ");
		float nota1 = entradaUser.nextFloat();
		float nota2 = entradaUser.nextFloat();
		float nota3 = entradaUser.nextFloat();
		System.out.println("a nota média é: " + ((nota1+nota2+nota3)/3) + ".");
		entradaUser.close();
	}

	static void exercicio12() {
		Scanner entradaUser = new Scanner(System.in);
		System.out.print("informe o valor do salário: ");
		float salario = entradaUser.nextFloat();
		System.out.println("o salário com aumento de 15% é: R$" + (salario*1.15) + ".");
		entradaUser.close();
	}

///// ///// /////

	static void exercicio13() {
		Scanner entradaUser = new Scanner(System.in);
		System.out.print("informe o nome: ");
		String nome = entradaUser.nextLine();
		System.out.print("informe a idade: ");
		int idade = entradaUser.nextInt();
		System.out.println("Olá " + nome + ", você tem " + idade + " anos!");
		entradaUser.close();
	}

	static void exercicio14() {
		Scanner entradaUser = new Scanner(System.in);
		System.out.print("informe dois números: ");
		float val1 = entradaUser.nextFloat();
		float val2 = entradaUser.nextFloat();
		System.out.println("soma:          " + (val1+val2));
		System.out.println("subtração:     " + (val1-val2));
		System.out.println("multiplicação: " + (val1*val2));
		System.out.println("divisão:       " + (val1/val2));
		entradaUser.close();
	}

	static void exercicio15() {
		Scanner entradaUser = new Scanner(System.in);
		System.out.print("informe a temperatura (em graus Celsius): ");
		float temp = entradaUser.nextFloat();
		System.out.println("a temperatura em °F é: " + (temp*9/5+32));
		entradaUser.close();
	}

	static void exercicio16() {
		Scanner entradaUser = new Scanner(System.in);
		System.out.print("informe a quantidade de horas trabalhadas: ");
		float horas = entradaUser.nextFloat();
		System.out.print("informe o valor pago por hora: ");
		float val = entradaUser.nextFloat();
		System.out.println("o salário total é: R$" + (horas*val));
		entradaUser.close();
	}

	static void exercicio17() {
		Scanner entradaUser = new Scanner(System.in);
		System.out.print("informe o seu nome: ");
		String nome = entradaUser.nextLine();
		System.out.print("informe agora 3 números: ");
		float val1 = entradaUser.nextFloat();
		float val2 = entradaUser.nextFloat();
		float val3 = entradaUser.nextFloat();
		float media = (val1+val2+val3)/3;
		System.out.println(nome + ", a média desses valores é: " + media);
		entradaUser.close();
	}

///// ///// /////

	static void exercicio18() {
		Scanner entradaUser = new Scanner(System.in);
		System.out.print("informe o nome do produto: ");
		String nome = entradaUser.nextLine();
		System.out.print("informe o preço: ");
		float preco = entradaUser.nextFloat();
		System.out.print("informe a quantidade: ");
		float quantidade = entradaUser.nextInt();
		System.out.println("o valor total da compra é: R$" + (preco*quantidade));
		entradaUser.close();
	}

}
