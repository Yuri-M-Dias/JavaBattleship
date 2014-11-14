/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

/**
 *
 * @author alunoinf
 */
public class BarcoDois extends TabuleiroDecorator{
    public BarcoDois (Tabuleiro posicaoDecorada){
        super(posicaoDecorada);
    }
    
    @Override
    public String mostrar(){
    	return "2";
    }
    
    @Override
    public int getType(){
        return 2;
    }
}