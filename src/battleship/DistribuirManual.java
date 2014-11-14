package battleship;

import java.util.ArrayList;

public class DistribuirManual implements TipoDistribuicao {
	
	private ArrayList<String> naviosNames;
	
	public DistribuirManual(){
		
	}
	
	@Override
	public PosicaoTabuleiro[][] distribuir(PosicaoTabuleiro[][] tabuleiro, Posicoes posicao, int tipoNavio) {
		String name = tabuleiro[posicao.getX()][posicao.getY()].getClass().getName();
		System.out.println(name);
		switch(tipoNavio){
			case 1://Submarino
				tabuleiro[posicao.getX()][posicao.getY()] = new Submarino(tabuleiro[posicao.getX()][posicao.getY()]);
				break;
			case 2://BarcoDois
				for (int i = 0; i < 2; i++) {
					tabuleiro[posicao.getX()][posicao.getY()+i] = new BarcoDois(tabuleiro[posicao.getX()][posicao.getY()+i]);
				}
				break;
			case 3://BarcoTres
				for (int i = 0; i < 3; i++) {
					tabuleiro[posicao.getX()][posicao.getY()+i] = new BarcoTres(tabuleiro[posicao.getX()][posicao.getY()+i]);
				}
				break;
			case 4://BarcoQuatro
				for (int i = 0; i < 4; i++) {
					tabuleiro[posicao.getX()][posicao.getY()+i] = new BarcoQuatro(tabuleiro[posicao.getX()][posicao.getY()+i]);
				}
				break;
			case 5://PortaAvioes
				for (int i = 0; i < 5; i++) {
					tabuleiro[posicao.getX()][posicao.getY()+i] = new PortaAvioes(tabuleiro[posicao.getX()][posicao.getY()+i]);
				}
				break;
			default:
				tabuleiro[posicao.getX()][posicao.getY()] = new Submarino(tabuleiro[posicao.getX()][posicao.getY()]);
				break;
		}
		name = tabuleiro[posicao.getX()][posicao.getY()].getClass().getName();
		System.out.println(name);
		return tabuleiro;
	}

}
