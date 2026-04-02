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
		exercicio07();
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

}

