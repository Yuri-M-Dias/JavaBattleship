/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

/**
 *
 * @author alunoinf
 */
public abstract class PosicaoTabuleiroDecorator implements PosicaoTabuleiro{
    protected PosicaoTabuleiro posicaoDecorada;
    
    public PosicaoTabuleiroDecorator(PosicaoTabuleiro posicaoDecorada){
        this.posicaoDecorada = posicaoDecorada;
    }
    
    @Override
    public void mostrar(){
        
    }
    
    @Override
    public String getDescription(){
        return posicaoDecorada.getDescription();
    }
}
