import java.util.Scanner;

public class JogoDaVelha {

	public static char[][] tabuleiro = { {' ', ' ', ' '} , {' ', ' ', ' '} , {' ', ' ', ' '} };
	public static char[][] posicoes = { {'⁰', '¹', '²'} , {'³', '⁴', '⁵'} , {'⁶', '⁷', '⁸'} };
	// {'0', '1', '2'} , {'3', '4', '5'} , {'6', '7', '8'}};
	public static char[] jogadores = { 'X', 'O' };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int indiceJogador = 0;
		imprimeTabuleiro();
		while (true) {
			System.out.print("entre com uma posição: ");
			while (true) {
// jogador entra com posição
				int pos = sc.nextInt();
// testa se posição é válida
// se for, salvar posição; senão, pedir novamente
				if (testaPosicao(pos, indiceJogador)) {
					break;
				} else {
					System.out.print("posição inválida; tente novamente: ");
				}
			}
			imprimeTabuleiro();
// testar se jogador venceu; se sim, encerrar o jogo
			if (testeVitoria(jogadores[indiceJogador])) {
				System.out.println("jogador " + jogadores[indiceJogador] + " venceu.");
				break; // sai do jogo
			}
// testar se ainda há posições livres; se não, encerrar o jogo
			if (tabuleiroCheio()) {
				System.out.println("fim do jogo, sem vencedores.");
				break;
			}
// trocar de jogador
//			if (jogador==0) { jogador = 1;
//			} else { 		 jogador = 0; }
			indiceJogador = (indiceJogador+1)%2;	// 0->1 ; 1->0
		}
		sc.close();
	}
	
	public static void imprimeTabuleiro() {
		System.out.println("");
		for (int i=0; i<tabuleiro.length; i++) {
			System.out.println(" " + tabuleiro[i][0] + posicoes[i][0] + "│ " + tabuleiro[i][1] + posicoes[i][1] + "│ " + tabuleiro[i][2] + posicoes[i][2]);
			if (i==2) { break; }
			System.out.println("───┼───┼───");
		}
	}

	public static boolean testaPosicao(int pos, int indiceJogador) {
		if (pos<0 || pos>8) {
			return false;
		}
		int x = pos%3;
		int y = pos/3;
		if (tabuleiro[y][x] != jogadores[0] && tabuleiro[y][x] != jogadores[1]) {
			tabuleiro[y][x] = jogadores[indiceJogador];
			posicoes[y][x] = ' ';
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean testeVitoria(char simboloJogador) {
		for (int i=0; i<tabuleiro.length; i++) {
			if (tabuleiro[i][0]==simboloJogador && tabuleiro[i][1]==simboloJogador && tabuleiro[i][2]==simboloJogador) { return true; }
			if (tabuleiro[0][i]==simboloJogador && tabuleiro[1][i]==simboloJogador && tabuleiro[2][i]==simboloJogador) { return true; }
		}
		if (tabuleiro[0][0]==simboloJogador && tabuleiro[1][1]==simboloJogador && tabuleiro[2][2]==simboloJogador) { return true; }
		if (tabuleiro[0][2]==simboloJogador && tabuleiro[1][1]==simboloJogador && tabuleiro[2][0]==simboloJogador) { return true; }
		return false;
	}

	public static boolean tabuleiroCheio() {
		for (int i=0; i<tabuleiro.length; i++) {
			for (int j=0; j<tabuleiro.length; j++) {
				if (tabuleiro[i][j] != jogadores[0] && tabuleiro[i][j] != jogadores[1]) {
					return false;
				}
			}
		}
		return true;
	}
}
