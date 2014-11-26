/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

/**
 * Classe para objetos do tipo Barco que ocupa 5 posicoes onde est�o contidos
 * atributos e m�todos para o mesmo. Objetos desta classe decoram o tabuleiro.
 * 
 * @author Lucas Henrique, Yuri Matheus
 */

public class PortaAvioes extends TabuleiroDecorator {
	public PortaAvioes(Tabuleiro posicaoDecorada) {
		super(posicaoDecorada);
	}

	/**
	 * Metodo para retorno do s�mbolo relacionado ao objeto PortaAvioes em
	 * determinado instante do jogo, caso a posicao esteja vis�vel ao jogador
	 * ser� mostrado "5" sen�o ser� mostrado "-"
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
	 * Metodo para retorno do valor relacionado ao objeto PortaAvioes.
	 * 
	 * @return int - valor referente ao objeto PortaAvioes (5)
	 */

	@Override
	public int getType() {
		return 5;
	}

}
