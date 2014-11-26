package battleship;

/**
 * Classe que descreve comportamento do tipo Bomba Reveladora. Ao ser lancada
 * bomba reveladora o simbolo da posi��o � revelado ao jogador.
 * 
 * @author Lucas Henrique, Yuri Matheus
 */

public class BombaReveladora extends TabuleiroDecorator {

	public BombaReveladora(Tabuleiro posicaoDecorada) {
		super(posicaoDecorada);
		super.setVisibility(true);
	}
}
