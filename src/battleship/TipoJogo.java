package battleship;

public interface TipoJogo {
	
	public void criaJogadores();
	public void atira(int jogador, Posicoes posicao);
	public void distribui(int jogador, Posicoes posicao, int tipoNavio);
	public void facaTurno();
	public void mostraTabuleiro(int jogador);
	
}
