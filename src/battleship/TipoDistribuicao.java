package battleship;

/**
 * Interface que declara metodos para distribuição de embarcações
 * 
 * @author Lucas Henrique, Yuri Matheus
 */
public interface TipoDistribuicao {
	public Tabuleiro[][] distribuir(Tabuleiro[][] tabuleiro, Posicoes posicao, int tipoNavio, String direcao, int TamanhoTabuleiro);
}
