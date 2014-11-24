/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

import java.util.ArrayList;

/**
 * 
 * @author root
 */
public class Jogador {

	private Tabuleiro tabuleiro[][];
	private int tamanhoTabuleiro;
	private TipoDistribuicao distribuicao;
	private boolean preenchido;
	private int turnosFeitos;
	ArrayList<String> bombas;

	public Jogador(int tamanhoTabuleiro, int quantidadeBombas) {
		this.tamanhoTabuleiro = tamanhoTabuleiro;
		this.tabuleiro = new Tabuleiro[this.tamanhoTabuleiro][this.tamanhoTabuleiro];
		for (int i = 0; i < this.tamanhoTabuleiro; i++) {
			for (int j = 0; j < this.tamanhoTabuleiro; j++) {
				this.tabuleiro[i][j] = new Agua();
				this.tabuleiro[i][j].setVisibility(true);
			}
		}
		this.preenchido = false;
		this.turnosFeitos = 0;
		this.bombas = new ArrayList<String>();
		for (int i = 0; i < quantidadeBombas; i++) {
			this.bombas.add("destruidora");
			this.bombas.add("reveladora");
		}
	}

	public void distribui(Posicoes posicao, int tipoNavio, String direcao,
			int tamanhoTabuleiro, int tipoDistribuicao) {
		if (tipoDistribuicao == 0) {
			this.distribuicao = new DistribuirAutomatico();
		} else {
			this.distribuicao = new DistribuirManual();
		}

		this.tabuleiro = this.distribuicao.distribuir(this.tabuleiro, posicao,
				tipoNavio, direcao, tamanhoTabuleiro);
	}

	public boolean atira(Posicoes posicao, boolean reveladora) {
		if (!getAcabaramNavios()){
			if (!this.tabuleiro[posicao.getX()][posicao.getY()].mostrar().equals("X")
					&& !this.tabuleiro[posicao.getX()][posicao.getY()].mostrar().equals("*")) {
				if (reveladora) {
					if(this.bombas.remove("reveladora"))
						this.tabuleiro[posicao.getX()][posicao.getY()] = new BombaReveladora(this.tabuleiro[posicao.getX()][posicao.getY()]);
					else
						return false;
				}else{
					if (this.bombas.remove("destruidora"))
						this.tabuleiro[posicao.getX()][posicao.getY()] = new BombaDestruidora(this.tabuleiro[posicao.getX()][posicao.getY()]);
					else
						return false;
				}
				this.turnosFeitos++;
				return true;
			}
		}
		return false;
	}

	public Tabuleiro[][] getTabuleiro() {
		return tabuleiro;
	}

	public void printTabuleiro() {
		for (Tabuleiro d1tabu[] : this.tabuleiro) {
			for (Tabuleiro tabu : d1tabu) {
				System.out.print(tabu.mostrar() + " ");
			}
			System.out.println("");
		}
	}

	public void setPreenchido() {
		this.preenchido = true;
		setInvisivel();
	}

	public boolean getPreenchido() {
		return this.preenchido;
	}

	public boolean getAcabaramNavios() {
		int restantes = 0;
		for (Tabuleiro d1tabu[] : this.tabuleiro) {
			for (Tabuleiro tabu : d1tabu) {
				if (tabu.getType() != 0 && !tabu.mostrar().equals("X"))
					restantes++;
			}
		}
		return restantes == 0;
	}

	public boolean getAcabaramBombas(boolean destruidora) {
		int qtdDestruidora = 0, qtdReveladora = 0;
		for (String type : bombas) {
			if(type.equals("destruidora")) qtdDestruidora++;
			if(type.equals("reveladora")) qtdReveladora++;
		}
		if (destruidora) {
			return qtdDestruidora == 0;
		}
		return qtdReveladora == 0;
	}

	public int getNumeroTurnos() {
		return this.turnosFeitos;
	}

	private void setInvisivel() {
		for (int i = 0; i < this.tamanhoTabuleiro; i++) {
			for (int j = 0; j < this.tamanhoTabuleiro; j++) {
				this.tabuleiro[i][j].setVisibility(false);
			}
		}
	}

	private void calculaNumeroCasasComBarcos() {
		for (Tabuleiro d1tabu[] : this.tabuleiro) {
			for (Tabuleiro tabu : d1tabu) {
				//if (tabu.getType() != 0)
					//this.posicoesRestantes++;
			}
		}
	}

}