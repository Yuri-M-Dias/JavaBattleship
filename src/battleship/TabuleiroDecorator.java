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
    protected boolean visible;
    
    public TabuleiroDecorator(Tabuleiro posicaoDecorada){
        this.posicaoDecorada = posicaoDecorada;
        this.visible = true;
    }
    
    @Override
    public String mostrar(){
    	if (this.visible) {
    		return posicaoDecorada.mostrar();
		}
    	return "-";
    }
    
    @Override
    public int getType(){
        return posicaoDecorada.getType();
    }
    
    @Override
	public void setVisibility(boolean flag) {
    	posicaoDecorada.setVisibility(flag);
    	this.visible = flag;
	}
}
