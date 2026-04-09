import java.util.Scanner;

public class Vetores {
	public static void main(String[] args) {
//		exemplo();
//		exercicio01();
//		exemplosFuncao();
//		exercicio02();
//		exercicio03();
//		exercicio04();
//		exercicio05();
//		exercicio06();
		jogoDaVelha();
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

	public static int min(int[] vals) {
		int min = vals[0];
		for (int v : vals) {
			if (v<min) {
				min=v;
			}
		}
		return(min);
	}

	public static int minLimitado(int[] vals, int limite) {
		int min = max(vals);
		for (int v : vals) {
			if (v<min && v>limite) {
				min=v;
			}
		}
		return(min);
	}

	public static int soma(int[] vals) {
		int res = 0;
		for (int v : vals) {
			res += v;
		}
		return(res);
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

	public static void exercicio04() {
		int[] valores = new int[15];
		Scanner sc = new Scanner(System.in);
		for (int i=0; i<valores.length; i++) {
			System.out.print("informe valor: ");
			valores[i] = sc.nextInt();
		}
		sc.close();
		int maxVal = max(valores);
		for (int i=0; i<valores.length; i++) {
			if (valores[i]==maxVal) {
				System.out.println(maxVal + " está na posição" + i);
			}
		}
	}

	public static void exercicio05() {
		int[] valores = new int[8];
		int[] ordenado = new int[valores.length];
		Scanner sc = new Scanner(System.in);
		for (int i=0; i<valores.length; i++) {
			System.out.print("informe valor: ");
			valores[i] = sc.nextInt();
		}
		sc.close();
		int minVal = min(valores);
		int j=0;
		while (j<valores.length) {
			for (int i=0; i<valores.length; i++) {
				if (valores[i]==minVal) {
					ordenado[j] = valores[i];
					j++;
				}
			}
			minVal = minLimitado(valores, minVal);
		}
		for (int i=0; i<ordenado.length; i++) {
			System.out.println(ordenado[i]);
		}

	}

	public static void exercicio06() {
		int[] valores = new int[10];
		Scanner sc = new Scanner(System.in);
		for (int i=0; i<valores.length; i++) {
			System.out.print("informe valor: ");
			valores[i] = sc.nextInt();
		}
		sc.close();
		float media = soma(valores) / valores.length;
		for (int i=0; i<valores.length; i++) {
			if (valores[i]>media) {
				System.out.println(valores[i] + " está acima da média " + media);
			}
		}
	}

	public static void jogoDaVelha() {
		Scanner sc = new Scanner(System.in);
		char[][] status = {{' ',' ',' '} , {' ',' ',' '} , {' ',' ',' '}};
		char[] jogadores = {'X','O'};
		int x = 0;
		int y = 0;
		int jogador = 0;
		while (true) {
			imprimeStatus(status);
			while (true) {
				System.out.println("jogador " + (jogador+1) + ", indique posição x e y: ");
				x = sc.nextInt();
				y = sc.nextInt();
				if (testePosicao(status, x, y)) {
					status[x][y] = jogadores[jogador];
					break;
				} else {
					System.out.println("posição inválida.");
				}
			}
			if (testeJogador(status, jogadores[jogador])) {
				System.out.println("jogador " + (jogador+1) + " venceu");
				break;
			} else if (testeFim(status)) {
				System.out.println("fim do jogo (sem vencedor).");
				break;
			}
			jogador = (jogador+1) % 2; // alterna entre 0 e 1
//			imprimeStatus(status);
//			while (true) {
//				System.out.println("jogador 2, indique posição x e y: ");
//				x = sc.nextInt();
//				y = sc.nextInt();
//				if (testePosicao(status, x, y)) {
//					status[x][y] = jogadores[1];
//					break;
//				}
//			}
//			if (testeJogador(status, jogadores[1])) {
//				System.out.println("jogador 2 venceu");
//				break;
//			} else if (testeFim(status)) {
//				System.out.println("fim do jogo (sem vencedor).");
//				break;
//			}
		}
		sc.close();
		imprimeStatus(status);
	}

	public static boolean testePosicao(char[][] status, int i, int j) {
		if (status[i][j]==' ') { return true; } // posição válida/livre
		else {return false; }
	}

	public static boolean testeJogador(char[][] status, char jogador) {
		for(int i=0;i<=2;i++) {
			if (status[i][0]==jogador && status[i][1]==jogador && status[i][2]==jogador) { return true; }
			if (status[0][i]==jogador && status[1][i]==jogador && status[2][i]==jogador) { return true; }
			if (status[0][0]==jogador && status[1][1]==jogador && status[2][2]==jogador) { return true; }
			if (status[0][2]==jogador && status[1][1]==jogador && status[2][0]==jogador) { return true; }
		}
		return false;
	}

	public static boolean testeFim(char[][] status) {
		for(int i=0;i<=2;i++) {
			for(int j=0;j<=2;j++) {
				if (status[i][j]==' ') {
					return false;
				}
			}
		}
		return true;
	}

	public static void imprimeStatus(char[][] status) {
		for(int i=0;i<=2;i++) {
			System.out.println(" " + status[i][0] + " | " + status[i][1] + " | " + status[i][2]);
			if (i<2) {
				System.out.println("---+---+---");
			}
		}
	}
}

