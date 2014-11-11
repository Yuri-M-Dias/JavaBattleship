package battleship;

public class DistribuirAutomatico implements TipoDistribuicao {

	@Override
	public PosicaoTabuleiro[][] distribuir(PosicaoTabuleiro[][] tabuleiro, Posicoes posicao, String tipoNavio) {
		PosicaoTabuleiro[][] tabuleiroNovo = tabuleiro;
		return tabuleiroNovo;
	}

}
