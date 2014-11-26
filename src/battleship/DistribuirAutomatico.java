package battleship;

import java.util.ArrayList;
import java.util.Random;

/**
 * Classe que abriga métodos e atributos responsáveis pela distribuição
 * automática de embarcações.
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
		naviosNames.add("Porta-Aviões");
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
	 *            String - direcao em que se deseja colocar a embarcação
	 * @param tamanhoTabuleiro
	 *            int - tamanho do tabuleiro que será preenchido
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
	 * Método que verifica a possibilidade de inserção de embarcações em posicão
	 * passada como parametro, caso seja possível a inserção o mesmo a faz.
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

	/**
	 * Método que verifica através do nome do navio o número correspondente a
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
		case "Porta-Aviões":
			return 5;
		default:
			return 0;

		}

	}

}
