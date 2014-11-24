/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 
 * @author root
 */
public class BattleShip {

	public static void main(String[] args) {
		ArrayList<String> naviosNames = new ArrayList<String>();
		naviosNames.add("Submarino");
		naviosNames.add("Barco de Dois");
		naviosNames.add("Barco de Tres");
		naviosNames.add("Barco de Quatro");
		naviosNames.add("Porta-Aviões");

		int opcao = 0;
		Scanner s = new Scanner(System.in);
		TipoJogo jogo = null;
		Posicoes positionHelper = new Posicoes(0, 0);
		String posicao = "", direcao = "";
		int tipoNavio = 0, tamanhoTabuleiro = 0, jogador = 0, tipoDist;
		while (true) {
			printMenu();
			try {
				opcao = s.nextInt();
				switch (opcao) {
				case 1:
					System.out
							.println("Criando novo jogo....\n Entre com o tamanho do tabuleiro:");
					tamanhoTabuleiro = s.nextInt();
					jogo = new Tradicional(2, tamanhoTabuleiro);
					System.out.println("Jogo do tipo Tradicional criado!");
					break;
				case 2:
					System.out
							.println("Entre com o numero do jogador(0 ou 1):");
					jogador = s.nextInt();
					// parte que verifica se o jogar ja preencheu o tabuleiro
					if (jogo.getPreenchido(jogador)) {
						System.out.println("Tabuleiro ja foi preenchido...");
						break;
					}

					System.out
							.println("Escolha o modo de distribuição dos barcos ( 0 para automático e 1 para manual): ");
					tipoDist = s.nextInt();
					if (tipoDist == 0) {
						jogo.distribui(jogador, positionHelper, tipoNavio,
								direcao, tamanhoTabuleiro, tipoDist);
						jogo.mostraTabuleiro(jogador);

					} else {
						for (int i = 0; i < naviosNames.size(); i++) {
							System.out.println("Entre com a posicao do "
									+ naviosNames.get(i));
							posicao = s.next();
							positionHelper = separarString(posicao);
							tipoNavio = escolheTipoNavio(naviosNames.get(i));
							if (tipoNavio > 1) {
								System.out
										.println("Entre com a direcao desejada: ");
								direcao = s.next();
							} else {
								direcao = "atual";
							}
							jogo.distribui(jogador, positionHelper, tipoNavio,
									direcao, tamanhoTabuleiro, tipoDist);

						}
						jogo.mostraTabuleiro(jogador);
					}
					jogo.setPreenchido(jogador);

					break;
				case 3:
					System.out
							.println("Entre com o numero do jogador que será atacado(0 ou 1):");
					jogador = s.nextInt();
					System.out.println("AUTO:");
					// System.out.println("Entre com a posicao:");
					// posicao = s.next();
					String nova = "";
					for (int i = 0; i < tamanhoTabuleiro; i++) {
						for (int j = 0; j < tamanhoTabuleiro; j++) {
							nova = i + ","+j;
							//System.out.println(nova);
							positionHelper = separarString(nova);
							jogo.atira(jogador, positionHelper);
							//jogo.mostraTabuleiro(jogador);
							if (jogo.getGameOver()) {
								System.out.println("THE GAME IS OVAH!");
								break;
							}
						}
					}
					jogo.mostraTabuleiro(jogador);
					break;
				case 4:
					jogo.mostraTabuleiro(0);
					System.out.println("\n E...\n");
					jogo.mostraTabuleiro(1);
					break;
				case 9:
					System.out.println("Saindo....");
					break;
				default:
					System.out.println("Opcao inválida!");
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("Opcao inválida!");
			}
			if (opcao == 9)
				break;
		}
		s.close();
		System.out.println("-----Program end?------");
	}

	private static void printMenu() {
		System.out.println("Entre com um número:");
		System.out.println("[1]-Criar novo jogo/tabuleiro");
		System.out.println("[2]-Distribuir barcos no tabuleiro");
		System.out.println("[3]-Atirar em uma posição");
		System.out.println("[4]-Mostrar os tabuleiros");
		System.out.println("[9]-Sair");
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
}
