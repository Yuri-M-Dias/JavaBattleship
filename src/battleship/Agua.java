/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

/**
 * Classe para objetos do tipo �gua onde est�o contidos atributos e m�todos para
 * o mesmo.
 * 
 * @author Lucas Henrique, Yuri Matheus
 */
public class Agua implements Tabuleiro {

	protected boolean visible;

	/**
	 * Metodo para retorno do s�mbolo relacionado ao objeto �gua em determinado
	 * instante do jogo, caso a posicao esteja vis�vel ao jogador ser� mostrado
	 * "~" sen�o ser� mostrado "-"
	 * 
	 * @return String - s�mbolo do objeto.
	 */
	@Override
	public String mostrar() {
		if (this.visible) {
			return "~";
		}
		return "-";
	}

	/**
	 * Metodo para retorno do valor relacionado ao objeto �gua.
	 * 
	 * @return int - valor referente ao objeto �gua (0)
	 */
	@Override
	public int getType() {
		return 0;
	}

	/**
	 * Metodo que modifica o valor do atributo visible, para deixar o s�mbolo do
	 * objeto visivel ao jogador.
	 * 
	 * @param booelan
	 *            -true or false
	 * 
	 */
	@Override
	public void setVisibility(boolean flag) {
		this.visible = flag;

	}

}
