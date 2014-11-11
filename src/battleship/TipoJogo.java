package battleship;

public interface TipoJogo {
	
	public void criaJogadores();
	public void atira(String pos);
	public void distribui(int jogador, Posicoes posicao, String tipoNavio);
	public void facaTurno();
	public void mostraTabuleiro(int jogador);
	
}
