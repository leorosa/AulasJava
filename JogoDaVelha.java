// 2026-04-10 - 05-09

import java.util.Scanner;
import java.util.Random;

public class JogoDaVelha {

	public static int NGRID = 4;
	public static int MAXPOS = NGRID*NGRID;
	public static boolean HASCENTER = NGRID%2==0?false:true;
	public static int CENTER = ij2pos(NGRID/2+1,NGRID/2+1);
	public static float OFFSET = (float) (NGRID-1) / 2;
	public static boolean DEBUG = true;
	public static boolean MOVE = true;
	public static Scanner sc = new Scanner(System.in);
	public static Random gerador = new Random();
	public static char[][] tabuleiro = new char[NGRID][NGRID];
	public static char[] simbolos = { 'A', 'C', 'X', 'O' }; // representação visual dos jogadores; apenas os 2 primeiros são usados; 'C'=computador; 'A'=aleatório
	public static char[] simbolosVitoria = { '<', '>' };
	public static String logJogo = "";

	public static int idxI(int pos) { return pos%NGRID; }
	public static int idxJ(int pos) { return (pos/NGRID)%NGRID; }
	public static int ij2pos(int i, int j) { return NGRID*(j%NGRID)+i%NGRID; }
	public static boolean isCenter(int pos) { return HASCENTER?(pos==CENTER?true:false):false; }
	public static boolean isVertex(int pos) { return pos==0 || pos==NGRID-1 || pos==NGRID*(NGRID-1) || pos==NGRID*NGRID-1; }
	public static int flipH(int pos) { return ij2pos(NGRID-1-idxI(pos) , idxJ(pos)); }
	public static int flipV(int pos) { return ij2pos(idxI(pos) , NGRID-1-idxJ(pos)); }
	public static int shiftH(int pos) { return ij2pos(1+idxI(pos) , idxJ(pos)); }
	public static int shiftV(int pos) { return ij2pos(idxI(pos) , 1+idxJ(pos)); }
	public static int rotAW(int pos) { return ij2pos((int) (OFFSET-(idxJ(pos)-OFFSET)) , (int) (OFFSET+(idxI(pos)-OFFSET))); }
	public static int rotCW(int pos) { return ij2pos((int) (OFFSET+(idxJ(pos)-OFFSET)), (int) (OFFSET-(idxI(pos)-OFFSET))); }

	public static void main(String[] args) {
		int indiceJogador = 0;
		int pos = -1;
		char status = '=';
		String replay = "";
		for (int j=0; j<NGRID; j++)
			for (int i=0; i<NGRID; i++)
				tabuleiro[j][i] = ' ';
		if (args.length>0 && args[0].length()>1) {
			simbolos[0] = args[0].charAt(0);
			simbolos[1] = args[0].charAt(1);
			replay = args[0].substring(3);
		}
		imprimeTabuleiro();
		while (true) {
			System.out.print("entre com uma posição para '" + simbolos[indiceJogador] + "': ");
			while (true) {
// entrada de posições
				if (logJogo.length()<replay.length()) { // posição pré-registrada
					pos = replay.charAt(logJogo.length())-'0';
					System.out.println(pos);
				} else if (simbolos[indiceJogador]=='C' || simbolos[indiceJogador]=='c') { // computador informa posição
					pos = jogada(indiceJogador);
					System.out.println(pos);
				} else if (simbolos[indiceJogador]=='A' || simbolos[indiceJogador]=='a') { // posição aleatória
					pos = gerador.nextInt(MAXPOS);
					System.out.println(pos);
				} else {                             // jogador informa posição
					pos = sc.nextInt();
				}
// testa se posição é válida; se for, salvar posição; senão, pedir novamente
				if (testePosicaoLivre(pos)) {
					int i = idxI(pos);
					int j = idxJ(pos);
					tabuleiro[j][i] = simbolos[indiceJogador];
					break;
				} else {
					System.out.print("posição inválida; tente novamente: ");
					replay = ""; // prosseguir com jogo normal
				}
			}
			logJogo += (char) ('0' + pos);
			imprimeTabuleiro();
// testar se jogador venceu; se sim, encerrar o jogo
			if (testeVitoria(pos, simbolos[indiceJogador])) {
				System.out.println("jogador " + simbolos[indiceJogador] + " venceu em " + (logJogo.length()-logJogo.length()/2) + " lances.");
				status = simbolosVitoria[indiceJogador];
				break; // sai do jogo
			}
// testar se ainda há posições livres; se não, encerrar o jogo
//			if (tabuleiroCheio()) {
			if (logJogo.length()>=MAXPOS) {
				System.out.println("fim do jogo, sem vencedores.");
				break;
			}
// mover tabuleiro // e checar vitória novamente SE aplicar shiftV ou shiftH
			if (MOVE) {
				pos = moveTabuleiro(pos);
				imprimeTabuleiro();
			}
// trocar de jogador
			indiceJogador = (indiceJogador+1)%2;	// 0->1 ; 1->0
		}
		sc.close();
		System.out.println("" + simbolos[0] + simbolos[1] + status + logJogo);
	}

