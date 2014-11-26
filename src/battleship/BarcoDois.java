/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

/**
 * Classe para objetos do tipo Barco que ocupa 2 posicoes onde est�o contidos
 * atributos e m�todos para o mesmo. Objetos desta classe decoram o tabuleiro.
 * 
 * @author Lucas Henrique, Yuri Matheus
 */
public class BarcoDois extends TabuleiroDecorator {
	public BarcoDois(Tabuleiro posicaoDecorada) {
		super(posicaoDecorada);
	}

	/**
	 * Metodo para retorno do s��bolo relacionado ao objeto Barco Dois em
	 * determinado instante do jogo, caso a posicao esteja vis��el ao jogador
	 * ser?mostrado "2" sen�o ser?mostrado "-"
	 * 
	 * @return String - s��bolo do objeto.
	 */

	@Override
	public String mostrar() {
		if (super.visible) {
			return getType() + "";
		}
		return "-";
	}

	/**
	 * Metodo para retorno do valor relacionado ao objeto BarcoDois.
	 * 
	 * @return int - valor referente ao objeto Barco Dois (2)
	 */

	@Override
	public int getType() {
		return 2;
	}
}