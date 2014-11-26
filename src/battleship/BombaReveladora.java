package battleship;

/**
 * Classe que descreve comportamento do tipo Bomba Reveladora. Ao ser lancada
 * bomba reveladora o simbolo da posição é revelado ao jogador.
 * 
 * @author Lucas Henrique, Yuri Matheus
 */

public class BombaReveladora extends TabuleiroDecorator {

	public BombaReveladora(Tabuleiro posicaoDecorada) {
		super(posicaoDecorada);
		super.setVisibility(true);
	}
}
