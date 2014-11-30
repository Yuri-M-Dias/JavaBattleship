/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 
 * @author root
 */
public class Jogador {

	private Tabuleiro tabuleiro[][];
	private int tamanhoTabuleiro;
	private TipoDistribuicao distribuicao;
	private boolean preenchido;
	private boolean gameEnded;
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
		this.gameEnded = false;
		this.turnosFeitos = 0;
		this.bombas = new ArrayList<String>();
		for (int i = 0; i < quantidadeBombas; i++) {
			this.bombas.add("destruidora");
			this.bombas.add("reveladora");
		}
	}

	public boolean distribui(Posicoes posicao, int tipoNavio, String direcao,
			int tamanhoTabuleiro, int tipoDistribuicao) {
		if (gameEnded)
			return false;
		if (tipoDistribuicao == 0) {
			this.distribuicao = new DistribuirAutomatico();
		} else {
			this.distribuicao = new DistribuirManual();
		}

		Tabuleiro[][] novoTabuleiro = this.distribuicao.distribuir(
				this.tabuleiro, posicao, tipoNavio, direcao, tamanhoTabuleiro);
		if (this.tabuleiro == novoTabuleiro)// Verifica se os objetos são
											// iguais.
			return false;
		this.tabuleiro = novoTabuleiro;// Se não são, atualiza o tabuleiro e
										// conseguiu distribuir.
		return true;
	}

	public boolean atira(Posicoes posicao, boolean reveladora) {
		if (!gameEnded) {
			if (!this.tabuleiro[posicao.getX()][posicao.getY()].mostrar()
					.equals("X")
					&& !this.tabuleiro[posicao.getX()][posicao.getY()]
							.mostrar().equals("*")) {
				if (reveladora) {
					if (this.bombas.remove("reveladora"))
						this.tabuleiro[posicao.getX()][posicao.getY()] = new BombaReveladora(
								this.tabuleiro[posicao.getX()][posicao.getY()]);
					else
						return false;
				} else {
					if (this.bombas.remove("destruidora"))
						this.tabuleiro[posicao.getX()][posicao.getY()] = new BombaDestruidora(
								this.tabuleiro[posicao.getX()][posicao.getY()]);
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
		for (Tabuleiro tabuleiroDeUmaDimensao[] : this.tabuleiro) {
			for (Tabuleiro tabu: tabuleiroDeUmaDimensao) {
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
		Iterator<Tabuleiro> tabuleiroIterator = new TabuleiroIterator(
				this.tabuleiro, this.tamanhoTabuleiro);
		while (tabuleiroIterator.hasNext()) {
			Tabuleiro posicaoNoTabuleiro = tabuleiroIterator.next();
			if (posicaoNoTabuleiro.getType() != 0
					&& !posicaoNoTabuleiro.mostrar().equals("X"))
				restantes++;
		}
		return (restantes == 0);
	}

	public boolean getAcabaramBombas(boolean destruidora) {
		int qtdDestruidora = 0, qtdReveladora = 0;
		Iterator<String> iteratorBombas = this.bombas.iterator();
		while (iteratorBombas.hasNext()) {
			if (iteratorBombas.next().equals("destruidora"))
				qtdDestruidora++;
			if (iteratorBombas.next().equals("reveladora"))
				qtdReveladora++;
		}
		if (destruidora) {
			return qtdDestruidora == 0;
		}
		return qtdReveladora == 0;
	}

	public int getNumeroTurnos() {
		return this.turnosFeitos;
	}

	public void updateFimDoJogo() {
		this.gameEnded = true;
	}

	private void setInvisivel() {
		for (int i = 0; i < this.tamanhoTabuleiro; i++) {
			for (int j = 0; j < this.tamanhoTabuleiro; j++) {
				this.tabuleiro[i][j].setVisibility(false);
			}
		}
	}

}