	public static void imprimeTabuleiro() {
		System.out.println(""); // linha em branco para facilitar visualização do tabuleiro
		for (int j=0; j<NGRID; j++) {
			System.out.print("         ");
			for (int i=0; i<NGRID; i++) {
				if (tabuleiro[j][i]!=' ') System.out.print("  " + tabuleiro[j][i] + " ");
				else System.out.printf("%3d ", ij2pos(i,j));
				if (i<NGRID-1)
					System.out.print("│");
			}
			System.out.print("\n         ");
			if (j==NGRID-1) { break; }
			for (int i=0; i<NGRID; i++) {
				System.out.print("────");
				if (i<NGRID-1)
					System.out.printf("┼");
			}
			System.out.println("");
		}
		System.out.println(""); // linha em branco para facilitar visualização do tabuleiro
	}

	public static boolean testePosicaoLivre(int pos) {
		if (pos<0 || pos>=MAXPOS)
			return false;
		int i = idxI(pos);
		int j = idxJ(pos);
		if (tabuleiro[j][i]==' ')
			return true;
		else
			return false;
	}

	public static boolean testeVitoria(int pos, char simboloJogador) { // testa apenas posição
		int i = idxI(pos);
		int j = idxJ(pos);
		boolean vitoriaL = true;
		boolean vitoriaC = true;
		boolean vitoriaP = false;
		boolean vitoriaS = false;
		if (i==j)
			vitoriaP = true;
		if ((i+j)==(NGRID-1))
			vitoriaS = true;
		for (int k=1; k<NGRID; k++) {
			if (tabuleiro[j][(i+k)%NGRID]!=simboloJogador) { vitoriaL = false; } // linha
			if (tabuleiro[(j+k)%NGRID][i]!=simboloJogador) { vitoriaC = false; } // coluna
			if (vitoriaP && tabuleiro[(j+k)%NGRID][(i+k)%NGRID]!=simboloJogador) { vitoriaP = false; }
			if (vitoriaS && tabuleiro[(j+k)%NGRID][(NGRID+i-k)%NGRID]!=simboloJogador) { vitoriaS = false; }
		}
		return vitoriaL || vitoriaC || vitoriaP || vitoriaS;
	}

	public static int jogada(int indiceJogador) {
		int pos = -1;
		int posVago = -1;
		char simboloJogador = simbolos[indiceJogador];
		char simboloOponente = simbolos[(indiceJogador+1)%2];
		int valorPos = -1;
		int valorMax = -1;
// procurar posições para vencer (ou para não perder) o jogo; salvar melhor posição livre
		for (pos=0; pos<MAXPOS; pos++) {
			valorPos = -2;
			if (testePosicaoLivre(pos)) {
				valorPos = 0;
				if (testeVitoria(pos, simboloJogador)) { // retornar posição vitoriosa imediatamente
					return pos;
				} else if (testeVitoria(pos, simboloOponente)) { // evitar derrota
					valorPos = 18;
				} else if (testeGancho(pos, simboloOponente)) {
					valorPos = 16;
				} else if (testeGancho(pos, simboloJogador)) {
					valorPos = 14;
				} else if (testeGanchoFuturo(pos, simboloJogador)) {
					valorPos = 12;
				} else if (testeGanchoFuturo(pos, simboloOponente)) {
					valorPos = 10;
				} else if (isCenter(pos)) {
					valorPos = 8;
				} else if (testeGancho(pos, ' ')) { // priorizar linha/coluna/diagonal livre 
					valorPos = 4;
					if (isVertex(pos)) valorPos += 2;
				} else if (isVertex(pos)) {
					valorPos = 2;
				}
				if (valorPos>valorMax) { // no mesmo loop, como apresentado em aula
					valorMax = valorPos - gerador.nextInt(2); // toque de aleatoriedade...
					posVago = pos; // posição com maior número de possibilidades de vitória
				}
			}
		}
		if (DEBUG) {
			if (valorMax>16)
				System.out.print("[evitar derrota] ");
			else if (valorMax>14)
				System.out.print("[evitar gancho] ");
			else if (valorMax>12)
				System.out.print("[criar gancho] ");
			else if (valorMax>10)
				System.out.print("[criar gancho futuro] ");
			else if (valorMax>8)
				System.out.print("[evitar gancho futuro] ");
			else if (valorMax>6)
				System.out.print("[centro] ");
			else if (valorMax>4)
				System.out.print("[canto em l/c/d livre] ");
			else if (valorMax>2)
				System.out.print("[l/c/d livre] ");
			else if (valorMax>0)
				System.out.print("[vértice] ");
			else System.out.printf("[%d] ", valorMax);
		}
		return posVago; // senão, ocupar melhor posição livre
	}

