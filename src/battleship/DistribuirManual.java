package battleship;

import java.util.ArrayList;

public class DistribuirManual implements TipoDistribuicao {
	
	private ArrayList<PosicaoTabuleiroDecorator> navios;
	
	public DistribuirManual(){
		
	}
	
	@Override
	public PosicaoTabuleiro[][] distribuir(PosicaoTabuleiro[][] tabuleiro, Posicoes posicao, String tipoNavio) {
		tabuleiro[posicao.getX()][posicao.getY()] = new Navio();
		tabuleiro[posicao.getX()][posicao.getY()] = new Submarino(tabuleiro[posicao.getX()][posicao.getY()]);
		return tabuleiro;
	}

}
