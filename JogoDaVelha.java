import java.util.Scanner;

public class JogoDaVelha {
    public static char[][] status = {{'¹','²','³'} , {'⁴','⁵','⁶'} , {'⁷','⁸','⁹'}};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] jogadores = {'X','O'};
		int pos = 0;
		int x = 0;
		int y = 0;
		int jogador = 0;
		imprimeStatus();
		while (true) {
			while (true) {
				System.out.println(jogadores[jogador] + ", indique posição: ");
				pos = sc.nextInt() - 1; // 1a. posição = 0
				x = pos/3;
				y = pos%3;
				if (testePosicao(x, y)) {
					status[x][y] = jogadores[jogador];
					break;
				} else {
					System.out.println("posição inválida.");
				}
			}
			imprimeStatus();
			if (testeJogador(jogadores[jogador])) {
				System.out.println(jogadores[jogador] + " venceu");
				break;
			} else if (testeFim()) {
				System.out.println("fim do jogo (sem vencedor).");
				break;
			}
			jogador = (jogador+1) % 2; // alterna entre 0 e 1
		}
		sc.close();
	}

	public static boolean testePosicao(int i, int j) {
		if (0<=i && i<=2 && 0<=j && j<=2 && status[i][j]!='X' && status[i][j]!='O') {
			return true;  // posição válida/livre
		}
		else { return false; }
	}

	public static boolean testeJogador(char jogador) {
		for(int i=0;i<=2;i++) {
			if (status[i][0]==jogador && status[i][1]==jogador && status[i][2]==jogador) { return true; }
			if (status[0][i]==jogador && status[1][i]==jogador && status[2][i]==jogador) { return true; }
		}
		if (status[0][0]==jogador && status[1][1]==jogador && status[2][2]==jogador) { return true; }
		if (status[0][2]==jogador && status[1][1]==jogador && status[2][0]==jogador) { return true; }
		return false;
	}

	public static boolean testeFim() {
		for(int i=0;i<=2;i++) {
			for(int j=0;j<=2;j++) {
				if (status[i][j]!='X' && status[i][j]!='O') {
					return false;
				}
			}
		}
		return true;
	}

	public static void imprimeStatus() {
		System.out.print("\033[H\033[2J");	// clear console
		System.out.flush();
		for(int i=0;i<=2;i++) {
			System.out.println(" " + status[i][0] + " | " + status[i][1] + " | " + status[i][2]);
			if (i<2) {
				System.out.println("---+---+---");
			}
		}
	}
}
