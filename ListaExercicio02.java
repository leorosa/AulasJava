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
		sc.close();
		if(val%2==0) {
			System.out.println(val + " é par");			
		} else {
			System.out.println(val + " é ímpar");
		}
	}

	static void exercicio02() {
		Scanner sc = new Scanner(System.in);
		System.out.print("informe dois valores: ");
		float val1 = sc.nextFloat();
		float val2 = sc.nextFloat();
		sc.close();
//		System.out.println("o maior valor é: " + Math.max(val1,val2));
		if (val1>val2) {
			System.out.println("o maior valor é: " + val1);
		} else {
			System.out.println("o maior valor é: " + val2);
		}
	}

	static void exercicio03() {
		Scanner sc = new Scanner(System.in);
		System.out.print("informe um valor: ");
		float val = sc.nextFloat();
		sc.close();
//		System.out.println((val>0?"pos":"neg"));	// estilo C
		if (val<0) {
			System.out.println(val + " é negativo.");
		} else if (val>0) {
			System.out.println(val + " é positivo.");
		} else {
			System.out.println(val + " é nulo.");
		}
	}

	static void exercicio04() {
		Scanner sc = new Scanner(System.in);
		sc.close();
		System.out.print("informe a nota do aluno: ");
		float val = sc.nextFloat();
		if (val>=6) {
			System.out.println("aluno aprovado.");
		} else {
			System.out.println("aluno reprovado.");
		}
	}

	static void exercicio05() {
		Scanner sc = new Scanner(System.in);
		System.out.print("informe a idade: ");
		sc.close();
		int val = sc.nextInt();
		if (val>=16) {
			System.out.println("a pessoa já pode votar.");
		} else {
			System.out.println("a pessoa pode votar em " + (16-val) + " anos.");
		}
	}

///// ///// /////

	static void exercicio06() {
		Scanner sc = new Scanner(System.in);
		System.out.print("informe três valores: ");
		float val1 = sc.nextFloat();
		float val2 = sc.nextFloat();
		float val3 = sc.nextFloat();
		float valm;
		sc.close();
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
		sc.close();
		if (isTriangle(lado1, lado2, lado3)) {
			System.out.println("os 3 lados formam um triângulo.");
		} else {
			System.out.println("os 3 lados não formam um triângulo.");
		}
//		if (lado1>lado2) {
//			if (lado1>lado3) { 	// lado1 é o maior
//				if (lado2+lado3 > lado1) {
//					System.out.println("os 3 lados formam um triângulo.");
//				}
//			} else {			// lado3 é o maior
//				if (lado1+lado2 > lado3) {
//					System.out.println("os 3 lados formam um triângulo.");
//				}
//			}
//		} else {
//			if (lado2>lado3) { 	// lado2 é o maior
//				if (lado1+lado3 > lado2) {
//					System.out.println("os 3 lados formam um triângulo.");
//				}
//			} else {			// lado3 é o maior
//				if (lado1+lado2 > lado3) {
//					System.out.println("os 3 lados formam um triângulo.");
//				}
//			}
//		}
	}

	static boolean isTriangle(float a, float b, float c) {
		if (a>b) {
			if (a>c) { 	// a é o maior
				if (b+c > a) {
					return true;
				}
			} else {			// c é o maior
				if (a+b > c) {
					return true;
				}
			}
		} else {
			if (b>c) { 	// b é o maior
				if (a+c > b) {
					return true;
				}
			} else {			// c é o maior
				if (a+b > c) {
					return true;
				}
			}
		}
		return false;
	}

	static void exercicio09() {
		Scanner sc = new Scanner(System.in);
		System.out.print("informe o comprimento de três lados: ");
		float lado1 = sc.nextFloat();
		float lado2 = sc.nextFloat();
		float lado3 = sc.nextFloat();
		sc.close();
		String tipo = "";
		if (isTriangle(lado1, lado2, lado3)) {	// testar se é retângulo
			if (lado1==lado2 || lado1==lado3 || lado2==lado3) {
				tipo = "isósceles";
			} else {
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
			System.out.println("o triângulo) é " + tipo);
		} else {
			System.out.println("não é um triângulo.");
		}
	}

	static void exercicio10() {
		System.out.print("informe o seu nome de usuário e senha: ");
		Scanner sc = new Scanner(System.in);
		String nome = sc.nextLine();
		String senha = sc.nextLine();
		sc.close();
		if (senha.equals("123") || senha.equals("12345") || senha.equals("senha")) {
			System.out.println("acesso negado");
		} else {
			System.out.println("acesso permitido");
		}
	}

	static void exercicio11() {
		System.out.print("informe o ano: ");
		Scanner sc = new Scanner(System.in);
		int ano = sc.nextInt();
		sc.close();
		if (ano%4==0 && (ano%100!=0 || ano%400==0)) {
			System.out.println("ano bissexto");
		}
	}

	static void exercicio() {
		System.out.print("informe dois valores: ");
		Scanner sc = new Scanner(System.in);
		float val1 = sc.nextFloat();
		float val2 = sc.nextFloat();
		System.out.print("agora informe a operação: ");
		String oper = sc.nextLine();
		System.out.println(oper);
//		if (oper.equals("+")) {
//			System.out.println("resultado: " + (val1+val2));
//		} else if (oper.equals("-")) {
//			System.out.println("resultado: " + (val1-val2));
//		} else if (oper.equals("*")) {
//			System.out.println("resultado: " + (val1*val2));
//		} else if (oper.equals("/")) {
//			System.out.println("resultado: " + (val1/val2));
//		} else {
//			System.out.println("operação inválida.");
//		}
		sc.close();
	}
}

