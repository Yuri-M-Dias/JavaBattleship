/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

/**
 *
 * @author Yuri
 */
public class BombaDestruidora extends TabuleiroDecorator{
	
	private String estado = "";
	
    public BombaDestruidora (Tabuleiro posicaoDecorada){
        super(posicaoDecorada);
        super.setVisibility(true);
        atirar();
    }
    
    @Override
    public String mostrar(){
        return estado;
    }
    
    public void atirar(){
    	if(super.getType() > 0 && super.getType() < 6){
    		estado = "X";
    	}else{
    		estado = "*";
    	}
    }
}
