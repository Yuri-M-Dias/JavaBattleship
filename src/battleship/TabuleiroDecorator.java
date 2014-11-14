/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

/**
 *
 * @author alunoinf
 */
public abstract class TabuleiroDecorator implements Tabuleiro{
    protected Tabuleiro posicaoDecorada;
    
    public TabuleiroDecorator(Tabuleiro posicaoDecorada){
        this.posicaoDecorada = posicaoDecorada;
    }
    
    @Override
    public String mostrar(){
        return posicaoDecorada.mostrar();
    }
    
    @Override
    public int getType(){
        return posicaoDecorada.getType();
    }
}
