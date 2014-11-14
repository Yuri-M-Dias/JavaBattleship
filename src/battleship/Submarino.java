/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

/**
 *
 * @author alunoinf
 */
public class Submarino extends PosicaoTabuleiroDecorator{
    public Submarino (PosicaoTabuleiro posicaoDecorada){
        super(posicaoDecorada);
    }
    
    @Override
    public String mostrar(){
    	return "S";
    }
    
    @Override
    public int getType(){
        return 1;
    }
}
