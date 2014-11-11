/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

/**
 *
 * @author alunoinf
 */
public class BarcoDois extends PosicaoTabuleiroDecorator{
    public BarcoDois (PosicaoTabuleiro posicaoDecorada){
        super(posicaoDecorada);
    }
    
    @Override
    public void mostrar(){
        
    }
    
    @Override
    public String getDescription(){
        return "2";
    }
}