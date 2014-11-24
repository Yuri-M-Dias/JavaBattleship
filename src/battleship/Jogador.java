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
	private boolean preenchido;
	private int posicoesRestantes;

	public Jogador(int tamanhoTabuleiro) {
		this.tamanhoTabuleiro = tamanhoTabuleiro;
		this.tabuleiro = new Tabuleiro[this.tamanhoTabuleiro][this.tamanhoTabuleiro];
		for (int i = 0; i < this.tamanhoTabuleiro; i++) {
			for (int j = 0; j < this.tamanhoTabuleiro; j++) {
				this.tabuleiro[i][j] = new Agua();
				this.tabuleiro[i][j].setVisibility(true);
			}
		}
		this.distribuicao = new DistribuirManual();
		this.preenchido = false;
		this.posicoesRestantes = 0;
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

	public boolean atira(Posicoes posicao) {
		if (this.posicoesRestantes > 0) {
			this.tabuleiro[posicao.getX()][posicao.getY()] = new BombaDestruidora(
					this.tabuleiro[posicao.getX()][posicao.getY()]);
			if (this.tabuleiro[posicao.getX()][posicao.getY()].mostrar()
					.equals("X")) {
				this.posicoesRestantes--;
				return true;
			}
		}
		return false;
	}

	public Tabuleiro[][] getTabuleiro() {
		return tabuleiro;
	}

	public void mostraTabuleiro() {
		for (Tabuleiro d1tabu[] : this.tabuleiro) {
			for (Tabuleiro tabu : d1tabu) {
				System.out.print(tabu.mostrar() + " ");
			}
			System.out.println("");
		}
	}

	public void setPreenchido() {
		this.preenchido = true;
		calculaNumeroCasasComBarcos();
		System.out.println("Isso:"+this.posicoesRestantes);
		setInvisivel();
	}
	
	private void setInvisivel(){
		for (int i = 0; i < this.tamanhoTabuleiro; i++) {
			for (int j = 0; j < this.tamanhoTabuleiro; j++) {
				this.tabuleiro[i][j].setVisibility(false);
			}
		}
	}

	public boolean getPreenchido() {
		return this.preenchido;
	}

	public boolean haNaviosRestantes() {
		return this.posicoesRestantes <= 0;
	}

	private void calculaNumeroCasasComBarcos() {
		for (Tabuleiro d1tabu[] : this.tabuleiro) {
			for (Tabuleiro tabu : d1tabu) {
				if (tabu.getType() != 0)
					this.posicoesRestantes++;
			}
		}
	}

}