	public static boolean testeGancho(int pos, char simboloJogador) {
		int i = idxI(pos);
		int j = idxJ(pos);
		int gancho = 0;
		char curSimbolo = tabuleiro[j][i];
		tabuleiro[j][i] = simboloJogador;
		for (int pos2=0; pos2<MAXPOS; pos2++) {
			if (testePosicaoLivre(pos2)) {
				if (testeVitoria(pos2, simboloJogador)) {
					gancho++;
				}
			}
		}
		tabuleiro[j][i] = curSimbolo;
		return gancho>1?true:false;
	}

	public static boolean testeGanchoFuturo(int pos, char simboloJogador) {
		int i = idxI(pos);
		int j = idxJ(pos);
		int gancho = 0;
		char curSimbolo = tabuleiro[j][i];
		tabuleiro[j][i] = simboloJogador;
		for (int pos2=0; pos2<MAXPOS; pos2++) {
			if (testePosicaoLivre(pos2)) {
				if (testeGancho(pos2, simboloJogador)) {
					gancho++;
					break;
				}
			}
		}
		tabuleiro[j][i] = curSimbolo;
		return gancho>1?true:false;
	}

	public static int move(int pos, int opcao) {
		if (opcao==1) {
			if (pos==0 && DEBUG) System.out.print("[flipH] ");
			return flipH(pos);
		} else if (opcao==2) {
			if (pos==0 && DEBUG) System.out.print("[flipV] ");
			return flipV(pos);
		} else if (opcao==3) {
			if (pos==0 && DEBUG) System.out.print("[rotAW] ");
			return rotAW(pos);
		} else if (opcao==4) {
			if (pos==0 && DEBUG) System.out.print("[rotCW] ");
			return rotCW(pos);
		} else if (opcao==5) {
			if (pos==0 && DEBUG) System.out.print("[shiftH] ");
			return shiftH(pos);
		} else if (opcao==6) {
			if (pos==0 && DEBUG) System.out.print("[shiftV] ");
			return shiftV(pos);
		}
		return pos;
	}

	public static int moveTabuleiro(int curPos) {
		int opcao = gerador.nextInt(5); // 0 = sem alterar tabuleiro; evitar 'shift', que torna vitórias imprevisíveis...
		if (opcao==0) return curPos;
		char[][] novoTabuleiro = new char[NGRID][NGRID];
		int movedPos = -1;
		for (int j=0; j<NGRID; j++)
			for (int i=0; i<NGRID; i++) {
				int pos = ij2pos(i,j);
				int novoPos = 0;
				novoPos = move(pos, opcao);
				int ni = idxI(novoPos);
				int nj = idxJ(novoPos);
				novoTabuleiro[nj][ni] = tabuleiro[j][i];
				if (pos==curPos) movedPos = novoPos;
			}
		for (int j=0; j<NGRID; j++)
			for (int i=0; i<NGRID; i++)
				tabuleiro[j][i] = novoTabuleiro[j][i];
		for (int k=0; k<logJogo.length(); k++) {
			int pos = logJogo.charAt(k) - '0';
			logJogo = logJogo.substring(0,k)+((char) ('0'+move(pos,opcao)))+logJogo.substring(k+1);
		}
		return movedPos;
	}

}
