/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

/**
 *
 * @author root
 */
public class Jogador {
    
    private PosicaoTabuleiro tabuleiro[][] = new PosicaoTabuleiro[9][9];
    
    public void Jogador(){
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                this.tabuleiro[i][j] = new Agua();
            }
        }
    }
    
    private void distribuiAuto(){}
    
    private void distribuiManual(){}
    
    private void atira(int posX, int posY){}
    
    public PosicaoTabuleiro[][] getTabuleiro(){
        return tabuleiro;
    }
    
}
