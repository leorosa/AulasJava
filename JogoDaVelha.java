import java.util.Scanner;
import java.util.Random;

public class JogoDaVelha {

	public static char[][] tabuleiro = { {'⁰', '¹', '²'} , {'³', '⁴', '⁵'} , {'⁶', '⁷', '⁸'} }; // {'0', '1', '2'} , {'3', '4', '5'} , {'6', '7', '8'}};
	public static char[] simbolos = { 'X', 'O' }; // representação visual dos jogadores

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		Random gerador = new Random();
		int indiceJogador = 0;
		int automatico = 0; // indice do jogador automático (0 ou 1); ex. -1 desabilita
		imprimeTabuleiro();
		while (true) {
			System.out.print("jogador " + simbolos[indiceJogador] + ", entre com uma posição: ");
			while (true) {
				int pos;
// entrada de posições
				if (indiceJogador==automatico) {  // computador joga
//                  pos = gerador.nextInt(8);
                    pos = jogada(indiceJogador);
					System.out.println("");
				} else {  // jogador informa posição
					pos = sc.nextInt();
				}
// testa se posição é válida; se for, salvar posição; senão, pedir novamente
				if (testaPosicao(pos)) {
					int i = pos/3;
					int j = pos%3;
					tabuleiro[i][j] = simbolos[indiceJogador];
					break;
				} else {
					System.out.print("posição inválida; tente novamente: ");
				}
			}
			imprimeTabuleiro();
// testar se jogador venceu; se sim, encerrar o jogo
			if (testeVitoria(simbolos[indiceJogador])) {
				System.out.println("jogador " + simbolos[indiceJogador] + " venceu.");
				break; // sai do jogo
			}
// testar se ainda há posições livres; se não, encerrar o jogo
			if (tabuleiroCheio()) {
				System.out.println("fim do jogo, sem vencedores.");
				break;
			}
// trocar de jogador
//			if (jogador==0) { jogador = 1; } else { jogador = 0; }
//			indiceJogador = (indiceJogador==1)?0:1;
			indiceJogador = (indiceJogador+1)%2;	// 0->1 ; 1->0
		}
		sc.close();
	}

	public static void imprimeTabuleiro() {
		System.out.println("");
		for (int i=0; i<tabuleiro.length; i++) {
			System.out.println(" " + tabuleiro[i][0] + " │ " + tabuleiro[i][1] + " │ " + tabuleiro[i][2]);
			if (i==2) { break; }
			System.out.println("───┼───┼───");
		}
	}

	public static boolean testaPosicao(int pos) {
		if (pos<0 || pos>8) {
			return false;
		}
		int i = pos/3;
		int j = pos%3;
		if (tabuleiro[i][j]!=simbolos[0] && tabuleiro[i][j]!=simbolos[1]) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean testeVitoria(char simboloJogador) {
		for (int k=0; k<tabuleiro.length; k++) {
			if (tabuleiro[k][0]==simboloJogador && tabuleiro[k][1]==simboloJogador && tabuleiro[k][2]==simboloJogador) { return true; }
			if (tabuleiro[0][k]==simboloJogador && tabuleiro[1][k]==simboloJogador && tabuleiro[2][k]==simboloJogador) { return true; }
		}
		if (tabuleiro[0][0]==simboloJogador && tabuleiro[1][1]==simboloJogador && tabuleiro[2][2]==simboloJogador) { return true; }
		if (tabuleiro[0][2]==simboloJogador && tabuleiro[1][1]==simboloJogador && tabuleiro[2][0]==simboloJogador) { return true; }
		return false;
	}

	public static boolean tabuleiroCheio() {
		for (int i=0; i<tabuleiro.length; i++) {
			for (int j=0; j<tabuleiro.length; j++) {
				if (tabuleiro[i][j]!=simbolos[0] && tabuleiro[i][j]!=simbolos[1]) {
					return false;
				}
			}
		}
		return true;
	}

	public static int jogada(int indiceJogador) {
		int pos = 0;
		for (int i=0; i<tabuleiro.length; i++) {
			for (int j=0; j<tabuleiro.length; j++) {
				if (tabuleiro[i][j]!=simbolos[0] && tabuleiro[i][j]!=simbolos[1]) {
					char tempSimbolo = tabuleiro[i][j];
					tabuleiro[i][j] = simbolos[indiceJogador];
					pos = i*3+j;
					if (testeVitoria(simbolos[indiceJogador])) { // retornar posição vitoriosa
						tabuleiro[i][j] = ' ';
						return pos;
					}
					tabuleiro[i][j] = tempSimbolo;
				}
			}
		}
// senão, ocupar posições privilegiadas
		if (testaPosicao(4)) {        return 4; // centro
		} else if (testaPosicao(0)) { return 0; // cantos
		} else if (testaPosicao(2)) { return 2;
		} else if (testaPosicao(6)) { return 6;
		} else if (testaPosicao(8)) { return 8;
		}
		return pos; // senão, ocupar última posição livre
	}
}
