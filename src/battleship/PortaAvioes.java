/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

/**
 * 
 * @author alunoinf
 */
public class PortaAvioes extends TabuleiroDecorator {
	public PortaAvioes(Tabuleiro posicaoDecorada) {
		super(posicaoDecorada);
	}

	@Override
	public String mostrar() {
		if (super.visible) {
			return getType()+"";
		}
		return "-";
	}

	@Override
	public int getType() {
		return 5;
	}

}
