/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

import java.util.InputMismatchException;
import java.util.Scanner;

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
        int opcao = 0;
        Scanner s = new Scanner(System.in);
        
        for (int i = 0; i < 9; i++) {//Inicializar as posições do tabuleiro
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
        
        while(true){
        	printMenu();
        	try{
        		opcao = s.nextInt();
        		switch (opcao) {
				case 1:
					System.out.println("Criando novo jogo....");
					
					break;

				default:
					System.out.println("Opcao inválida!");
					break;
				}
        	}catch(InputMismatchException e){
        		System.out.println("Opcao inválida!");
        	}
        }
    }
    
    private static void printMenu(){
    	System.out.println("Entre com um número:");
    	System.out.println("[1]-Cria novo jogo/tabuleiro");
    	System.out.println("[2]-Distribui pedaço de um barco");
    	System.out.println("[3]-Atira em uma posição");
    	System.out.println("[4]-Reseta o tabuleiro");
    	System.out.println("[9]-Sair");
    }
}
