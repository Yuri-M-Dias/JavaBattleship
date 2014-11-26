/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

/**
 * Classe que descreve comportamento de objetos do tipo BombaDestruidora onde
 * est�o contidos m�todos e atributos para o mesmo. Objetos desta classe decoram
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
	 * Metodo para retorno do s�mbolo ap�s o lan�amento de uma Bomba Destruidora 
	 * em determinada posi��o.
	 * @return String - s�mbolo do objeto.
	 */
	@Override
	public String mostrar() {
		return estado;
	}
	/**
	 * Metodo que atira Bomba Destruidora em determina posi��o. Ao atirar � verificado
	 * qual o tipo da posicao atual, caso n�o tenha embarca��o o estado retorna "*", caso 
	 * tenha alguma embarca��o o estado retorna "X".
	 */
	
	public void atirar() {
		if (super.getType() > 0 && super.getType() < 6) {
			estado = "X";
		} else {
			estado = "*";
		}
	}
}
