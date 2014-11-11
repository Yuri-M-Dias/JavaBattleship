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
    
    private PosicaoTabuleiro tabuleiro[][];
    private int tamanhoTabuleiro;
    private TipoDistribuicao distribuicao;
    
    public Jogador(int tamanhoTabuleiro){
    	this.tamanhoTabuleiro = tamanhoTabuleiro;
    	this.tabuleiro = new PosicaoTabuleiro[this.tamanhoTabuleiro][this.tamanhoTabuleiro];
        for (int i = 0; i < this.tamanhoTabuleiro; i++) {
            for (int j = 0; j < this.tamanhoTabuleiro; j++) {
                this.tabuleiro[i][j] = new Agua();
            }
        }
    }
    
    public void distribui(String posicao, PosicaoTabuleiroDecorator navio){
    	this.distribuicao.distribuir(posicao, navio);
    }
    
    public void atira(String posi){
    	
    }
    
    public PosicaoTabuleiro[][] getTabuleiro(){
        return tabuleiro;
    }
    
}
