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
        int opcao = 0;
        Scanner s = new Scanner(System.in);
        TipoJogo jogo = null;
        Posicoes positionHelper = new Posicoes(0, 0);
        while(true){
        	printMenu();
        	try{
        		opcao = s.nextInt();
        		switch (opcao) {
				case 1:
					System.out.println("Criando novo jogo....\n Entre com o tamanho do tabuleiro:");
					int tamanhoTabuleiro = s.nextInt();
					jogo = new Tradicional(2, tamanhoTabuleiro);
					System.out.println("Jogo do tipo Tradicional criado!");
					break;
				case 2:
					System.out.println("Entre com o numero do jogador(0 ou 1):");
					int jogador = s.nextInt();
					System.out.println("Entre com a posicao:");
					String posi = s.next();
					positionHelper.setX(Integer.parseInt((posi.split(",",2))[0]));
					positionHelper.setX(Integer.parseInt((posi.split(",",2))[1]));
					System.out.println("Entre com o tipo da peça:");
					String tipoNavio = s.next();
					jogo.distribui(jogador, positionHelper, tipoNavio);
					System.out.println("Distribuição feita!");
					jogo.mostraTabuleiro(jogador);
					break;
				case 4:
					jogo.mostraTabuleiro(0);
					System.out.println("\n E...\n");
					jogo.mostraTabuleiro(1);
					break;
				case 9:
					System.out.println("Saindo....");
					break;
				default:
					System.out.println("Opcao inválida!");
					break;
				}
        	}catch(InputMismatchException e){
        		System.out.println("Opcao inválida!");
        	}
        	if(opcao == 9) break;
        }
        s.close();
        System.out.println("-----Program end?------");
    }
    
    private static void printMenu(){
    	System.out.println("Entre com um número:");
    	System.out.println("[1]-Cria novo jogo/tabuleiro");
    	System.out.println("[2]-Distribui pedaço de um barco");
    	System.out.println("[3]-Atira em uma posição");
    	System.out.println("[4]-Mostra os tabuleiros");
    	System.out.println("[9]-Sair");
    }
}
