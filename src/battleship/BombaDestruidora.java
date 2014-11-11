/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

/**
 *
 * @author Yuri
 */
public class BombaDestruidora extends PosicaoTabuleiroDecorator{
    public BombaDestruidora (PosicaoTabuleiro posicaoDecorada){
        super(posicaoDecorada);
    }
    
    @Override
    public void mostrar(){
        
    }
    
    @Override
    public String getDescription(){
        return super.getDescription()+" BD";
    }
    
    public void atirar(){}
}
