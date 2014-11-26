/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

/**
 * Classe para objetos do tipo Navio onde estão contidos atributos e métodos
 * para o mesmo.
 * 
 * @author Lucas Henrique, Yuri Matheus
 */
public class Navio implements Tabuleiro {

	protected boolean visible = false;

	@Override
	/**
	 * Metodo para retorno do símbolo relacionado ao objeto Navio em determinado
	 * instante do jogo, caso a posicao esteja visível ao jogador será mostrado
	 * "N" senão será mostrado "-"
	 * 
	 * @return String - símbolo do objeto.
	 */
	public String mostrar() {
		if (this.visible) {
			return "N";
		}
		return "-";
	}

	/**
	 * Metodo para retorno do valor relacionado ao objeto Navio.
	 * 
	 * @return int - valor referente ao objeto Navio (7)
	 */
	@Override
	public int getType() {
		return 7;
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
