package battleship;

public class DistribuirAutomatico implements TipoDistribuicao {

	@Override
	public PosicaoTabuleiro[][] distribuir(PosicaoTabuleiro[][] tabuleiro, Posicoes posicao, int tipoNavio) {
		PosicaoTabuleiro[][] tabuleiroNovo = tabuleiro;
		return tabuleiroNovo;
	}

}
