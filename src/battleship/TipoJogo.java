package battleship;

public interface TipoJogo {
	
	public void criaJogadores();
	public boolean atira(int jogador, Posicoes posicao);
	public void distribui(int jogador, Posicoes posicao, int tipoNavio, String direcao, int TamanhoTabuleiro, int tipoDistribuicao);
	public void facaTurno();
	public void mostraTabuleiro(int jogador);
	public void setPreenchido(int jogador);
    public boolean getPreenchido(int jogador);
    public int getTamanhoTabuleiro();
    public boolean getGameOver();
	
}
