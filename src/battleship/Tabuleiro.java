/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

/**
 * Interface que declara metodos para manipulação do Tabuleiro.
 * 
 * @author Lucas Henrique, Yuri Matheus
 */
public interface Tabuleiro {
	public String mostrar();

	public int getType();

	public void setVisibility(boolean flag);
}
