package br.edu.cafeteria.modelo;

public class Comida extends Produto {
	private int tempoPreparo;
	private String restricao;
	
	public Comida(int codigo, String nome, double PrecoBase, int estoque, int tempoPreparo, String restricao) {
		super(codigo, nome, PrecoBase, estoque);
		this.tempoPreparo = tempoPreparo;
		this.restricao = restricao;
	}
	
	public String toString() {
		return super.toString() + String.format(java.util.Locale.forLanguageTag("pt-BR"), " | [COMIDA] Restricao: %s | Preparo: %d min",
									this.restricao, this.tempoPreparo);
	}


	public int getTempoPrep() {
		return this.tempoPreparo;
	}

	public int getTempoPreparo() {
		return tempoPreparo;
	}

	public String getRestricao() {
		return restricao;
	}

}