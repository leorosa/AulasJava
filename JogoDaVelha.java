// 2026-04-10 - 05-09

import java.util.Scanner;
import java.util.Random;

public class JogoDaVelha {

	public static int NGRID = 3;
	public static int ZGRID = 4;
	public static int MAXPOS = NGRID*NGRID*ZGRID;
	public static boolean HASCENTER = NGRID%2==0?false:true;
	public static int CENTER = ijk2pos(NGRID/2+1,NGRID/2+1,ZGRID/2+1);
	public static float OFFSET = (float) (NGRID-1) / 2;
	public static boolean DEBUG = true;
	public static boolean MOVE = false;
	public static int vitoriaI = 1; // linha
	public static int vitoriaJ = 2; // coluna
	public static int vitoriaK = 4; // altura
	public static int vitoriaIJP = 8; // diagonal principal no plano IJ
	public static int vitoriaIJS = 16; // diagonal secundária no plano IJ
	public static int vitoriaIKP = 32; // diagonal principal no plano IK
	public static int vitoriaIKS = 64; // diagonal secundária no plano IK
	public static int vitoriaJKP = 128; // diagonal principal no plano JK
	public static int vitoriaJKS = 256; // diagonal secundária no plano JK
	public static int vitoriaA = 512; // diagonal +k+j+i
	public static int vitoriaB = 1024; // diagonal +k-j+i
	public static int vitoriaC = 2048; // diagonal +k-j-i
	public static int vitoriaD = 4096; // diagonal +k+j-i

	public static Scanner sc = new Scanner(System.in);
	public static Random gerador = new Random();
	public static char[][][] tabuleiro = new char[ZGRID][NGRID][NGRID];
	public static char[] simbolos = { 'A', 'C', 'X', 'O' }; // representação visual dos jogadores; apenas os 2 primeiros são usados; 'C'=computador; 'A'=aleatório
	public static char[] simbolosVitoria = { '<', '>' };
	public static String logJogo = "";

	public static int idxI(int pos) { return pos%NGRID; }
	public static int idxJ(int pos) { return (pos/NGRID)%NGRID; }
	public static int idxK(int pos) { return (pos/NGRID/NGRID)%ZGRID; }
	public static int ijk2pos(int i, int j, int k) { return NGRID*NGRID*(k%ZGRID) + NGRID*(j%NGRID) + i%NGRID; }
	public static boolean isCenter(int pos) { return HASCENTER?(pos==CENTER?true:false):false; }
	public static boolean isVertex(int pos) { return pos==0 || pos==NGRID-1 || pos==NGRID*(NGRID-1) || pos==NGRID*NGRID-1; }
	public static int flipH(int pos) { return ijk2pos(NGRID-1-idxI(pos) , idxJ(pos) , idxK(pos)); }
	public static int flipV(int pos) { return ijk2pos(idxI(pos) , NGRID-1-idxJ(pos) , idxK(pos)); }
	public static int shiftH(int pos) { return ijk2pos(1+idxI(pos) , idxJ(pos) , idxK(pos)); }
	public static int shiftV(int pos) { return ijk2pos(idxI(pos) , 1+idxJ(pos) , idxK(pos)); }
	public static int rotAW(int pos) { return ijk2pos((int) (OFFSET-(idxJ(pos)-OFFSET)) , (int) (OFFSET+(idxI(pos)-OFFSET)) , idxK(pos)); }
	public static int rotCW(int pos) { return ijk2pos((int) (OFFSET+(idxJ(pos)-OFFSET)), (int) (OFFSET-(idxI(pos)-OFFSET)) , idxK(pos)); }

	public static void main(String[] args) {
		int indiceJogador = 0;
		int pos = -1;
		char status = '=';
		String replay = "";
		for (int k=0; k<ZGRID; k++)
			for (int j=0; j<NGRID; j++)
				for (int i=0; i<NGRID; i++)
					tabuleiro[k][j][i] = ' ';
		if (args.length>0 && args[0].length()>1) {
			simbolos[0] = args[0].charAt(0);
			simbolos[1] = args[0].charAt(1);
			replay = args[0].substring(5);
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
					int k = idxK(pos);
					tabuleiro[k][j][i] = simbolos[indiceJogador];
					break;
				} else {
					System.out.print("posição inválida; tente novamente: ");
					replay = ""; // prosseguir com jogo normal
				}
			}
			logJogo += (char) ('0' + pos);
			imprimeTabuleiro();
// testar se jogador venceu; se sim, encerrar o jogo
			if (testeVitoria(pos, simbolos[indiceJogador])>0) {
				mostraVitoria(pos, simbolos[indiceJogador]);
				imprimeTabuleiro();
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
		System.out.println("" + simbolos[0] + simbolos[1] + status + NGRID + ZGRID + logJogo);
	}

