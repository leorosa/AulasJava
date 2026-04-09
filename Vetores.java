import java.util.Scanner;

public class Vetores {
	public static void main(String[] args) {
//		exemplo();
//		exercicio01();
//		exemplosFuncao();
//		exercicio02();
		exercicio03();
//		exercicio04();
//		exercicio05();
//		jogoDaVelha();
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
		int[] valores = new int[10];
		Scanner sc = new Scanner(System.in);
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
	
	public static void exercicio03() {
		int[] valores = new int[10];
		int val;
		Scanner sc = new Scanner(System.in);
		int i=0;
		while (i<10) {
			System.out.print("informe valor: ");
			val = sc.nextInt();
			if (val>=1 && val <=10) {
				valores[i] = val;
				i++;
			} else {
				System.out.println("valor inválido.");
			}
		}
		sc.close();
		for (int j=9; j>=0; j--) {
			System.out.println(valores[j]);
		}
	}
	
	public static void jogoDaVelha() {
		Scanner sc = new Scanner(System.in);
		int[][] valores = {{0,0,0} , {0,0,0} , {0,0,0}};
		int x = 0;
		int y = 0;
		while (! testeFim(valores)) {
			imprimeStatus(valores);
			while (true) {
				System.out.println("jogador 1, indique posição x e y: ");
				x = sc.nextInt();
				y = sc.nextInt();
				if (testePosicao(valores, x, y)) {
					
					break;
				}
			}
			if (testeJogador(valores, 1)) {
				System.out.println("jogador 1 venceu");
				break;
			}
			System.out.println("jogador 2, indique posição x e y: ");
			x = sc.nextInt();
			y = sc.nextInt();
		}
	}

	public static boolean testePosicao(int[][] valores, int i, int j) {
		if (valores[i][j]==0) { return true; } // posição válida/livre
		else {return false; }
	}

	public static boolean testeJogador(int[][] valores, int jogador) {
		for(int i=0;i<=2;i++) {
			if (valores[i][0]==jogador && valores[i][1]==jogador && valores[i][2]==jogador) { return true; }
			if (valores[0][i]==jogador && valores[1][i]==jogador && valores[2][i]==jogador) { return true; }
			if (valores[0][0]==jogador && valores[1][1]==jogador && valores[2][2]==jogador) { return true; }
			if (valores[0][2]==jogador && valores[1][1]==jogador && valores[2][0]==jogador) { return true; }
		}
		return false;
	}

	public static boolean testeFim(int[][] valores) {
		for(int i=0;i<=2;i++) {
			for(int j=0;j<=2;j++) {
				if (valores[i][j]==0) {
					return false;
				}
			}
		}
		return true;
	}

	public static void imprimeStatus(int[][] valores) {
		for(int i=0;i<=2;i++) {
			for(int j=0;j<=2;j++) {
				System.out.print(valores[i][j]);
			}
			System.out.println("");
		}
	}
}

