/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

/**
 *
 * @author root
 */
public class Tradicional implements TipoJogo{
    private int numberPlayers;
    private Jogador[] jogadores = new Jogador[2];
    private int tamanhoTabuleiro;
    private int winnerPlayer;

	public Tradicional(int numberPlayers, int tamanhoTabuleiro){
        this.numberPlayers = numberPlayers;
        this.tamanhoTabuleiro = tamanhoTabuleiro;
        registraJogadores();
        this.winnerPlayer = 9;
    }
    
    @Override
    public void registraJogadores(){
        for(int i = 0; i <= this.numberPlayers-1; i++){
            this.jogadores[i] = new Jogador(this.tamanhoTabuleiro, this.tamanhoTabuleiro*this.tamanhoTabuleiro);
        }
    }

	@Override
	public boolean atira(int jogador, Posicoes posicao, boolean sinalizadora) {
		return this.jogadores[jogador].atira(posicao, false);
	}

	@Override
	public boolean distribui(int jogador, Posicoes posicao, int tipoNavio,
			String direcao, int tamanhoTabuleiro, int tipoDistribuicao) {
		if (this.jogadores[jogador].distribui(posicao, tipoNavio, direcao,
				tamanhoTabuleiro, tipoDistribuicao)) {
			printTabuleiro(jogador);
			return true;
		}
		return false;
	}

	@Override
	public void printTabuleiro(int jogador) {
		System.out.println("Tabuleiro de "+ jogador);
		this.jogadores[jogador].printTabuleiro();
	}

	@Override
	public int getWinnerNumber() {
		return this.winnerPlayer;
	}
	
	@Override
	public void setPreenchido(int jogador){
		this.jogadores[jogador].setPreenchido();
	}
	
	@Override
	public boolean getPreenchido(int jogador){
		 return this.jogadores[jogador].getPreenchido();
	 }
	@Override
	public int getTamanhoTabuleiro(){
		return this.tamanhoTabuleiro;
	}
	
	@Override
	public boolean isGameOver() {
		for (int i = 0; i < this.numberPlayers; i++) {
			if (this.jogadores[i].getAcabaramNavios()) {
				this.winnerPlayer = (i == 1)? 0 : 1;
				notificaJogadores();
				return true;
			}
		}
		return false;
	}
	
	@Override
	public void notificaJogadores(){
		for (int i = 0; i < this.numberPlayers; i++) {
			this.jogadores[i].updateFimDoJogo();
		}
	}

	@Override
	public Tabuleiro[][] getTabuleiro(int jogador) {
		return this.jogadores[jogador].getTabuleiro();
	}

	@Override
	public int getNumTurnos(int jogador) {
		return this.jogadores[jogador].getNumeroTurnos();
	}
	
}
