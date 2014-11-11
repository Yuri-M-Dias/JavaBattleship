/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

/**
 *
 * @author root
 */
public class Jogo {
    private int numberPlayers;
    private Jogador[] jogadores;
    
    public void Jogo(int numberPlayers){
        this.numberPlayers = numberPlayers;
        criaJogadores(numberPlayers);
    }
    
    private void criaJogadores(int numberPlayers){
        for(int i = 0; i <= numberPlayers; i++){
            jogadores[i] = new Jogador();
        }
    }
    
    
}
