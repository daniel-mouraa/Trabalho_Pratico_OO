package br.edu.cafeteria.modelo;

public abstract class Produto {

	private double preco;
	private int codigo, estoque;
	private String nome;
	
	public Produto(int codigo, String nome, double preco, int estoque) {
		this.codigo = codigo;
		this.nome = nome;
		this.preco = preco;
	}
	
	public double getPreco() {
		return this.preco;
	}

	public int getCodigo() {
		return codigo;
	}

	public int getEstoque() {
		return estoque;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getNome() {
		return nome;
	}

	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}
}
