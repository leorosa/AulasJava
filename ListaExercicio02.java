// 2026-04-02 desvio condicional

import java.util.Scanner;

public class ListaExercicio02 {

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
//		exercicio18();
//		exercicio19();
//		exercicio20();
		exercicio();
	}
	
	static void exercicio01() {
		Scanner sc = new Scanner(System.in);
		System.out.print("informe um valor: ");
		int val = sc.nextInt();
		if(val%2==0) {
			System.out.println(val + " é par");			
		} else {
			System.out.println(val + " é ímpar");
		}
		sc.close();
	}

	static void exercicio02() {
		Scanner sc = new Scanner(System.in);
		System.out.print("informe dois valores: ");
		float val1 = sc.nextFloat();
		float val2 = sc.nextFloat();
//		System.out.println("o maior valor é: " + Math.max(val1,val2));
		if (val1>val2) {
			System.out.println("o maior valor é: " + val1);
		} else {
			System.out.println("o maior valor é: " + val2);
		}
		sc.close();
	}

	static void exercicio03() {
		Scanner sc = new Scanner(System.in);
		System.out.print("informe um valor: ");
		float val = sc.nextFloat();
//		System.out.println((val>0?"pos":"neg"));	// estilo C
		if (val<0) {
			System.out.println(val + " é negativo.");
		} else if (val>0) {
			System.out.println(val + " é positivo.");
		} else {
			System.out.println(val + " é nulo.");
		}
		sc.close();
	}

	static void exercicio04() {
		Scanner sc = new Scanner(System.in);
		System.out.print("informe a nota do aluno: ");
		float val = sc.nextFloat();
		if (val>=6) {
			System.out.println("aluno aprovado.");
		} else {
			System.out.println("aluno reprovado.");
		}
		sc.close();
	}

	static void exercicio05() {
		Scanner sc = new Scanner(System.in);
		System.out.print("informe a idade: ");
		int val = sc.nextInt();
		if (val>=16) {
			System.out.println("a pessoa já pode votar.");
		} else {
			System.out.println("a pessoa pode votar em " + (16-val) + " anos.");
		}
		sc.close();
	}

///// ///// /////

	static void exercicio06() {
		Scanner sc = new Scanner(System.in);
		System.out.print("informe três valores: ");
		float val1 = sc.nextFloat();
		float val2 = sc.nextFloat();
		float val3 = sc.nextFloat();
		float valm;
//		Math.max(val1,val2)
		if (val1>val2) {
			valm = val1;
		} else {
			valm = val2;
		}
		if (valm>val3) {
			System.out.println("o maior valor é: " + valm);
		} else {
			System.out.println("o maior valor é: " + val3);
		}
		sc.close();
	}


	static void exercicio07() {
		Scanner sc = new Scanner(System.in);
		System.out.print("informe uma nota: ");
		int nota = sc.nextInt();
		if (nota<=4) {
			System.out.println("nota insuficiente.");
		} else if (nota<=6) {
			System.out.println("nota regular.");
		} else if (nota<=8) {
			System.out.println("nota boa.");
		} else {
			System.out.println("nota excelente.");
		}
		sc.close();
	}

	static void exercicio08() {
		Scanner sc = new Scanner(System.in);
		System.out.print("informe o comprimento de três lados: ");
		float lado1 = sc.nextFloat();
		float lado2 = sc.nextFloat();
		float lado3 = sc.nextFloat();
		if (lado1>lado2) {
			if (lado1>lado3) { 	// lado1 é o maior
				if (lado2+lado3 > lado1) {
					System.out.println("os 3 lados formam um triângulo.");
				}
			} else {			// lado3 é o maior
				if (lado1+lado2 > lado3) {
					System.out.println("os 3 lados formam um triângulo.");
				}
			}
		} else {
			if (lado2>lado3) { 	// lado2 é o maior
				if (lado1+lado3 > lado2) {
					System.out.println("os 3 lados formam um triângulo.");
				}
			} else {			// lado3 é o maior
				if (lado1+lado2 > lado3) {
					System.out.println("os 3 lados formam um triângulo.");
				}
			}
		}
		sc.close();
	}


	static void exercicio() {
		Scanner sc = new Scanner(System.in);
		System.out.print("informe o comprimento de três lados: ");
		float lado1 = sc.nextFloat();
		float lado2 = sc.nextFloat();
		float lado3 = sc.nextFloat();
		String tipo = "";
// ideia: usar resposta do exercicio08 para checar se é um triângulo 
		if (lado1==lado2 || lado1==lado3 || lado2==lado3) {
			tipo = "isósceles";
		} else {
// testar se é retângulo
			if (lado1>lado2) {
				if (lado1>lado3) { 	// lado1 é o maior
					if (lado2*lado2+lado3*lado3 == lado1*lado1) {
						tipo = "retângulo";
					}
				} else {			// lado3 é o maior
					if (lado1*lado1+lado2*lado2 == lado3*lado3) {
						tipo = "retângulo";
					}
				}
			} else {
				if (lado2>lado3) { 	// lado2 é o maior
					if (lado1*lado1+lado3*lado3 == lado2*lado2) {
						tipo = "retângulo";
					}
				} else {			// lado3 é o maior
					if (lado1*lado1+lado2*lado2 == lado3*lado3) {
						tipo = "retângulo";
					}
				}
			}
		}
		if (tipo=="") {
			tipo = "escaleno";
		}
		System.out.println("(se for um triângulo) é " + tipo);
		sc.close();
	}

}

