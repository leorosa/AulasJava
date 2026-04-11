// 2026-04-10 e 11

import java.util.Scanner;
import java.util.Random;

public class JogoDaVelha {

	public static Scanner sc = new Scanner(System.in);
	public static Random gerador = new Random();
	public static char[][] tabuleiro = { {'⁰', '¹', '²'} , {'³', '⁴', '⁵'} , {'⁶', '⁷', '⁸'} }; // {'0', '1', '2'} , {'3', '4', '5'} , {'6', '7', '8'}};
	public static char[] simbolos = { 'C', 'A', 'X', 'O' }; // representação visual dos jogadores; apenas os 2 primeiros são usados; 'C'=computador; 'A'=aleatório

	public static void main(String[] args) {
		int indiceJogador = 0;
		int pos = -1;
		String log = "";
		imprimeTabuleiro();
		while (true) {
			System.out.print("entre com uma posição para '" + simbolos[indiceJogador] + "': ");
			while (true) {
// entrada de posições
				if (simbolos[indiceJogador]=='C' || simbolos[indiceJogador]=='c') {  // computador joga
					pos = jogada(indiceJogador);
				} else if (simbolos[indiceJogador]=='A' || simbolos[indiceJogador]=='a') {  // jogada aleatória
					pos = gerador.nextInt(9);
				} else {                             // jogador informa posição
					pos = sc.nextInt();
				}
// testa se posição é válida; se for, salvar posição; senão, pedir novamente
				if (testePosicaoLivre(pos)) {
					int i = pos/3;
					int j = pos%3;
					tabuleiro[i][j] = simbolos[indiceJogador];
					break;
				} else {
					System.out.print("posição inválida; tente novamente: ");
				}
			}
			log += pos;
			imprimeTabuleiro();
// testar se jogador venceu; se sim, encerrar o jogo
			if (testeVitoria(pos, simbolos[indiceJogador])) {
				System.out.println("jogador " + simbolos[indiceJogador] + " venceu.");
				break; // sai do jogo
			}
// testar se ainda há posições livres; se não, encerrar o jogo
			if (tabuleiroCheio()) {
				System.out.println("fim do jogo, sem vencedores.");
				break;
			}
// trocar de jogador
			indiceJogador = (indiceJogador+1)%2;	// 0->1 ; 1->0
		}
		sc.close();
		System.out.println("(jogadas: " + log +")");
	}

	public static void imprimeTabuleiro() {
		System.out.println(""); // linha em branco para facilitar visualização do tabuleiro (e necessária para jogadas automáticas)
		for (int i=0; i<tabuleiro.length; i++) {
			System.out.println("         " + tabuleiro[i][0] + " │ " + tabuleiro[i][1] + " │ " + tabuleiro[i][2]);
			if (i==2) { break; }
			System.out.println("        ───┼───┼───");
		}
		System.out.println(""); // linha em branco para facilitar visualização do tabuleiro
	}

	public static boolean testePosicaoLivre(int pos) {
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

	public static boolean testeVitoria(int pos, char simboloJogador) { // testa apenas posição
		int i = pos/3;
		int j = pos%3;
		if (tabuleiro[i][(j+1)%3]==simboloJogador && tabuleiro[i][(j+2)%3]==simboloJogador) { return true; } // linha
		if (tabuleiro[(i+1)%3][j]==simboloJogador && tabuleiro[(i+2)%3][j]==simboloJogador) { return true; } // coluna
		if (pos%4==0) { // se posição está na diagonal principal
			if (tabuleiro[(i+1)%3][(j+1)%3]==simboloJogador && tabuleiro[(i+2)%3][(j+2)%3]==simboloJogador) { return true; } // 0,0 / 1,1 / 2,2 / 3(=0),3(=0)
		} else if (pos%2==0) { // senão, pode pertencer à diagonal secundária
			if (tabuleiro[(i+1)%3][(j+2)%3]==simboloJogador && tabuleiro[(i+2)%3][(j+4)%3]==simboloJogador) { return true; } // 0,2 / 1,4(=1) / 2,6(=3=0) / 3(=0),8(=5=2)
		}
		return false;
	}

	public static boolean tabuleiroCheio() {
		for (int pos=0; pos<9; pos++) {
			if (testePosicaoLivre(pos)) { // ainda há posições vagas
				return false;
			}
		}
		return true;
	}

	public static int jogada(int indiceJogador) {
		int pos = -1;
		int posVago = -1;
		int posDerrota = -1;
		int indiceOponente = (indiceJogador+1)%2;
// procurar posições para vencer (ou para não perder) o jogo
		for (pos=0; pos<9; pos++) {
			if (testePosicaoLivre(pos)) {
				posVago = pos;
				if (testeVitoria(pos, simbolos[indiceJogador])) { // retornar posição vitoriosa
					return pos;
				}
				if (testeVitoria(pos, simbolos[indiceOponente])) { // evitar derrota
					posDerrota = pos; // salvar posição mas continuar no laço para checar se ainda é possível vencer
				}
			}
		}
		if (posDerrota>=0) { return posDerrota; }
// senão, ocupar posições privilegiadas
		if (testePosicaoLivre(4)) { return 4; // centro
		} else { // cantos aleatórios (não é necessário...)
			int[] cantos = {0, 2, 6, 8};
			int canto = gerador.nextInt(4);
			for (int i=0; i<cantos.length; i++) {
				pos = cantos[(canto+i)%4];
				if (testePosicaoLivre(pos)) { // testar também se o canto oposto está livre (senão=oponente)
					if (testePosicaoLivre((18-pos)%10)) { // (18-0=18%10=8, 18-8=10%10=0 , 18-2=16%10=6, 18-6=12%10=2)
						return pos;
					}
				}
			}
		}
		return posVago; // senão, ocupar última posição livre
	}
}
