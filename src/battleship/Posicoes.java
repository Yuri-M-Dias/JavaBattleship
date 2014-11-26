package battleship;

/**
 * Classe para objetos do tipo Posicoes onde est�o contidos atributos e m�todos
 * para o mesmo. Objetos criados para facilitar a comunica��o entre classes e
 * m�todos.
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
	 * Metodo para retorno da posi��o X"
	 * 
	 * @return int - valor da coordenada X.
	 */
	public int getX() {
		return x;
	}

	/**
	 * Metodo para modificar valor da posi��o X"
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Metodo para retorno da posi��o Y"
	 * 
	 * @return int - valor da coordenada Y.
	 */
	public int getY() {
		return y;
	}

	/**
	 * Metodo para modificar valor da posi��o Y"
	 */

	public void setY(int y) {
		this.y = y;
	}

}