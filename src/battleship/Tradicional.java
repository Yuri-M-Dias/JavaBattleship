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
    private int turnosFeitos;

	public Tradicional(int numberPlayers, int tamanhoTabuleiro){
        this.numberPlayers = numberPlayers;
        this.tamanhoTabuleiro = tamanhoTabuleiro;
        criaJogadores();
        this.turnosFeitos =0;
    }
    
    @Override
    public void criaJogadores(){
        for(int i = 0; i <= this.numberPlayers-1; i++){
            this.jogadores[i] = new Jogador(this.tamanhoTabuleiro);
        }
    }

	@Override
	public boolean atira(int jogador, Posicoes posicao) {
		//Checa se ele já foi atirado antes, se é x ou X
		String checagem = this.jogadores[jogador].getTabuleiro()[posicao.getX()][posicao.getY()].mostrar();
		if(!checagem.equals("X") && !checagem.equals("*")){
			this.jogadores[jogador].atira(posicao);
			return true; //Null return, just to make it leave the function
		}
		return false;
	}

	@Override
	public void distribui(int jogador, Posicoes posicao, int tipoNavio, String direcao, int tamanhoTabuleiro, int tipoDistribuicao) {
		this.jogadores[jogador].distribui(posicao, tipoNavio,direcao, tamanhoTabuleiro, tipoDistribuicao);
	}

	@Override
	public void mostraTabuleiro(int jogador) {
		this.jogadores[jogador].mostraTabuleiro();
		
	}

	@Override
	public void facaTurno() {
		
		this.turnosFeitos++;
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
	public boolean getGameOver() {
		if (this.jogadores[0].haNaviosRestantes()) {
			System.out.println("player 1 won!");
			return true;
		} else if (this.jogadores[1].haNaviosRestantes()) {
			System.out.println("player 0 won!");
			return true;
		}
		return false;
	}

	@Override
	public Tabuleiro[][] getTabuleiro(int jogador) {
		return this.jogadores[jogador].getTabuleiro();
	}
	
}
