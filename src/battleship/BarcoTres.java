/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

/**
 *
 * @author alunoinf
 */
public class BarcoTres extends TabuleiroDecorator{
    public BarcoTres (Tabuleiro posicaoDecorada){
        super(posicaoDecorada);
    }
    
    @Override
    public String mostrar(){
        return "3";
    }
    
    @Override
    public int getType(){
        return 3;
    }
}
