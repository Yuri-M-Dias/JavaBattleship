package battleship;

/**
 * Classe para objetos do tipo Posicoes onde estão contidos atributos e métodos
 * para o mesmo. Objetos criados para facilitar a comunicação entre classes e
 * métodos.
 * 
 * @author Lucas Henrique, Yuri Matheus
 */
public class Posicoes {
	private int x;
	private int y;

	public Posicoes(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Metodo para retorno da posição X"
	 * 
	 * @return int - valor da coordenada X.
	 */
	public int getX() {
		return x;
	}

	/**
	 * Metodo para modificar valor da posição X"
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Metodo para retorno da posição Y"
	 * 
	 * @return int - valor da coordenada Y.
	 */
	public int getY() {
		return y;
	}

	/**
	 * Metodo para modificar valor da posição Y"
	 */

	public void setY(int y) {
		this.y = y;
	}

}
