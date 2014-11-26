/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

/**
 * Classe para objetos do tipo Barco que ocupa 3 posicoes onde estão contidos
 * atributos e métodos para o mesmo. Objetos desta classe decoram o tabuleiro.
 *
 * @author Lucas Henrique, Yuri Matheus
 */
public class BarcoTres extends TabuleiroDecorator{
    public BarcoTres (Tabuleiro posicaoDecorada){
        super(posicaoDecorada);
    }
    /**
	 * Metodo para retorno do símbolo relacionado ao objeto Barco Tres em
	 * determinado instante do jogo, caso a posicao esteja visível ao jogador
	 * será mostrado "3" senão será mostrado "-"
	 * 
	 * @return String - símbolo do objeto.
	 */
    @Override
    public String mostrar(){
    	if (super.visible) {
    		return getType()+"";
		}
    	return "-";
    }
    /**
	 * Metodo para retorno do valor relacionado ao objeto BarcoTres.
	 * 
	 * @return int - valor referente ao objeto BarcoTres (3)
	 */
    
    @Override
    public int getType(){
        return 3;
    }
    
}