	public static void imprimeTabuleiro() {
		System.out.println(""); // linha em branco para facilitar visualização do tabuleiro
		for (int j=0; j<NGRID; j++) {
			for (int k=0; k<ZGRID; k++) {
				System.out.print("         ");
				for (int i=0; i<NGRID; i++) {
					if (tabuleiro[k][j][i]!=' ') System.out.print("  " + tabuleiro[k][j][i] + " ");
					else System.out.printf("%3d ", ijk2pos(i,j,k));
					if (i<NGRID-1)
						System.out.print("│");
				}
				if (k==ZGRID-1) System.out.println("");
			}
			if (j==NGRID-1) { break; }
			for (int k=0; k<ZGRID; k++) {
				System.out.print("         ");
				for (int i=0; i<NGRID; i++) {
					System.out.print("────");
					if (i<NGRID-1)
						System.out.printf("┼");
				}
				if (k==ZGRID-1) System.out.println("");
			}
		}
		System.out.println(""); // linha em branco para facilitar visualização do tabuleiro
	}

	public static boolean testePosicaoLivre(int pos) {
		if (pos<0 || pos>=MAXPOS)
			return false;
		int i = idxI(pos);
		int j = idxJ(pos);
		int k = idxK(pos);
		if (tabuleiro[k][j][i]==' ')
			return true;
		else
			return false;
	}

	public static int testeVitoria(int pos, char simboloJogador) { // testa apenas posição
		int i = idxI(pos);
		int j = idxJ(pos);
		int k = idxK(pos);
		int vitoria = vitoriaI + vitoriaJ;
		if (ZGRID>1) vitoria += vitoriaK;
		if (ZGRID==NGRID) {
			if (i==k) vitoria += vitoriaIKP;
			if (i==NGRID-1-k) vitoria += vitoriaIKS;
			if (j==k) vitoria += vitoriaJKP;
			if (j==NGRID-1-k) vitoria += vitoriaJKS;
		}
		if (i==j) {
			vitoria += vitoriaIJP;
			if (ZGRID==NGRID) {
				if (i==k) vitoria += vitoriaA;
				if (i==NGRID-1-k) vitoria += vitoriaC;
			}
		}
		if (i==NGRID-1-j) {
			vitoria += vitoriaIJS;
			if (ZGRID==NGRID) {
				if (i==k) vitoria += vitoriaB;
				if (i==NGRID-1-k) vitoria += vitoriaD;
			}
		}
		for (int n=1; n<ZGRID; n++)
			if ((vitoria&vitoriaK)>0 && tabuleiro[(k+n)%ZGRID][j][i]!=simboloJogador) { vitoria -= vitoriaK; } // altura
		for (int n=1; n<NGRID; n++) {
			if ((vitoria&vitoriaI)>0 && tabuleiro[k][j][(i+n)%NGRID]!=simboloJogador) { vitoria -= vitoriaI; } // linha
			if ((vitoria&vitoriaJ)>0 && tabuleiro[k][(j+n)%NGRID][i]!=simboloJogador) { vitoria -= vitoriaJ; } // coluna
			if ((vitoria&vitoriaIJP)>0 && tabuleiro[k][(j+n)%NGRID][(i+n)%NGRID]!=simboloJogador) { vitoria -= vitoriaIJP; }
			if ((vitoria&vitoriaIJS)>0 && tabuleiro[k][(j+n)%NGRID][(NGRID+i-n)%NGRID]!=simboloJogador) { vitoria -= vitoriaIJS; }
			if ((vitoria&vitoriaIKP)>0 && tabuleiro[(k+n)%NGRID][j][(i+n)%NGRID]!=simboloJogador) { vitoria -= vitoriaIKP; }
			if ((vitoria&vitoriaIKS)>0 && tabuleiro[(k+n)%NGRID][j][(NGRID+i-n)%NGRID]!=simboloJogador) { vitoria -= vitoriaIKS; }
			if ((vitoria&vitoriaJKP)>0 && tabuleiro[(k+n)%NGRID][(j+n)%NGRID][i]!=simboloJogador) { vitoria -= vitoriaJKP; }
			if ((vitoria&vitoriaJKS)>0 && tabuleiro[(k+n)%NGRID][(NGRID+j-n)%NGRID][i]!=simboloJogador) { vitoria -= vitoriaJKS; }
			if ((vitoria&vitoriaA)>0 && tabuleiro[(k+n)%NGRID][(j+n)%NGRID][(i+n)%NGRID]!=simboloJogador) { vitoria -= vitoriaA; }
			if ((vitoria&vitoriaB)>0 && tabuleiro[(k+n)%NGRID][(NGRID+j-n)%NGRID][(i+n)%NGRID]!=simboloJogador) { vitoria -= vitoriaB; }
			if ((vitoria&vitoriaC)>0 && tabuleiro[(k+n)%NGRID][(NGRID+j-n)%NGRID][(NGRID+i-n)%NGRID]!=simboloJogador) { vitoria -= vitoriaC; }
			if ((vitoria&vitoriaD)>0 && tabuleiro[(k+n)%NGRID][(j+n)%NGRID][(NGRID+i-n)%NGRID]!=simboloJogador) { vitoria -= vitoriaD; }
		}
		return vitoria;
	}

