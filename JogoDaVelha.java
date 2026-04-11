import java.util.Scanner;
import java.util.Random;

public class JogoDaVelha {

	public static Scanner sc = new Scanner(System.in);
	public static Random gerador = new Random();
	public static char[][] tabuleiro = { {'⁰', '¹', '²'} , {'³', '⁴', '⁵'} , {'⁶', '⁷', '⁸'} }; // {'0', '1', '2'} , {'3', '4', '5'} , {'6', '7', '8'}};
	public static char[] simbolos = { 'C', 'H', 'X', 'O' }; // representação visual dos jogadores; apenas os 2 primeiros são usados; 'C'=computador

	public static void main(String[] args) {
		int indiceJogador = 0;
		imprimeTabuleiro();
		while (true) {
			System.out.print("entre com uma posição para " + simbolos[indiceJogador] + ": ");
			while (true) {
				int pos;
// entrada de posições
				if (simbolos[indiceJogador]=='C') { // computador joga
//					pos = gerador.nextInt(8);
					pos = jogada(indiceJogador);
					System.out.println("");
				} else {                            // jogador informa posição
					pos = sc.nextInt();
				}
// testa se posição é válida; se for, salvar posição; senão, pedir novamente
				if (testePosicao(pos)) {
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

	public static boolean testePosicao(int pos) {
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
		for (int pos=0; pos<9; pos++) {
			if (testePosicao(pos)) { // ainda há posições vagas
				return false;
			}
		}
		return true;
	}

	public static int jogada(int indiceJogador) {
		int posVago = 0;
		int posDerrota = -1;
// procurar posições para vencer (ou para não perder) o jogo
		for (int pos=0; pos<9; pos++) {
			if (testePosicao(pos)) {
				posVago = pos;
				int i = pos/3;
				int j = pos%3;
				char tempSimbolo = tabuleiro[i][j];
				tabuleiro[i][j] = simbolos[indiceJogador];
				if (testeVitoria(simbolos[indiceJogador])) { // retornar posição vitoriosa
					tabuleiro[i][j] = ' '; // desocupar posição
					return pos;
				}
				indiceJogador = (indiceJogador+1)%2; // testar posição inimiga
				tabuleiro[i][j] = simbolos[indiceJogador];
				if (testeVitoria(simbolos[indiceJogador])) { // evitar derrota
					posDerrota = pos; // salvar posição mas continuar no laço para checar se ainda é possível vencer
				}
				tabuleiro[i][j] = tempSimbolo; // desocupar posição
			}
		}
		if (posDerrota>=0) { return posDerrota; }
// senão, ocupar posições privilegiadas
		if (testePosicao(4)) {
			return 4; // centro
		} else {      // cantos aleatórios
			int[] cantos = {0, 2, 6, 8};
			int canto = gerador.nextInt(3);
			for (int i=0; i<cantos.length; i++) {
				if (testePosicao(cantos[(canto+i)%4])) {
					return cantos[(canto+i)%4];
				}
			}
		}
		return posVago; // senão, ocupar última posição livre
	}
}
