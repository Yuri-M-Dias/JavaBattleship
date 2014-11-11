/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

/**
 *
 * @author root
 */
public class BattleShip {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PosicaoTabuleiro ps[][] = new PosicaoTabuleiro[9][9];
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                ps[i][j] = new Agua();
            }
        }
        
        ps[0][0] = new Navio();
        ps[0][0] = new Submarino(ps[0][0]);
        ps[0][2] = new Navio();
        ps[0][2] = new Submarino(ps[0][2]);
        ps[0][3] = new Navio();
        ps[0][3] = new PortaAvioes(ps[0][3]);
        ps[0][3]= new Navio();
        ps[0][4] = new BarcoDois(ps[0][4]);
        ps[0][4] = new BombaDestruidora(ps[0][4]);
        ps[0][0] = new BarcoTres(ps[0][0]);
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(ps[i][j].getDescription()+"\t");
            }
            System.out.println("");
        }
    }
}
