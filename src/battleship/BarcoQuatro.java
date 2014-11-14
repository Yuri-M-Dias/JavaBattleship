/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

/**
 *
 * @author alunoinf
 */
public class BarcoQuatro extends PosicaoTabuleiroDecorator{
    public BarcoQuatro (PosicaoTabuleiro posicaoDecorada){
        super(posicaoDecorada);
    }
    
    @Override
    public String mostrar(){
    	return "4";
    }
    
    @Override
    public int getType(){
        return 4;
    }
}
