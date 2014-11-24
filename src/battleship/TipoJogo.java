package battleship;

public interface TipoJogo {
	
	public void criaJogadores();
	public boolean atira(int jogador, Posicoes posicao, boolean sinalizadora);
	public void distribui(int jogador, Posicoes posicao, int tipoNavio, String direcao, int TamanhoTabuleiro, int tipoDistribuicao);
	public int getWinnerNumber();
	public void printTabuleiro(int jogador);
	public void setPreenchido(int jogador);
    public boolean getPreenchido(int jogador);
    public int getTamanhoTabuleiro();
    public boolean isGameOver();
    public Tabuleiro[][] getTabuleiro(int jogador);
    public int getNumTurnos(int jogador);
	
}
