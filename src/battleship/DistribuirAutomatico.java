package battleship;

import java.util.ArrayList;
import java.util.Random;

public class DistribuirAutomatico implements TipoDistribuicao {
	ArrayList<String> naviosNames = new ArrayList<String>();
	int controle, direction;
	String[] direcoes = { "direita", "esquerda", "baixo", "cima" };
	NavioFactory factory = new NavioFactory();

	public DistribuirAutomatico() {
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
	}

	@Override
	public Tabuleiro[][] distribuir(Tabuleiro[][] tabuleiro, Posicoes posicao,
			int tipoNavio, String direcao, int tamanhoTabuleiro) {
		Random aleatorio = new Random();

		controle = 0;

		do {
			posicao.setX(aleatorio.nextInt(tamanhoTabuleiro));
			posicao.setY(aleatorio.nextInt(tamanhoTabuleiro));
			direcao = direcoes[aleatorio.nextInt(4)];
			tipoNavio = escolheTipoNavio(naviosNames.get(controle));
			tabuleiro = distribuirAuto(tabuleiro, posicao, direcao, tipoNavio,
					tamanhoTabuleiro);

		} while (controle < naviosNames.size());

		return tabuleiro;

	}

	// funcao que distribui os barcos no tabuleiro apos escolha de numeros
	// aleatorios
	public Tabuleiro[][] distribuirAuto(Tabuleiro[][] tabuleiro,
			Posicoes posicao, String direcao, int tipoNavio,
			int tamanhoTabuleiro) {

		if (direcao.equals("direita")) {
			if (verificarDireita(tabuleiro, posicao, tipoNavio,
					tamanhoTabuleiro) && (verificaPosicao(tabuleiro, posicao))) {
				for (int i = 0; i < tipoNavio; i++) {
					tabuleiro[posicao.getX()][posicao.getY() + i] = factory
							.criaNavio(tabuleiro, posicao, tipoNavio);

				}
				this.controle++;
			}

		} else if (direcao.equals("esquerda")) {
			if (verificarEsquerda(tabuleiro, posicao, tipoNavio,
					tamanhoTabuleiro) && (verificaPosicao(tabuleiro, posicao))) {
				for (int i = 0; i < tipoNavio; i++) {
					tabuleiro[posicao.getX()][posicao.getY() - i] = factory
							.criaNavio(tabuleiro, posicao, tipoNavio);
				}
				this.controle++;
			}

		} else if (direcao.equals("baixo")) {
			if (verificarBaixo(tabuleiro, posicao, tipoNavio, tamanhoTabuleiro)
					&& (verificaPosicao(tabuleiro, posicao))) {
				for (int i = 0; i < tipoNavio; i++) {
					tabuleiro[posicao.getX() + i][posicao.getY()] = factory
							.criaNavio(tabuleiro, posicao, tipoNavio);

				}
				this.controle++;
			}

		} else if (direcao.equals("cima")) {
			if (verificarCima(tabuleiro, posicao, tipoNavio, tamanhoTabuleiro)
					&& (verificaPosicao(tabuleiro, posicao))) {
				for (int i = 0; i < tipoNavio; i++) {
					tabuleiro[posicao.getX() - i][posicao.getY()] = factory
							.criaNavio(tabuleiro, posicao, tipoNavio);
				}
				this.controle++;
			}

		} else if (direcao.equals("atual")) {
			if ((verificaPosicao(tabuleiro, posicao))) {
				tabuleiro[posicao.getX()][posicao.getY()] = factory.criaNavio(
						tabuleiro, posicao, tipoNavio);
			}
			this.controle++;
		}

		return tabuleiro;
	}

	// verifica se ja existe embarcacao na posicao escolhida - usada para
	// colocar submarino
	public boolean verificaPosicao(Tabuleiro[][] tabuleiro, Posicoes posicao) {

		if ((tabuleiro[posicao.getX()][posicao.getY()].getType()) != 0) {
			return false;
		} else {
			return true;
		}
	}

	// metodo que verifica se existe possibilidade de colocar pecas a direta
	public boolean verificarDireita(Tabuleiro[][] tabuleiro, Posicoes posicao,
			int tipoNavio, int tamanhoTabuleiro) {

		if (posicao.getY() > tamanhoTabuleiro - tipoNavio) {
			return false;
		}
		for (int i = 0; i < tipoNavio; i++) {
			if (((tabuleiro[posicao.getX()][posicao.getY() + i].getType()) != 0)) {
				return false;
			}
		}
		return true;
	}

	// metodo que verifica se existe possibilidade de colocar pecas a esquerda
	public boolean verificarEsquerda(Tabuleiro[][] tabuleiro, Posicoes posicao,
			int tipoNavio, int tamanhoTabuleiro) {
		if (posicao.getY() - tipoNavio < -1) {
			return false;
		}
		for (int i = 0; i < 2; i++) {
			if ((tabuleiro[posicao.getX()][posicao.getY() - i].getType()) != 0) {
				return false;
			}
		}
		return true;
	}

	// metodo que verifica se existe possibilidade de colocar pecas para cima
	public boolean verificarCima(Tabuleiro[][] tabuleiro, Posicoes posicao,
			int tipoNavio, int tamanhoTabuleiro) {
		if (posicao.getX() - tipoNavio < -1) {
			return false;
		}
		for (int i = 0; i < tipoNavio; i++) {
			if ((tabuleiro[posicao.getX() - i][posicao.getY()].getType()) != 0) {
				return false;
			}
		}
		return true;
	}

	// metodo que verifica se existe possibilidade de colocar pecas para baixo
	public boolean verificarBaixo(Tabuleiro[][] tabuleiro, Posicoes posicao,
			int tipoNavio, int tamanhoTabuleiro) {
		if (posicao.getX() > tamanhoTabuleiro - tipoNavio) {
			return false;
		}
		for (int i = 0; i < tipoNavio; i++) {
			if ((tabuleiro[posicao.getX() + i][posicao.getY()].getType()) != 0) {
				return false;
			}
		}
		return true;
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

}
