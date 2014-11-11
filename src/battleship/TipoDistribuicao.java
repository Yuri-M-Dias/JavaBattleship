package battleship;

public interface TipoDistribuicao {
	public PosicaoTabuleiro[][] distribuir(PosicaoTabuleiro[][] tabuleiro, Posicoes posicao, String tipoNavio);
}
