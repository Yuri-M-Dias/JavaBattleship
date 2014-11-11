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
    public void mostrar(){
        
    }
    
    @Override
    public String getDescription(){
        return "4";
    }
}
