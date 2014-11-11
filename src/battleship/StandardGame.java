/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

/**
 *
 * @author root
 */
public class StandardGame implements TipoJogo{
    private int numberPlayers;
    private Jogador[] jogadores;
    private int tamanhoTabuleiro;

	public StandardGame(int numberPlayers, int tamanhoTabuleiro){
        this.numberPlayers = numberPlayers;
        this.tamanhoTabuleiro = tamanhoTabuleiro;
        criaJogadores();
    }
	
    public Jogador[] getJogadores() {
		return jogadores;
	}

	public void setJogadores(Jogador[] jogadores) {
		this.jogadores = jogadores;
	}
    
    @Override
    public void criaJogadores(){
        for(int i = 0; i <= this.numberPlayers; i++){
            jogadores[i] = new Jogador(this.tamanhoTabuleiro);
        }
    }

	@Override
	public void atira(String pos) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void distribui() {
		// TODO Auto-generated method stub
		
	}
    
    
}
