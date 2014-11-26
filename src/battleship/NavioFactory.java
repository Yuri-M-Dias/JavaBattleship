package battleship;

public class NavioFactory {

	public NavioFactory() {

	}

	public Tabuleiro criaNavio(Tabuleiro[][] tabuleiro,
			Posicoes posicao, int tipoNavio) {

		switch (tipoNavio) {
		case 1:// Submarino - ocupa somente uma posicao
			return new Submarino(tabuleiro[posicao.getX()][posicao.getY()]);
		case 2:// barco de duas posicoes
			return new BarcoDois(tabuleiro[posicao.getX()][posicao.getY()]);
		case 3:// barco de tres posicoes
			return new BarcoTres(tabuleiro[posicao.getX()][posicao.getY()]);
		case 4:// barco de quatro posicoes
			return new BarcoQuatro(tabuleiro[posicao.getX()][posicao.getY()]);
		case 5:// porta avioes
			return new PortaAvioes(tabuleiro[posicao.getX()][posicao.getY()]);
		default:
			return null;
		}

	}
}
