package battleship;

import java.util.ArrayList;

/**
 * Classe que abriga m�todos e atributos respons�veis pela distribui��o manual
 * de embarca��es.
 * 
 * @author Lucas Henrique, Yuri Matheus
 */
public class DistribuirManual implements TipoDistribuicao {

	public DistribuirManual() {
	}

	/**
	 * Metodo que insere embarca��es no tabuleiro ap�s a verifica��o da
	 * disponibilidade das posi��es escolhidas pelo usu�rios.
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

		NavioFactory factory = new NavioFactory();

		if (direcao.equals("direita")) {
			if (verificarDireita(tabuleiro, posicao, tipoNavio,
					tamanhoTabuleiro) && (verificaPosicao(tabuleiro, posicao))) {
				for (int i = 0; i < tipoNavio; i++) {
					tabuleiro[posicao.getX()][posicao.getY() + i] = factory
							.criaNavio(tabuleiro, posicao, tipoNavio);
				}
			}

		} else if (direcao.equals("esquerda")) {
			if (verificarEsquerda(tabuleiro, posicao, tipoNavio,
					tamanhoTabuleiro) && (verificaPosicao(tabuleiro, posicao))) {
				for (int i = 0; i < tipoNavio; i++) {
					tabuleiro[posicao.getX()][posicao.getY() - i] = factory
							.criaNavio(tabuleiro, posicao, tipoNavio);
				}
			}

		} else if (direcao.equals("baixo")) {
			if (verificarBaixo(tabuleiro, posicao, tipoNavio, tamanhoTabuleiro)
					&& (verificaPosicao(tabuleiro, posicao))) {
				for (int i = 0; i < tipoNavio; i++) {
					tabuleiro[posicao.getX() + i][posicao.getY()] = factory
							.criaNavio(tabuleiro, posicao, tipoNavio);
				}
			}

		} else if (direcao.equals("cima")) {
			if (verificarCima(tabuleiro, posicao, tipoNavio, tamanhoTabuleiro)
					&& (verificaPosicao(tabuleiro, posicao))) {
				for (int i = 0; i < tipoNavio; i++) {
					tabuleiro[posicao.getX() - i][posicao.getY()] = factory
							.criaNavio(tabuleiro, posicao, tipoNavio);
				}
			}

		} else if (direcao.equals("atual")) {
			if ((verificaPosicao(tabuleiro, posicao))) {
				tabuleiro[posicao.getX()][posicao.getY()] = factory.criaNavio(
						tabuleiro, posicao, tipoNavio);
			}
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
}
