/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

/**
 *
 * @author alunoinf
 */
public class Agua implements Tabuleiro{

	protected boolean visible;
    @Override
    public String mostrar() {
    	if (this.visible) {
    		return "~";
		}
    	return "-";
    }

    @Override
    public int getType() {
        return 0;
    }

	@Override
	public void setVisibility(boolean flag) {
    	this.visible = flag;
		
	}
    
}
