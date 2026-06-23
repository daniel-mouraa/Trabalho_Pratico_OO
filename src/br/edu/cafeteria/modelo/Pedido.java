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
	private boolean pago = false;
	
	public Pedido(String nomeAtendente) {
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
		if (qtd <= 0) {
			throw new EstoqueInsuficienteException("A quantidade deve ser maior que zero!");
		}
		if (p.getEstoque() < qtd) {
			throw new EstoqueInsuficienteException("Estoque insuficiente! Temos apenas " + p.getEstoque());
		}
		if (this.pago) {
			System.out.println("Erro! Pedido ja fechado!");
			return;
		}
		ItemPedido novoItem = new ItemPedido(p, qtd);
		this.itens.add(novoItem);
		p.setEstoque(p.getEstoque() - qtd);
	}
	public void removerItem (int codigo) {
		ItemPedido itemRemover = null;
		for (ItemPedido item : this.itens) {
			if(item.getProduto().getCodigo() == codigo) {
				itemRemover = item;
				break;
			}
		}
		if(itemRemover != null) {
			this.itens.remove(itemRemover);
			System.out.println("Produto removido!");
		}
		else {
			System.out.println("Produto nao esta na comanda!");
		}
	}
	public void exibirExtrato() {
		System.out.println("====================== \n" +
							"Extrato da comanda " + this.numeroSequencial +
							"==================== \n");
		if (this.cliente != null) {
			System.out.println("Cliente: " + this.cliente.getNome());
		}else {
			System.out.println("Cliente: Anonimo");
		}
		System.out.println("Atendente: " + nomeAtendente);
		if(this.pago) {
			System.out.println("Status: Paga e Fechada!");
		}
		else {
			System.out.println("Status: Aberta!");
		}
		
		System.out.println("----- ITENS CONSUMIDOS -----");
		if (this.itens.isEmpty()) {
			System.out.println("Nenhum item lancado");
		}
		else {
			for(ItemPedido item : this.itens) {
				System.out.println("- " + item.getProduto().getNome() + "x " + item.getQtd());
			}
		}
		System.out.println("================================");
	}
	
	public void finalizarPagamento() {
		this.pago = true;
		System.out.println("Pedido finalizado com sucesso!");
	}
	
	public void setNomeAtendente(String nomeAtendente) {
		this.nomeAtendente = nomeAtendente;
	}

	public static int getGeradorDeNumero() {
		return geradorDeNumero;
	}

	public int getNumeroSequencial() {
		return numeroSequencial;
	}

	public List<ItemPedido> getItens() {
		return itens;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public String getNomeAtendente() {
		return nomeAtendente;
	}

	public double calcularTotal() {
		double total = 0.0;
		
		for(ItemPedido item : this.itens) {
			total = total + item.calcularSubtotal();
		}
		return total;
	}
	
	public boolean isPago() {
		return this.pago;
	}
	
	
}