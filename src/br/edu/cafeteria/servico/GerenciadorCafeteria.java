package br.edu.cafeteria.servico;
import java.util.ArrayList;
import java.util.List;

import br.edu.cafeteria.modelo.Cliente;
import br.edu.cafeteria.modelo.Pedido;
import br.edu.cafeteria.modelo.Produto;

public class GerenciadorCafeteria {
	private List<Cliente> listaClientes;
	private List<Produto> listaProdutos;
	private List<Pedido> listaPedidos;
	
	public GerenciadorCafeteria() {
		this.listaClientes = new ArrayList<>();
		this.listaProdutos = new ArrayList<>();
		this.listaPedidos = new ArrayList<>();
	}
	
	public void cadastrarClientes(Cliente c) {
		this.listaClientes.add(c);
		System.out.println("Cliente Cadastrado com sucesso!");
	}
	
	public Cliente buscarClientePorCpf(String cpf) {
		for(Cliente a : listaClientes) {
			if (a.getCpf().equals(cpf)) {
				return a;
			}
		}
		return null;
	}
	
	public void removerCliente(String cpf) {
		Cliente clienteEncontrado = buscarClientePorCpf(cpf);
		
		if (clienteEncontrado != null) {
			this.listaClientes.remove(clienteEncontrado);
			System.out.println("Cliente removido com sucesso!");
		}
		else {
			System.out.println("Erro: Nenhum cliente encontrado para ser removido.");
		}
	}
	
	public void atualizarCliente(String cpf, String novoNome) {
		Cliente clienteEncontrado = buscarClientePorCpf(cpf);
		
		if(clienteEncontrado != null) {
			clienteEncontrado.setNome(novoNome);
			System.out.println("Dados do Cliente atualizados!");
		}
		else {
			System.out.println("Erro: nenhum cliente encontrado com esse CPF!");
		}
	}
	
	public void cadastrarProdutos(Produto p) {
		this.listaProdutos.add(p);
		System.out.println("Produto Cadastrado com sucesso!");
	}
	
	 public Produto buscarProdutoPorCodigo (int codigo) {
		 for (Produto p : listaProdutos) {
			 if(p.getCodigo() == codigo) {
				 return p;
			 }
		 }
		 return null;
	 }
	 
	 public void removerProduto (int codigo) {
		 Produto produtoEncontrado = buscarProdutoPorCodigo(codigo);
		 
		 if (produtoEncontrado != null) {
			 this.listaProdutos.remove(produtoEncontrado);
			 System.out.println("Produto removido com sucesso!");
		 }
		 else {
			 System.out.println("Erro: nenhum produto encontrado para ser removido!");
		 } 
	 }
	 
	 public void atualizarProduto (int codigo, int novoPreco) {
		 Produto produtoEncontrado = buscarProdutoPorCodigo(codigo);
		 if (produtoEncontrado != null) {
			 produtoEncontrado.setPreco(novoPreco);
			 System.out.println("Preco do produto atualizado com Sucesso!");
		 }
		 else {
			 System.out.println("Nenhum produto a ser atualizado!");
		 }
	 }
	 
	 public void cadastrarPedido (Pedido e) {
		 this.listaPedidos.add(e);
		 System.out.println("Pedido incluido com sucesso!");
	 }
	 
	 public Pedido buscarPedidoPorNumero (int comanda) {
		 for (Pedido e : listaPedidos) {
			 if(e.getNumeroSequencial() == comanda) {
				 return e;
			 }
		 }
		 return null;
	 }
	 
	 public void removerPedido (int comanda) {
		 Pedido pedidoEncontrado = buscarPedidoPorNumero(comanda);
		 
		 if (pedidoEncontrado != null) {
			 this.listaPedidos.remove(pedidoEncontrado);
			 System.out.println("Pedido removido com sucesso!");
		 }
		 else {
			 System.out.println("Erro: nenhum pedido a ser removido!");
		 }
	 }
	 
	 public void atualizarPedido (int comanda, String novoAtendente) {
		 Pedido pedidoEncontrado = buscarPedidoPorNumero(comanda);
		 
		 if (pedidoEncontrado != null) {
			 pedidoEncontrado.setNomeAtendente(novoAtendente);
			 System.out.println("Atendente atualizado com sucesso!");
		 }
		 else {
			 System.out.println("Nenhum pedido a ser alterado!");
		 }
	 }
}