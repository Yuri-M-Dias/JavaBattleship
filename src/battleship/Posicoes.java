package battleship;

/**
 * @author Yuri
 *	An object to ease the positioning communication between classes.
 */
public class Posicoes {
	private int x;
	private int y;
	
	public Posicoes(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	
}
