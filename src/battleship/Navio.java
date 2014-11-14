/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

/**
 *
 * @author root
 */
public class Navio implements PosicaoTabuleiro {

    @Override
    public String mostrar() {
    	return "N";
    }

    @Override
    public int getType() {
        return 7;
    }
}
