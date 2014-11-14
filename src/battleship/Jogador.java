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
    
    private Tabuleiro tabuleiro[][];
    private int tamanhoTabuleiro;
    private TipoDistribuicao distribuicao;
    
    public Jogador(int tamanhoTabuleiro){
    	this.tamanhoTabuleiro = tamanhoTabuleiro;
    	this.tabuleiro = new Tabuleiro[this.tamanhoTabuleiro][this.tamanhoTabuleiro];
        for (int i = 0; i < this.tamanhoTabuleiro; i++) {
            for (int j = 0; j < this.tamanhoTabuleiro; j++) {
                this.tabuleiro[i][j] = new Agua();
            }
        }
        this.distribuicao = new DistribuirManual();
    }
    
    public void distribui(Posicoes posicao, int tipoNavio){
    	this.tabuleiro = this.distribuicao.distribuir(this.tabuleiro, posicao, tipoNavio);
    }
    
    public void atira(Posicoes posicao){
    	this.tabuleiro[posicao.getX()][posicao.getY()] = new BombaDestruidora(this.tabuleiro[posicao.getX()][posicao.getY()]);
    }
    
    public Tabuleiro[][] getTabuleiro(){
        return tabuleiro;
    }
    
    public void mostraTabuleiro(){
    	for (Tabuleiro d1tabu[]: this.tabuleiro) {
            for (Tabuleiro tabu: d1tabu) {
                System.out.print(tabu.mostrar()+" ");
            }
            System.out.println("");
        }
    }
    
}
