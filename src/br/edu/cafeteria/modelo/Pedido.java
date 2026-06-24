package br.edu.cafeteria.modelo;
import java.util.ArrayList;
import java.util.List;

import br.edu.cafeteria.excecao.EstoqueInsuficienteException;
import br.edu.cafeteria.servico.Promocional;

public class Pedido implements Promocional{
	private static int geradorDeNumero = 1;
	private int numeroSequencial;
	private List<ItemPedido> itens;
	private Cliente cliente;
	private String nomeAtendente;
	private double percentualDescontoBebidas = 0.0;
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
		if (this.pago) {
			System.out.println("Erro! Pedido ja fechado!");
			return;
		}
		if (qtd <= 0) {
			throw new EstoqueInsuficienteException("A quantidade deve ser maior que zero!");
		}
		if (p.getEstoque() < qtd) {
			throw new EstoqueInsuficienteException("Estoque insuficiente! Temos apenas " + p.getEstoque());
		}
		for (ItemPedido item : itens) {
			if(item.getProduto().getCodigo() == p.getCodigo()) {
				int quantidadeAntiga = item.getQtd();
				item.setQtd(quantidadeAntiga + qtd);
				
				p.setEstoque(p.getEstoque() - qtd);
				return;
			}
		}
		ItemPedido novoItem = new ItemPedido(p, qtd);
		this.itens.add(novoItem);
		p.setEstoque(p.getEstoque() - qtd);
	}
	public void removerItem (int codigo, int qtdRemover){
		ItemPedido itemRemover = null;
		for (ItemPedido item : this.itens) {
			if(item.getProduto().getCodigo() == codigo) {
				itemRemover = item;
				break;
			}
		}
		if(itemRemover == null) {
			System.out.println("Produto nao esta na comanda!");
			return;
		}
		if (qtdRemover <= 0) {
			System.out.println("A quantidade a ser removida tem que ser maior que 0!");
			return;
		}
		int quantidadeAtual = itemRemover.getQtd();
		if(qtdRemover > quantidadeAtual) {
			System.out.println("Erro! tentou-se remover mais do que existe na comanda.");
			return;
		}
		int novaQuantidade = quantidadeAtual - qtdRemover;
		if(novaQuantidade == 0) {
			this.itens.remove(itemRemover);
			System.out.println("Produto completamente removido!");
		}else {
			itemRemover.setQtd(novaQuantidade);
			System.out.println("Quantidade atualizada! Agora existem: " + novaQuantidade);
		}
		
		Produto p = itemRemover.getProduto();
		p.setEstoque(p.getEstoque() + qtdRemover);
	}
	public void exibirExtrato() {
		System.out.println("====================== " +
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
				System.out.println("- " +"[Cod: " + item.getProduto().getCodigo() +"] " + 
			    item.getProduto().getNome() + " (" + item.getQtd() + "x)");
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
			Produto prod = item.getProduto();
			double subTotalItem = item.calcularSubtotal();
			
			if(prod instanceof Bebida && this.percentualDescontoBebidas > 0 ) {
				double valorDesconto = subTotalItem * (this.percentualDescontoBebidas / 100);
				subTotalItem -= valorDesconto;
			}
			total += subTotalItem;
		}
		return total;
	}
	
	public boolean isPago() {
		return this.pago;
	}

	
	public void aplicarDescontoBebidas(double porcentagem) {
		this.percentualDescontoBebidas = porcentagem;
	}
	
	
}