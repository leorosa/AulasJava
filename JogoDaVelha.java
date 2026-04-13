// 2026-04-10 e 11

import java.util.Scanner;
import java.util.Random;

public class JogoDaVelha {

	public static Scanner sc = new Scanner(System.in);
	public static Random gerador = new Random();
	public static char[][] tabuleiro = { {'⁰', '¹', '²'} , {'³', '⁴', '⁵'} , {'⁶', '⁷', '⁸'} }; // '⁹'
	public static char[] simbolos = { 'A', 'C', 'X', 'O' }; // representação visual dos jogadores; apenas os 2 primeiros são usados; 'C'=computador; 'A'=aleatório
	public static String log = "";

	public static void main(String[] args) {
		int indiceJogador = 0;
		int pos = -1;
		imprimeTabuleiro();
		while (true) {
			System.out.print("entre com uma posição para '" + simbolos[indiceJogador] + "': ");
			while (true) {
// entrada de posições
				if (simbolos[indiceJogador]=='C' || simbolos[indiceJogador]=='c') {  // computador informa posição
					pos = jogada(indiceJogador);
				} else if (simbolos[indiceJogador]=='A' || simbolos[indiceJogador]=='a') {  // posição aleatória
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
//			if (tabuleiroCheio()) {
			if (log.length()==9) {
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
		}
		if (pos==2 || pos==4 || pos==6) { // diagonal secundária
			if (tabuleiro[(i+1)%3][(j+2)%3]==simboloJogador && tabuleiro[(i+2)%3][(j+4)%3]==simboloJogador) { return true; } // 0,2 / 1,4(=1) / 2,6(=3=0) / 3(=0),8(=5=2)
		}
		return false;
	}

//	public static boolean tabuleiroCheio() {
//		for (int pos=0; pos<9; pos++) {
//			if (testePosicaoLivre(pos)) { // ainda há posições vagas
//				return false;
//			}
//		}
//		return true;
//	}

	public static int jogada(int indiceJogador) {
		int pos = -1;
		int posVago = -1;
		int posDerrota = -1;
		char simboloJogador = simbolos[indiceJogador];
		char simboloOponente = simbolos[(indiceJogador+1)%2];
		int valorPos = -1;
		int valorMax = -1;
// procurar posições para vencer (ou para não perder) o jogo; salvar melhor posição livre
		for (pos=0; pos<9; pos++) {
			if (testePosicaoLivre(pos)) {
				if (testeVitoria(pos, simboloJogador)) { // retornar posição vitoriosa imediatamente
					return pos;
				}
				if (testeVitoria(pos, simboloOponente)) { // evitar derrota
					posDerrota = pos; // salvar posição mas continuar no laço para checar se ainda é possível vencer
				}
				if (simboloJogador=='C') {
					valorPos = valorPosicao1(pos, simboloJogador, simboloOponente);
				} else {
					valorPos = valorPosicao0(pos);
				}
				if (valorPos>valorMax) { // no mesmo loop, como apresentado em aula
					valorMax = valorPos - gerador.nextInt(2); // toque de aleatoriedade...
					posVago = pos; // posição com maior número de possibilidades de vitória
				}
			}
		}
		if (posDerrota>=0) { return posDerrota; } // evitar derrota
		return posVago; // senão, ocupar melhor posição livre
	}

	public static int valorPosicao0(int pos) {
		if (pos==4) { return 3; } // centro
		if (pos%2==0) { // cantos
			if (testePosicaoLivre((18-pos)%10)) { return 2; } // dar mais peso a canto com oposto vago -- oposto: 18-0=18%10=8, 18-8=10%10=0 , 18-2=16%10=6, 18-6=12%10=2
			return 1;
		}
		return 0;
	}

	public static int valorPosicao1(int pos, char simboloJogador, char simboloOponente) { // heurística para dar peso a posições no tabuleiro p/ favorecer vitória
		int i = pos/3;
		int j = pos%3;
		int valorPos = 0;
		if (tabuleiro[i][(j+1)%3]!=simboloOponente && tabuleiro[i][(j+2)%3]!=simboloOponente) { // linha
			valorPos+=1; 
			if (pos%2==0) { valorPos+=1; } // priorizar centro e cantos em linha livre
			if (pos==0&& tabuleiro[2][2]==simboloOponente) { valorPos-=1; } // descontar cantos com opostos ocupados pelo oponente
			if (pos==2&& tabuleiro[2][0]==simboloOponente) { valorPos-=1; }
			if (pos==6&& tabuleiro[0][2]==simboloOponente) { valorPos-=1; }
			if (pos==8&& tabuleiro[0][0]==simboloOponente) { valorPos-=1; }
		}
		if (tabuleiro[(i+1)%3][j]!=simboloOponente && tabuleiro[(i+2)%3][j]!=simboloOponente) { // coluna
			valorPos+=1;
			if (pos%2==0) { valorPos+=1; } // priorizar centro e cantos em coluna livre
			if (pos==0&& tabuleiro[2][2]==simboloOponente) { valorPos-=1; }
			if (pos==2&& tabuleiro[2][0]==simboloOponente) { valorPos-=1; }
			if (pos==6&& tabuleiro[0][2]==simboloOponente) { valorPos-=1; }
			if (pos==8&& tabuleiro[0][0]==simboloOponente) { valorPos-=1; }
		}
		if (pos%4==0) { // se posição está na diagonal principal
			if (tabuleiro[(i+1)%3][(j+1)%3]!=simboloOponente && tabuleiro[(i+2)%3][(j+2)%3]!=simboloOponente) { valorPos+=1; }
		}
		if (pos==2 || pos==4 || pos==6) { // diagonal secundária
			if (tabuleiro[(i+1)%3][(j+2)%3]!=simboloOponente && tabuleiro[(i+2)%3][(j+4)%3]!=simboloOponente) { valorPos+=1; }
		}
		return valorPos;
	}
}
