/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * 
 * @author root
 */
public class BattleShip {

	private static Scanner s = new Scanner(System.in);
	private static TipoJogo jogo;

	public static void main(String[] args) {
		int opcao = 0;
		s = new Scanner(System.in);
		Posicoes positionHelper = new Posicoes(0, 0);
		int tamanhoTabuleiro = 0, jogador = 0, tipoJogo = 0, numeroJogadores = 2;
		String nomeJogo = "", posicao = "";
		// Random myGenerator = new Random();
		try {
			System.out.println("[1]-Criando novo jogo...");
			System.out.println("Entre com o tamanho do tabuleiro:");
			tamanhoTabuleiro = s.nextInt();
			System.out
					.println("Entre com o tipo do jogo(0 para Tradicional, 1 PQQD):");
			tipoJogo = s.nextInt();
			if (tipoJogo == 0) {
				jogo = new Tradicional(numeroJogadores, tamanhoTabuleiro);
				nomeJogo = "Tradicional";
			} else {
				jogo = new PQQD(numeroJogadores, tamanhoTabuleiro);
				nomeJogo = "PQQD";
			}
			System.out.println("Jogo do tipo " + nomeJogo + " criado!");

			System.out.println("[2]-Distribuindo barcos no tabuleiro....");
			for (int i = 0; i < numeroJogadores; i++) {
				System.out.println("Distribuindo para o jogador" + i + ":");
				realizaDistribuicao(i, tamanhoTabuleiro);
			}

			System.out.println("[3]-Começo do jogo, tiros:");
			int winnerPlayer = jogo.getWinnerNumber();
			while (winnerPlayer > numeroJogadores) {
				winnerPlayer = jogo.getWinnerNumber();
				for (int i = 0; i < numeroJogadores; i++) {
					boolean atirou = false;
					while (!atirou) {
						//jogo.printTabuleiro(i);
						//System.out.println("Entre com a posicao:");
						// posicao = s.next();
						posicao = new Random().nextInt(tamanhoTabuleiro) + ","
								+ new Random().nextInt(tamanhoTabuleiro);
						boolean sinalizadora = new Random().nextBoolean();
						System.out.println("Jogador " + i + ", atirando em: "
								+ posicao + " com " + sinalizadora
								+ " no seu próprio tabuleiro!");
						positionHelper = separarString(posicao);
						atirou = jogo.atira(i, positionHelper, sinalizadora);
						//jogo.printTabuleiro(i);
						//System.out.println("<<>>");
						if (jogo.isGameOver()) {
							break;
						}
						try {
							Thread.sleep(30);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
				winnerPlayer = jogo.getWinnerNumber();
			}
			jogo.printTabuleiro(0);
			System.out.println("<<<LINE>>>>");
			jogo.printTabuleiro(1);
			System.out.println("THE GAME IS OVAH! Winner is:" + winnerPlayer);
			System.out.println("Com " + jogo.getNumTurnos(0)
					+ " turnos pro jogador 0...");
			System.out.println("Com " + jogo.getNumTurnos(1)
					+ " turnos pro jogador 1...");
			System.out.println("Saindo....");
		} catch (InputMismatchException e) {
			System.out.println("Opcao inválida!");
		}
		s.close();
	}

	private static Posicoes separarString(String posicao) {
		Posicoes positionHelper = new Posicoes(0, 0);
		positionHelper.setX(Integer.parseInt((posicao.split(",", 2))[0]));
		positionHelper.setY(Integer.parseInt((posicao.split(",", 2))[1]));
		return positionHelper;
	}

	// funcao que escolhe o tipo de navio de acordo com o nome no vetor de
	// navios
	private static int escolheTipoNavio(String navioName) {
		switch (navioName) {
		case "Submarino":
			return 1;
		case "Barco de Dois":
			return 2;
		case "Barco de Tres":
			return 3;
		case "Barco de Quatro":
			return 4;
		case "Porta-Aviões":
			return 5;
		default:
			return 0;
		}
	}

	private static void realizaDistribuicao(int jogador, int tamanhoTabuleiro) {
		ArrayList<String> naviosNames = new ArrayList<String>();
		naviosNames.add("Submarino");
		naviosNames.add("Barco de Dois");
		naviosNames.add("Barco de Tres");
		naviosNames.add("Barco de Quatro");
		naviosNames.add("Porta-Aviões");
		Posicoes positionHelper = new Posicoes(0, 0);
		String posicao = "", direcao = "";
		int tipoNavio = 0, tipoDist;

		System.out
				.println("Escolha o modo de distribuição dos barcos (0 para automático e 1 para manual):");
		tipoDist = s.nextInt();
		if (tipoDist == 0) {
			jogo.distribui(jogador, positionHelper, tipoNavio, direcao,
					tamanhoTabuleiro, tipoDist);
		} else {
			for (int i = 0; i < naviosNames.size(); i++) {
				System.out.println("Entre com a posicao do "
						+ naviosNames.get(i));
				posicao = s.next();
				positionHelper = separarString(posicao);
				tipoNavio = escolheTipoNavio(naviosNames.get(i));
				if (tipoNavio > 1) {
					System.out.println("Entre com a direcao desejada: ");
					direcao = s.next();
				} else {
					direcao = "atual";
				}
				jogo.distribui(jogador, positionHelper, tipoNavio, direcao,
						tamanhoTabuleiro, tipoDist);
			}
		}
		jogo.setPreenchido(jogador);
	}
}
