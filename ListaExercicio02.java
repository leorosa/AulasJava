// 2026-04-02 desvio condicional

import java.util.Scanner;

public class ListaExercicio02 {

	public static void main(String[] args) {
//		exercicio01();
//		exercicio02();
//		exercicio03();
//		exercicio04();
//		exercicio05();
		exercicio06();
	}
	
	static void exercicio01() {
		Scanner entradaUser = new Scanner(System.in);
		System.out.print("informe um valor: ");
		int val = entradaUser.nextInt();
		if(val%2==0) {
			System.out.println(val + " é par");			
		} else {
			System.out.println(val + " é ímpar");
		}
		entradaUser.close();
	}

	static void exercicio02() {
		Scanner entradaUser = new Scanner(System.in);
		System.out.print("informe dois valores: ");
		float val1 = entradaUser.nextFloat();
		float val2 = entradaUser.nextFloat();
//		System.out.println("o maior valor é: " + Math.max(val1,val2));
		if (val1>val2) {
			System.out.println("o maior valor é: " + val1);
		} else {
			System.out.println("o maior valor é: " + val2);
		}
		entradaUser.close();
	}

	static void exercicio03() {
		Scanner entradaUser = new Scanner(System.in);
		System.out.print("informe um valor: ");
		float val = entradaUser.nextFloat();
//		System.out.println((val>0?"pos":"neg"));	// estilo C
		if (val<0) {
			System.out.println(val + " é negativo.");
		} else if (val>0) {
			System.out.println(val + " é positivo.");
		} else {
			System.out.println(val + " é nulo.");
		}
		entradaUser.close();
	}

	static void exercicio04() {
		Scanner entradaUser = new Scanner(System.in);
		System.out.print("informe a nota do aluno: ");
		float val = entradaUser.nextFloat();
		if (val>=6) {
			System.out.println("aluno aprovado.");
		} else {
			System.out.println("aluno reprovado.");
		}
		entradaUser.close();
	}

	static void exercicio05() {
		Scanner entradaUser = new Scanner(System.in);
		System.out.print("informe a idade: ");
		int val = entradaUser.nextInt();
		if (val>=16) {
			System.out.println("a pessoa já pode votar.");
		} else {
			System.out.println("a pessoa pode votar em " + (16-val) + " anos.");
		}
		entradaUser.close();
	}

///// ///// /////

	static void exercicio06() {
		Scanner entradaUser = new Scanner(System.in);
		System.out.print("informe três valores: ");
		float val1 = entradaUser.nextFloat();
		float val2 = entradaUser.nextFloat();
		float val3 = entradaUser.nextFloat();
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
		entradaUser.close();
	}
}

