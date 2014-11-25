/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

/**
 * Classe para objetos do tipo Água onde estão contidos atributos e métodos para
 * o mesmo.
 * 
 * @author Lucas Henrique, Yuri Matheus
 */
public class Agua implements Tabuleiro {

	protected boolean visible;

	/**
	 * Metodo para retorno do símbolo relacionado ao objeto água em determinado
	 * instante do jogo, caso a posicao esteja visível ao jogador será mostrado
	 * "~" senão será mostrado "-"
	 * 
	 * @return String - símbolo do objeto.
	 */
	@Override
	public String mostrar() {
		if (this.visible) {
			return "~";
		}
		return "-";
	}

	/**
	 * Metodo para retorno do valor relacionado ao objeto água.
	 * 
	 * @return int - valor referente ao objeto água (0)
	 */
	@Override
	public int getType() {
		return 0;
	}

	/**
	 * Metodo que modifica o valor do atributo visible, para deixar o símbolo do
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