	public static void mostraVitoria(int pos, char simboloJogador) {
		int i = idxI(pos);
		int j = idxJ(pos);
		int k = idxK(pos);
		int vitoria = testeVitoria(pos, simboloJogador);
		for (int kk=0; kk<ZGRID; kk++)
			for (int jj=0; jj<NGRID; jj++)
				for (int ii=0; ii<NGRID; ii++)
					tabuleiro[kk][jj][ii] = '.';  // NBSP gera erro
		if ((vitoria&vitoriaI) > 0)
			for (int n=0; n<NGRID; n++)
				tabuleiro[k][j][(i+n)%NGRID] = simboloJogador;
		if ((vitoria&vitoriaJ) > 0)
			for (int n=0; n<NGRID; n++)
				tabuleiro[k][(j+n)%NGRID][i] = simboloJogador;
		if ((vitoria&vitoriaK) > 0)
			for (int n=0; n<ZGRID; n++)
				tabuleiro[(k+n)%NGRID][j][i] = simboloJogador;
		if ((vitoria&vitoriaIJP) > 0)
			for (int n=0; n<NGRID; n++)
				tabuleiro[k][(j+n)%NGRID][(i+n)%NGRID] = simboloJogador;
		if ((vitoria&vitoriaIJS) > 0)
			for (int n=0; n<NGRID; n++)
				tabuleiro[k][(j+n)%NGRID][(NGRID+i-n)%NGRID] = simboloJogador;
		if ((vitoria&vitoriaIKP) > 0)
			for (int n=0; n<NGRID; n++)
				tabuleiro[(k+n)%NGRID][j][(i+n)%NGRID] = simboloJogador;
		if ((vitoria&vitoriaIKS) > 0)
			for (int n=0; n<NGRID; n++)
				tabuleiro[(k+n)%NGRID][j][(NGRID+i-n)%NGRID] = simboloJogador;
		if ((vitoria&vitoriaJKP) > 0)
			for (int n=0; n<NGRID; n++)
				tabuleiro[(k+n)%NGRID][(j+n)%NGRID][i] = simboloJogador;
		if ((vitoria&vitoriaJKS) > 0)
			for (int n=0; n<NGRID; n++)
				tabuleiro[(k+n)%NGRID][(NGRID+j-n)%NGRID][i] = simboloJogador;
		if ((vitoria&vitoriaA) > 0)
			for (int n=0; n<NGRID; n++)
				tabuleiro[(k+n)%NGRID][(j+n)%NGRID][(i+n)%NGRID] = simboloJogador;
		if ((vitoria&vitoriaB) > 0)
			for (int n=0; n<NGRID; n++)
				tabuleiro[(k+n)%NGRID][(NGRID+j-n)%NGRID][(i+n)%NGRID] = simboloJogador;
		if ((vitoria&vitoriaC) > 0)
			for (int n=0; n<NGRID; n++)
				tabuleiro[(k+n)%NGRID][(NGRID+j-n)%NGRID][(NGRID+i-n)%NGRID] = simboloJogador;
		if ((vitoria&vitoriaD) > 0)
			for (int n=0; n<NGRID; n++)
				tabuleiro[(k+n)%NGRID][(j+n)%NGRID][(NGRID+i-n)%NGRID] = simboloJogador;
		if (DEBUG) {
			if ((vitoria&vitoriaI) > 0) System.out.print("[vitoriaI] ");
			if ((vitoria&vitoriaJ) > 0) System.out.print("[vitoriaJ] ");
			if ((vitoria&vitoriaK) > 0) System.out.print("[vitoriaK] ");
			if ((vitoria&vitoriaIJP) > 0) System.out.print("[vitoriaIJP] ");
			if ((vitoria&vitoriaIJS) > 0) System.out.print("[vitoriaIJS] ");
			if ((vitoria&vitoriaIKP) > 0) System.out.print("[vitoriaIKP] ");
			if ((vitoria&vitoriaIKS) > 0) System.out.print("[vitoriaIKS] ");
			if ((vitoria&vitoriaJKP) > 0) System.out.print("[vitoriaJKP] ");
			if ((vitoria&vitoriaJKS) > 0) System.out.print("[vitoriaJKS] ");
			if ((vitoria&vitoriaA) > 0) System.out.print("[vitoriaA] ");
			if ((vitoria&vitoriaB) > 0) System.out.print("[vitoriaB] ");
			if ((vitoria&vitoriaC) > 0) System.out.print("[vitoriaC] ");
			if ((vitoria&vitoriaD) > 0) System.out.print("[vitoriaD] ");
		}
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
				if (testeVitoria(pos, simboloJogador)>0) { // retornar posição vitoriosa imediatamente
					return pos;
				} else if (testeVitoria(pos, simboloOponente)>0) { // evitar derrota
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
		int k = idxK(pos);
		int gancho = 0;
		char curSimbolo = tabuleiro[k][j][i];
		tabuleiro[k][j][i] = simboloJogador;
		for (int pos2=0; pos2<MAXPOS; pos2++) {
			if (testePosicaoLivre(pos2)) {
				if (testeVitoria(pos2, simboloJogador)>0) {
					gancho++;
				}
			}
		}
		tabuleiro[k][j][i] = curSimbolo;
		return gancho>1?true:false;
	}

	public static boolean testeGanchoFuturo(int pos, char simboloJogador) {
		int i = idxI(pos);
		int j = idxJ(pos);
		int k = idxK(pos);
		int gancho = 0;
		char curSimbolo = tabuleiro[k][j][i];
		tabuleiro[k][j][i] = simboloJogador;
		for (int pos2=0; pos2<MAXPOS; pos2++) {
			if (testePosicaoLivre(pos2)) {
				if (testeGancho(pos2, simboloJogador)) {
					gancho++;
					break;
				}
			}
		}
		tabuleiro[k][j][i] = curSimbolo;
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
		char[][][] novoTabuleiro = new char[NGRID][NGRID][ZGRID];
		int movedPos = -1;
		for (int k=0; k<ZGRID; k++)
			for (int j=0; j<NGRID; j++)
				for (int i=0; i<NGRID; i++) {
					int pos = ijk2pos(i,j,k);
					int novoPos = 0;
					novoPos = move(pos, opcao);
					int ni = idxI(novoPos);
					int nj = idxJ(novoPos);
					int nk = idxK(novoPos);
					novoTabuleiro[nk][nj][ni] = tabuleiro[k][j][i];
					if (pos==curPos) movedPos = novoPos;
				}
		for (int k=0; k<ZGRID; k++)
			for (int j=0; j<NGRID; j++)
				for (int i=0; i<NGRID; i++)
					tabuleiro[k][j][i] = novoTabuleiro[k][j][i];
		for (int l=0; l<logJogo.length(); l++) {
			int pos = logJogo.charAt(l) - '0';
			logJogo = logJogo.substring(0,l)+((char) ('0'+move(pos,opcao)))+logJogo.substring(l+1);
		}
		return movedPos;
	}

}
