/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

/**
 * Classe que descreve comportamento de objetos do tipo BombaDestruidora onde
 * estão contidos métodos e atributos para o mesmo. Objetos desta classe decoram
 * o tabuleiro.
 * 
 * @author Lucas Henrique, Yuri Matheus
 */
public class BombaDestruidora extends TabuleiroDecorator {

	private String estado = "";

	public BombaDestruidora(Tabuleiro posicaoDecorada) {
		super(posicaoDecorada);
		super.setVisibility(true);
		atirar();
	}
	/**
	 * Metodo para retorno do símbolo após o lançamento de uma Bomba Destruidora 
	 * em determinada posição.
	 * @return String - símbolo do objeto.
	 */
	@Override
	public String mostrar() {
		return estado;
	}
	/**
	 * Metodo que atira Bomba Destruidora em determina posição. Ao atirar é verificado
	 * qual o tipo da posicao atual, caso não tenha embarcação o estado retorna "*", caso 
	 * tenha alguma embarcação o estado retorna "X".
	 */
	
	public void atirar() {
		if (super.getType() > 0 && super.getType() < 6) {
			estado = "X";
		} else {
			estado = "*";
		}
	}
}
