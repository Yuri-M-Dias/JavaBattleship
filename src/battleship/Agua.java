/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

/**
 *
 * @author alunoinf
 */
public class Agua implements PosicaoTabuleiro{

    @Override
    public String mostrar() {
    	return "~";
    }

    @Override
    public int getType() {
        return 0;
    }
    
}
