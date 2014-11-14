package battleship;

public interface TipoDistribuicao {
	public PosicaoTabuleiro[][] distribuir(PosicaoTabuleiro[][] tabuleiro, Posicoes posicao, int tipoNavio);
}
