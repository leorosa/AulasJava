// 2026-04-02 desvio condicional

import java.util.Scanner;

public class ListaExercicio02 {

	public static void main(String[] args) {
		exercicio01();
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
}
