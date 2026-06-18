package br.edu.cafeteria.modelo;
import java.util.ArrayList;
import java.util.List;

import br.edu.cafeteria.excecao.EstoqueInsuficienteException;

public class Pedido {
	private static int geradorDeNumero = 1;
	private int numeroSequencial;
	private List<ItemPedido> itens;
	private Cliente cliente;
	private String nomeAtendente;
	
	public Pedido(String nomeAtendente) { //para quem eh cliente sem cadastro
		this.nomeAtendente = nomeAtendente;
		this.cliente = null;
		this.numeroSequencial = geradorDeNumero++;
		
		this.itens = new ArrayList<>();
	}
	
	public Pedido(Cliente cliente, String nomeAtendente) {
		this.numeroSequencial = geradorDeNumero++;
		this.cliente = cliente;
		this.nomeAtendente = nomeAtendente;
		
		this.itens = new ArrayList<>();
	}
	
	public void adicionarItem (Produto p, int qtd)throws EstoqueInsuficienteException {
		if (qtd < p.getEstoque()) {
			throw new EstoqueInsuficienteException("Estoque insuficiente");
		}
		
		ItemPedido novoItem = new ItemPedido(p, qtd);
		this.itens.add(novoItem);
		p.setEstoque(p.getEstoque() - qtd);
	}
	
	public double calcularTotal() {
		double total = 0.0;
		
		for(ItemPedido item : this.itens) {
			total = total + item.calcularSubtotal();
		}
		return total;
	}
	
	
}