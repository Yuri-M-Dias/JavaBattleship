package battleship;

import java.util.ArrayList;
import java.util.Random;

/**
 * Classe que abriga m�todos e atributos respons�veis pela distribui��o
 * autom�tica de embarca��es.
 * 
 * @author Lucas Henrique, Yuri Matheus
 */
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
		naviosNames.add("Porta-Avi�es");
	}

	/**
	 * Metodo que gera posicoes e tipos de navios aleatorios e envia como
	 * parametros para o metodo distribuirAuto para que sejam inseridos no
	 * tabuleiro caso a posicao esteja disponivel.
	 * 
	 * @param tabuleiro
	 *            Tabuleiro[][] - tabuleiro para ser preenchido
	 * @param posicao
	 *            Posicao - Objeto do tipo posicao
	 * @param tipoNavio
	 *            int - tipo de navio a ser inserido
	 * @param direcao
	 *            String - direcao em que se deseja colocar a embarca��o
	 * @param tamanhoTabuleiro
	 *            int - tamanho do tabuleiro que ser� preenchido
	 * @return Tabuleiro[][] - retorna tabuleiro preenchido
	 */

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

	/**
	 * M�todo que verifica a possibilidade de inser��o de embarca��es em posic�o
	 * passada como parametro, caso seja poss�vel a inser��o o mesmo a faz.
	 * 
	 * @param tabuleiro
	 *            Tabuleiro[][] - tabuleiro para ser preenchido
	 * @param posicao
	 *            Posicao - Objeto do tipo posicao
	 * @param tipoNavio
	 *            int - tipo de navio a ser inserido
	 * @param direcao
	 *            String - direcao em que se deseja colocar a embarca��o
	 * @param tamanhoTabuleiro
	 *            int - tamanho do tabuleiro que ser� preenchido
	 * @return Tabuleiro[][] - retorna tabuleiro preenchido
	 */
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

	/**
	 * M�todo que verifica se existe alguma embar��o em determinada posi��o
	 * 
	 * @param tabuleiro
	 *            Tabuleiro[][] - tabuleiro para ser verificado
	 * @param posicao
	 *            Posicao - Objeto do tipo posicao
	 * @return boolean - retorna se a posi��o est� dispon�vel ou n�o
	 */
	public boolean verificaPosicao(Tabuleiro[][] tabuleiro, Posicoes posicao) {

		if ((tabuleiro[posicao.getX()][posicao.getY()].getType()) != 0) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * M�todo que verifica se existe a possibilidade de colocar embarca��es a
	 * direita da posi��o inicial e se as posi��es escolhidas est�o dentro dos
	 * limites do tabuleiro.
	 * 
	 * @param tabuleiro
	 *            Tabuleiro[][] - tabuleiro para ser verificado
	 * @param posicao
	 *            Posicao - Objeto do tipo posicao
	 * @param tipoNavio
	 *            int - tipo de navio a ser inserido
	 * @param tamanhoTabuleiro
	 *            int - tamanho do tabuleiro que ser� preenchido
	 * @return boolean - retorna se a posi��o est� dispon�vel ou n�o
	 */
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

	/**
	 * M�todo que verifica se existe a possibilidade de colocar embarca��es a
	 * esquerda da posi��o inicial e se as posi��es escolhidas est�o dentro dos
	 * limites do tabuleiro.
	 * 
	 * @param tabuleiro
	 *            Tabuleiro[][] - tabuleiro para ser verificado
	 * @param posicao
	 *            Posicao - Objeto do tipo posicao
	 * @param tipoNavio
	 *            int - tipo de navio a ser inserido
	 * @param tamanhoTabuleiro
	 *            int - tamanho do tabuleiro que ser� preenchido
	 * @return boolean - retorna se a posi��o est� dispon�vel ou n�o
	 */
	public boolean verificarEsquerda(Tabuleiro[][] tabuleiro, Posicoes posicao,
			int tipoNavio, int tamanhoTabuleiro) {
		if (posicao.getY() - tipoNavio < -1) {
			return false;
		}
		for (int i = 0; i < tipoNavio; i++) {
			if ((tabuleiro[posicao.getX()][posicao.getY() - i].getType()) != 0) {
				return false;
			}
		}
		return true;
	}

	/**
	 * M�todo que verifica se existe a possibilidade de colocar embarca��es
	 * acima da posi��o inicial e se as posi��es escolhidas est�o dentro dos
	 * limites do tabuleiro.
	 * 
	 * @param tabuleiro
	 *            Tabuleiro[][] - tabuleiro para ser verificado
	 * @param posicao
	 *            Posicao - Objeto do tipo posicao
	 * @param tipoNavio
	 *            int - tipo de navio a ser inserido
	 * @param tamanhoTabuleiro
	 *            int - tamanho do tabuleiro que ser� preenchido
	 * @return boolean - retorna se a posi��o est� dispon�vel ou n�o
	 */
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

	/**
	 * M�todo que verifica se existe a possibilidade de colocar embarca��es
	 * abaixo da posi��o inicial e se as posi��es escolhidas est�o dentro dos
	 * limites do tabuleiro.
	 * 
	 * @param tabuleiro
	 *            Tabuleiro[][] - tabuleiro para ser verificado
	 * @param posicao
	 *            Posicao - Objeto do tipo posicao
	 * @param tipoNavio
	 *            int - tipo de navio a ser inserido
	 * @param tamanhoTabuleiro
	 *            int - tamanho do tabuleiro que ser� preenchido
	 * @return boolean - retorna se a posi��o est� dispon�vel ou n�o
	 */
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

	/**
	 * M�todo que verifica atrav�s do nome do navio o n�mero correspondente a
	 * cada navio.
	 * 
	 * @param navioName
	 *            String - nome do navio
	 * @return int - retorna inteiro correspondente a cada navio.
	 */
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
		case "Porta-Avi�es":
			return 5;
		default:
			return 0;

		}

	}

}
