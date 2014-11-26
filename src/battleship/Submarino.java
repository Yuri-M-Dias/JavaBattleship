/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

/**
 * Classe para objetos do tipo Submarino que ocupa 1 posicão onde estão contidos
 * atributos e métodos para o mesmo. Objetos desta classe decoram o tabuleiro.
 * 
 * @author Lucas Henrique, Yuri Matheus
 */
public class Submarino extends TabuleiroDecorator {
	public Submarino(Tabuleiro posicaoDecorada) {
		super(posicaoDecorada);
	}

	/**
	 * Metodo para retorno do símbolo relacionado ao objeto Submarino em
	 * determinado instante do jogo, caso a posicao esteja visível ao jogador
	 * será mostrado "1" senão será mostrado "-"
	 * 
	 * @return String - símbolo do objeto.
	 */
	@Override
	public String mostrar() {
		if (super.visible) {
			return getType() + "";
		}
		return "-";
	}

	/**
	 * Metodo para retorno do valor relacionado ao objeto PortaAvioes.
	 * 
	 * @return int - valor referente ao objeto Submarino (1)
	 */
	@Override
	public int getType() {
		return 1;
	}

}
