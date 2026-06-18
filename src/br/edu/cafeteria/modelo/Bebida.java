package br.edu.cafeteria.modelo;

public class Bebida extends Produto{
	private String tamanho, temperatura;
	private double qtdCafeina;
	
	public Bebida(int codigo, String nome, String tamanho, String temperatura, double qtdCafeina, double preco, int estoque) {
		super(codigo, nome, preco, estoque);
		this.tamanho = tamanho;
		this.temperatura = temperatura;
		this.qtdCafeina = qtdCafeina;
	}
	
	public String getTamanho() {
		return this.tamanho;
	}

	public String getTemperatura() {
		return temperatura;
	}

	public double getQtdCafeina() {
		return qtdCafeina;
	}
	

}