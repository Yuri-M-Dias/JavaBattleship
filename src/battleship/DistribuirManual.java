package battleship;

import java.util.ArrayList;

/**
 * Classe que abriga métodos e atributos responsáveis pela distribuição manual
 * de embarcações.
 * 
 * @author Lucas Henrique, Yuri Matheus
 */
public class DistribuirManual implements TipoDistribuicao {

	public DistribuirManual() {
	}

	/**
	 * Metodo que insere embarcações no tabuleiro após a verificação da
	 * disponibilidade das posições escolhidas pelo usuários.
	 * 
	 * @param tabuleiro
	 *            Tabuleiro[][] - tabuleiro para ser preenchido
	 * @param posicao
	 *            Posicao - Objeto do tipo posicao
	 * @param tipoNavio
	 *            int - tipo de navio a ser inserido
	 * @param direcao
	 *            String - direcao em que se deseja colocar a embarcação
	 * @param tamanhoTabuleiro
	 *            int - tamanho do tabuleiro que será preenchido
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
	 * Método que verifica se existe alguma embarção em determinada posição
	 * 
	 * @param tabuleiro
	 *            Tabuleiro[][] - tabuleiro para ser verificado
	 * @param posicao
	 *            Posicao - Objeto do tipo posicao
	 * @return boolean - retorna se a posição está disponível ou não
	 */
	public boolean verificaPosicao(Tabuleiro[][] tabuleiro, Posicoes posicao) {

		if ((tabuleiro[posicao.getX()][posicao.getY()].getType()) != 0) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Método que verifica se existe a possibilidade de colocar embarcações a
	 * direita da posição inicial e se as posições escolhidas estão dentro dos
	 * limites do tabuleiro.
	 * 
	 * @param tabuleiro
	 *            Tabuleiro[][] - tabuleiro para ser verificado
	 * @param posicao
	 *            Posicao - Objeto do tipo posicao
	 * @param tipoNavio
	 *            int - tipo de navio a ser inserido
	 * @param tamanhoTabuleiro
	 *            int - tamanho do tabuleiro que será preenchido
	 * @return boolean - retorna se a posição está disponível ou não
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
	 * Método que verifica se existe a possibilidade de colocar embarcações a
	 * esquerda da posição inicial e se as posições escolhidas estão dentro dos
	 * limites do tabuleiro.
	 * 
	 * @param tabuleiro
	 *            Tabuleiro[][] - tabuleiro para ser verificado
	 * @param posicao
	 *            Posicao - Objeto do tipo posicao
	 * @param tipoNavio
	 *            int - tipo de navio a ser inserido
	 * @param tamanhoTabuleiro
	 *            int - tamanho do tabuleiro que será preenchido
	 * @return boolean - retorna se a posição está disponível ou não
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
	 * Método que verifica se existe a possibilidade de colocar embarcações
	 * acima da posição inicial e se as posições escolhidas estão dentro dos
	 * limites do tabuleiro.
	 * 
	 * @param tabuleiro
	 *            Tabuleiro[][] - tabuleiro para ser verificado
	 * @param posicao
	 *            Posicao - Objeto do tipo posicao
	 * @param tipoNavio
	 *            int - tipo de navio a ser inserido
	 * @param tamanhoTabuleiro
	 *            int - tamanho do tabuleiro que será preenchido
	 * @return boolean - retorna se a posição está disponível ou não
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
	 * Método que verifica se existe a possibilidade de colocar embarcações
	 * abaixo da posição inicial e se as posições escolhidas estão dentro dos
	 * limites do tabuleiro.
	 * 
	 * @param tabuleiro
	 *            Tabuleiro[][] - tabuleiro para ser verificado
	 * @param posicao
	 *            Posicao - Objeto do tipo posicao
	 * @param tipoNavio
	 *            int - tipo de navio a ser inserido
	 * @param tamanhoTabuleiro
	 *            int - tamanho do tabuleiro que será preenchido
	 * @return boolean - retorna se a posição está disponível ou não
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
