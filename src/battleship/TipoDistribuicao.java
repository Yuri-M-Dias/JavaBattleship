package battleship;

public interface TipoDistribuicao {
	public Tabuleiro[][] distribuir(Tabuleiro[][] tabuleiro, Posicoes posicao, int tipoNavio, String direcao, int TamanhoTabuleiro);
}
