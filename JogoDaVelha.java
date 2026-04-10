import java.util.Scanner;

public class JogoDaVelha {
	public static char[][] status = {{' ',' ',' '} , {' ',' ',' '} , {' ',' ',' '}};
	public static char[][] rotulos = {{'¹','²','³'} , {'⁴','⁵','⁶'} , {'⁷','⁸','⁹'}};
	public static char[] jogadores = {'X','O'};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int pos = 0;
		int jogador = 0;
		imprimeStatus();
		while (true) {
			while (true) {
				System.out.println(jogadores[jogador] + ", indique posição: ");
				pos = sc.nextInt() - 1; // 1a. posição = 0
				if (testePosicao(pos, jogador)) {
					break;
				} else {
					System.out.println("posição inválida.");
				}
			}
			imprimeStatus();
			if (testeJogador(jogador)) {
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

	public static boolean testePosicao(int pos, int jogador) {
		int x = pos/3;
		int y = pos%3;
		if (0<=pos && pos<=9 && status[x][y]!=jogadores[0] && status[x][y]!=jogadores[1]) {
			status[x][y] = jogadores[jogador];
			rotulos[x][y] = ' ';
			return true; // posição válida/livre
		} else { return false; }
	}

	public static boolean testeJogador(int jogador) {
	    char jog = jogadores[jogador];
		for(int i=0;i<=2;i++) {
			if (status[i][0]==jog && status[i][1]==jog && status[i][2]==jog) { return true; }
			if (status[0][i]==jog && status[1][i]==jog && status[2][i]==jog) { return true; }
		}
		if (status[0][0]==jog && status[1][1]==jog && status[2][2]==jog) { return true; }
		if (status[0][2]==jog && status[1][1]==jog && status[2][0]==jog) { return true; }
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
			System.out.println(" " + status[i][0] + rotulos[i][0] + "| " + status[i][1] + rotulos[i][1] + "| " + status[i][2] + rotulos[i][2]);
			if (i<2) {
				System.out.println("---+---+---");
			}
		}
	}
}
