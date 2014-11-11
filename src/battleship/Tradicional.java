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

	public Tradicional(int numberPlayers, int tamanhoTabuleiro){
        this.numberPlayers = numberPlayers;
        this.tamanhoTabuleiro = tamanhoTabuleiro;
        criaJogadores();
    }
    
    @Override
    public void criaJogadores(){
        for(int i = 0; i <= this.numberPlayers-1; i++){
            this.jogadores[i] = new Jogador(this.tamanhoTabuleiro);
        }
    }

	@Override
	public void atira(String pos) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void distribui(int jogador, Posicoes posicao, String tipoNavio) {
		this.jogadores[jogador].distribui(posicao, tipoNavio);
	}

	@Override
	public void facaTurno() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mostraTabuleiro(int jogador) {
		this.jogadores[jogador].mostraTabuleiro();
		
	}
}
