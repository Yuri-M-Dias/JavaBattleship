/**
 * 
 */
package battleship;

import java.util.Iterator;

/**
 * @author Yuri
 * 
 */
public class TabuleiroIterator implements Iterator<Tabuleiro> {
	private int x;
	private int y;
	private Tabuleiro tabuleiro[][];
	private int tamanhoTabuleiro;

	/**
	 * 
	 */
	public TabuleiroIterator(Tabuleiro[][] tabuleiro, int tamanhoTabuleiro) {
		this.x = 0;
		this.y = 0;
		this.tabuleiro = tabuleiro;
		this.tamanhoTabuleiro = tamanhoTabuleiro;
	}

	@Override
	public boolean hasNext() {
		return !((x*y >= tabuleiro.length) || this.tabuleiro[x][y] == null);
	}

	@Override
	public Tabuleiro next() {
		Tabuleiro placeholder = this.tabuleiro[x][y];
		this.y++;
		if (this.y >= this.tamanhoTabuleiro) {
			this.y = 0;
			this.x++;
		}
		return placeholder;
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub

	}

}
