/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

/**
 *
 * @author alunoinf
 */
public class PortaAvioes extends TabuleiroDecorator{
    public PortaAvioes (Tabuleiro posicaoDecorada){
        super(posicaoDecorada);
    }
    
    @Override
    public String mostrar(){
    	return "T";
    }
    
    @Override
    public int getType(){
        return 5;
    }
}
