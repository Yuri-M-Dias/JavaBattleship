/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

/**
 * Classe para objetos do tipo Barco que ocupa 4 posicoes onde est�o contidos
 * atributos e m�todos para o mesmo. Objetos desta classe decoram o tabuleiro.
 * 
 * @author Lucas Henrique, Yuri Matheus
 */
public class BarcoQuatro extends TabuleiroDecorator {
	public BarcoQuatro(Tabuleiro posicaoDecorada) {
		super(posicaoDecorada);
	}

	/**
	 * Metodo para retorno do s�mbolo relacionado ao objeto Barco Quatro em
	 * determinado instante do jogo, caso a posicao esteja vis�vel ao jogador
	 * ser� mostrado "4" sen�o ser� mostrado "-"
	 * 
	 * @return String - s�mbolo do objeto.
	 */
	@Override
	public String mostrar() {
		if (super.visible) {
			return getType() + "";
		}
		return "-";
	}

	/**
	 * Metodo para retorno do valor relacionado ao objeto BarcoQuatro.
	 * 
	 * @return int - valor referente ao objeto BarcoQuatro (4)
	 */

	@Override
	public int getType() {
		return 4;
	}
}
