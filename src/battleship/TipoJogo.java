package battleship;

public interface TipoJogo {
	
	public void registraJogadores();
	public boolean atira(int jogador, Posicoes posicao, boolean sinalizadora);
	public boolean distribui(int jogador, Posicoes posicao, int tipoNavio, String direcao, int TamanhoTabuleiro, int tipoDistribuicao);
	public int getWinnerNumber();
	public void printTabuleiro(int jogador);
	public void setPreenchido(int jogador);
    public boolean getPreenchido(int jogador);
    public int getTamanhoTabuleiro();
    public boolean isGameOver();
    public Tabuleiro[][] getTabuleiro(int jogador);
    public int getNumTurnos(int jogador);
	public void notificaJogadores();
	
}
