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
    
    public void distribui(Posicoes posicao, int tipoNavio){
    	this.tabuleiro = this.distribuicao.distribuir(this.tabuleiro, posicao, tipoNavio);
    }
    
    public void atira(Posicoes posicao){
    	this.tabuleiro[posicao.getX()][posicao.getY()] = new BombaDestruidora(this.tabuleiro[posicao.getX()][posicao.getY()]);
    }
    
    public PosicaoTabuleiro[][] getTabuleiro(){
        return tabuleiro;
    }
    
    public void mostraTabuleiro(){
    	for (int i = 0; i < this.tamanhoTabuleiro; i++) {
            for (int j = 0; j < this.tamanhoTabuleiro; j++) {
                System.out.print(this.tabuleiro[i][j].mostrar()+" ");
            }
            System.out.println("");
        }
    }
    
}
