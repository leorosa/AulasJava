import java.util.Scanner;

public class Vetores {
	public static void main(String[] args) {
//		exemplo();
//		exercicio01();
		exemplosFuncao();
//		exercicio02();
	}
	
	public static void exemplo() {
		String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};
		System.out.println(cars[0]);
		System.out.println(cars[2]);

		cars[2] = "Chevrolet";
		System.out.println(cars[2]);

		System.out.println("");

/// for indexado
		for (int i=0; i<cars.length; i++) {
			System.out.println(i + " -> " + cars[i]);
		}

		System.out.println("");

// while indexado
		int x=0;
		while (x<cars.length) {
			System.out.println(x + " -> " + cars[x++]);
		}

		System.out.println("");

// for iterativo
		for (String car : cars) {
			System.out.println(car);
		}

	}
	
	public static void exercicio01() {
//Crie um array de 5 posições e solicite que o usuário informe os números.
//Em seguida, percorra o array e mostre o dobro do número que ocupa a posição.
		float[] valores = new float[5];
		Scanner sc = new Scanner(System.in); // Create a Scanner object
		for (int i=0; i<valores.length; i++) {
			System.out.print("informe valor: ");
			valores[i] = sc.nextFloat();
		}
		sc.close();
		for (int i=0; i<valores.length; i++) {
			System.out.println("o dobro do valor na posição " + i + " é: " + (valores[i]*2));
		}
	}

	public static void exemplosFuncao() {
		int[] numeros = {1,2,3,4,5};
		System.out.println(max(numeros));
		int[] notas = {7,8,9,10,3};
		listarArray(numeros);
		System.out.println( somar(1000,300));
	}
	
	static void listarArray(int[] dados) {
		for (int n : dados) {
			System.out.println(n);
		}

	}

	static int somar(int n1, int n2) {
		return n1 + n2;
	}

	public static int max(int[] vals) {
		int max = vals[0];
		for (int v : vals) {
			if (v>max) {
				max=v;
			}
		}
		return(max);
	}

	public static void exercicio02() {
//Crie um array de 10 números.
//Solicite ao usuário que informe dados.
//Verifique quais números digitados são pares e quais são ímpares.
		Scanner sc = new Scanner(System.in);
		int[] valores = new int[10];
		for (int i=0; i<valores.length; i++) {
			System.out.print("informe valor: ");
			valores[i] = sc.nextInt();
		}
		sc.close();
		for (int v:valores) {
			if (v%2==0) {
				System.out.println(v + " é par.");
			} else {
				System.out.println(v + " é ímpar.");

			}
		}
	}

}

