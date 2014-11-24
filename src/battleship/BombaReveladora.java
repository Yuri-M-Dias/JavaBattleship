package battleship;

public class BombaReveladora extends TabuleiroDecorator {

	public BombaReveladora(Tabuleiro posicaoDecorada) {
		super(posicaoDecorada);
		super.setVisibility(true);
	}

	@Override
	public String mostrar() {
		return super.mostrar();
	}

}
