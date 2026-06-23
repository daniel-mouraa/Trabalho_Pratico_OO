package br.edu.cafeteria.modelo;

import br.edu.cafeteria.servico.Promocional;

public class Bebida extends Produto implements Promocional{
	private String tamanho, temperatura;
	private double qtdCafeina;
	
	public Bebida(int codigo, String nome, String tamanho, String temperatura, double qtdCafeina, double preco, int estoque) {
		super(codigo, nome, preco, estoque);
		this.tamanho = tamanho;
		this.temperatura = temperatura;
		this.qtdCafeina = qtdCafeina;
	}
	
	
	public String toString() {
		return super.toString() + String.format (java.util.Locale.forLanguageTag("pt-BR")," | [BEBIDA] Tam: %s | Temp: %s | Cafeina: %.1fg",
												this.tamanho, this.temperatura, this.qtdCafeina);
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

	public void aplicarDescontoBebidas(double porcentagem) {
		double valorDesconto = this.getPreco() * (porcentagem / 100.0);
		double novoPreco = this.getPreco() - valorDesconto;
		
		this.setPreco(novoPreco);
		System.out.println("Promocao aplicada! novo preco eh: " + novoPreco);
		
	}
	

}