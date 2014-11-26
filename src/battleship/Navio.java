/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

/**
 *
 * @author root
 */
public class Navio implements Tabuleiro {

	protected boolean visible = false;
    @Override
    public String mostrar() {
    	if (this.visible) {
    		return "N";
		}
    	return "-";
    }

    @Override
    public int getType() {
        return 7;
    }

	@Override
	public void setVisibility(boolean flag) {
		this.visible = flag;
		
	}

}
