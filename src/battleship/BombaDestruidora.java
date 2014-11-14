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
	
	String estado = "";
    public BombaDestruidora (PosicaoTabuleiro posicaoDecorada){
        super(posicaoDecorada);
        atirar();
    }
    
    @Override
    public String mostrar(){
        return estado;
    }
    
    @Override
    public int getType(){
        return super.getType();
    }
    
    public void atirar(){
    	if(super.getType() > 0 && super.getType() < 6){
    		estado = "X";
    	}else{
    		estado = "*";
    	}
    }
}
