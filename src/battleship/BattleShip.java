/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

import java.io.ObjectInputStream.GetField;
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
		DificuldadeJogo dificuldade = null;
		int tipoDificuldade = 0, jogador = 0, tipoJogo = 0, numeroJogadores = 2;
		String nomeJogo = "", posicao = "", nomeDificuldade = "";
		// Random myGenerator = new Random();
		try {
			System.out.println("[1]-Criando novo jogo...");
			System.out
					.println("Entre com a dificuldade(0- fácil, 1-médio, 2-difícil):");
			tipoDificuldade = s.nextInt();
			switch (tipoDificuldade) {
			case 0:
				dificuldade = new Facil();
				nomeDificuldade = "Fácil";
				break;
			case 1:
				dificuldade = new Medio();
				nomeDificuldade = "Médio";
				break;
			case 2:
				dificuldade = new Dificil();
				nomeDificuldade = "Dfícil";
				break;
			default:
				System.out.println("Opção inválida!");
				tipoDificuldade = 9;// Error
				break;
			}
			System.out
					.println("Entre com o tipo do jogo(0 para Tradicional, 1 PQQD):");
			tipoJogo = s.nextInt();
			switch (tipoJogo) {
			case 0:
				jogo = new Tradicional(numeroJogadores,
						dificuldade.getTamanhoTabuleiro());
				nomeJogo = "Tradicional";
				break;
			case 1:
				jogo = new PQQD(numeroJogadores,
						dificuldade.getTamanhoTabuleiro());
				nomeJogo = "PQQD";
				break;
			default:
				System.out.println("Opção inválida!");
				tipoDificuldade = 9;// Error
				break;
			}
			System.out.println("Jogo do tipo " + nomeJogo + " na dificuldade "
					+ nomeDificuldade + "criado!");

			System.out.println("[2]-Distribuindo barcos no tabuleiro....");
			for (int i = 0; i < numeroJogadores; i++) {
				System.out.println("Distribuindo para o jogador" + i + ":");
				realizaDistribuicao(i, dificuldade.getTamanhoTabuleiro());
			}
			System.out.println("[3]-Começo do jogo, tiros:");
			int winnerPlayer = jogo.getWinnerNumber();
			while (winnerPlayer > numeroJogadores) {
				winnerPlayer = jogo.getWinnerNumber();
				for (int i = 0; i < numeroJogadores; i++) {
					boolean atirou = false;
					while (!atirou) {
						int seSinalizadora = 0;
						int atirandoEm = (i == 1) ? 0 : 1;
						jogo.printTabuleiro(atirandoEm);
						System.out
								.println("Entre com a posicao que vai atirar(exemplo: 0,0):");
						posicao = s.next();
						// posicao = new
						// Random().nextInt(dificuldade.getTamanhoTabuleiro())+
						// ","+ new
						// Random().nextInt(dificuldade.getTamanhoTabuleiro());
						boolean sinalizadora = new Random().nextBoolean();
						if (nomeJogo.equals("PQQD")) {
							System.out
									.println("Entre se ela for sinalizadora ou não(0 se não, 1 se for):");
							seSinalizadora = s.nextInt();
						}
						sinalizadora = (seSinalizadora == 1);
						positionHelper = separarString(posicao);
						if (positionHelper.getX() >= dificuldade.tamanhoTabuleiro
								|| positionHelper.getX() >= dificuldade.tamanhoTabuleiro) {
							System.out.println("Posição inválida!");
							continue;
						}
						System.out.println("Jogador " + i + ", atirando em: "
								+ posicao + " com " + sinalizadora
								+ " no jogador " + atirandoEm + "!");
						atirou = jogo.atira(atirandoEm, positionHelper,
								sinalizadora);
						if (!atirou) {
							System.out
									.println("Não foi válido! Tente novamente!");
							continue;
						}
						System.out.println("===================\n");
						jogo.printTabuleiro(atirandoEm);
						System.out.println("===================\n");
						seSinalizadora = 0;
						if (jogo.isGameOver()) {
							System.out.println("O jogo acabou!");
							break;
						}
					}
					if (jogo.isGameOver()) {
						break;
					}
				}
				winnerPlayer = jogo.getWinnerNumber();
			}
			jogo.printTabuleiro(0);
			System.out.println("\n ================ \n");
			jogo.printTabuleiro(1);
			System.out.println("O vencedor é o jogador... " + winnerPlayer);
			System.out.println("Com " + jogo.getNumTurnos(winnerPlayer)
					+ " turnos!");
			System.out.println("Saindo....");
		} catch (InputMismatchException e) {
			System.out.println("Opcao inválida!");
			System.exit(0);
		}
		s.close();
	}

	private static Posicoes separarString(String posicao) {
		Posicoes positionHelper = new Posicoes(0, 0);
		positionHelper.setX(Integer.parseInt((posicao.split(",", 2))[0]));
		positionHelper.setY(Integer.parseInt((posicao.split(",", 2))[1]));
		return positionHelper;
	}

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
		naviosNames.add("Submarino");
		naviosNames.add("Submarino");
		naviosNames.add("Submarino");
		naviosNames.add("Barco de Dois");
		naviosNames.add("Barco de Dois");
		naviosNames.add("Barco de Dois");
		naviosNames.add("Barco de Tres");
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
