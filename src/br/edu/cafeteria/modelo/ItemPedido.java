package br.edu.cafeteria.modelo;

public class ItemPedido {
	private int qtd;
	private Produto produto;
	
	public ItemPedido(Produto produto, int qtd) {
		this.produto = produto;
		this.qtd = qtd;
	}
	
	public double  calcularSubtotal() {
		double subtotal = produto.getPreco() * qtd;
		return subtotal;
	}
}s