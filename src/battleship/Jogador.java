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
        this.distribuicao = new DistribuirManual();
    }
    
    public void distribui(Posicoes posicao, String tipoNavio){
    	this.tabuleiro = this.distribuicao.distribuir(this.tabuleiro, posicao, tipoNavio);
    }
    
    public void atira(String posi){
    	
    }
    
    public PosicaoTabuleiro[][] getTabuleiro(){
        return tabuleiro;
    }
    
    public void mostraTabuleiro(){
    	for (int i = 0; i < this.tamanhoTabuleiro; i++) {
            for (int j = 0; j < this.tamanhoTabuleiro; j++) {
                System.out.print(this.tabuleiro[i][j].getDescription()+" ");
            }
            System.out.println("");
        }
    }
    
}
