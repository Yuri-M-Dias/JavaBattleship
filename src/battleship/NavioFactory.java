package battleship;

/**
 * Classe que abriga m�todos e atributos respons�veis pela cria��o de novos
 * objetos do tipo Navio.
 * 
 * @author Lucas Henrique, Yuri Matheus
 */
public class NavioFactory {

	public NavioFactory() {

	}

	/**
	 * Metodo que instancia novos objetos de acordo com o tipo de navio passado
	 * como parametro.
	 * 
	 * @param tabuleiro
	 *            Tabuleiro[][] - tabuleiro para ser preenchido
	 * @param posicao
	 *            Posicao - Objeto do tipo posicao
	 * @param tipoNavio
	 *            int - tipo de navio a ser inserido
	 * @return Tabuleiro - retorna tabuleiro com objeto instanciado.
	 */
	public Tabuleiro criaNavio(Tabuleiro[][] tabuleiro, Posicoes posicao,
			int tipoNavio) {

		switch (tipoNavio) {
		case 1:// Submarino - ocupa somente uma posicao
			return new Submarino(tabuleiro[posicao.getX()][posicao.getY()]);
		case 2:// barco de duas posicoes
			return new BarcoDois(tabuleiro[posicao.getX()][posicao.getY()]);
		case 3:// barco de tres posicoes
			return new BarcoTres(tabuleiro[posicao.getX()][posicao.getY()]);
		case 4:// barco de quatro posicoes
			return new BarcoQuatro(tabuleiro[posicao.getX()][posicao.getY()]);
		case 5:// porta avioes
			return new PortaAvioes(tabuleiro[posicao.getX()][posicao.getY()]);
		default:
			return null;
		}

	}
}