package br.edu.cafeteria.servico;
import java.util.ArrayList;
import java.util.List;

import br.edu.cafeteria.modelo.Cliente;
import br.edu.cafeteria.modelo.ClienteVip;
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
	
	public void promoverCliente(ClienteVip novoCliente) {
		String cpfTroca = novoCliente.getCpf();
		removerCliente(cpfTroca);
		cadastrarClientes(novoCliente);
		System.out.println("Cliente promovido para Vip!");
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
	 
	 public void atualizarPrecoProduto (int codigo, double novoPreco) {
		 Produto produtoEncontrado = buscarProdutoPorCodigo(codigo);
		 if (produtoEncontrado != null) {
			 produtoEncontrado.setPreco(novoPreco);
			 System.out.println("Preco do produto atualizado com Sucesso!");
		 }
		 else {
			 System.out.println("Nenhum produto a ser atualizado!");
		 }
	 }
	 
	 public void atualizarEstoqueProduto (int codigo, int novoEstoque) {
		 Produto produtoEncontrado = buscarProdutoPorCodigo(codigo);
		 if (produtoEncontrado != null) {
			 produtoEncontrado.setEstoque(novoEstoque);
			 System.out.println("Estoque do produto atualizado com Sucesso!");
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
	 
	 public void pagarPedido(int comanda) {
		 Pedido pedido = buscarPedidoPorNumero(comanda);
		 if (pedido != null) {
			 pedido.finalizarPagamento();
		 }
		 else {
			 System.out.println("Erro: pedido nao encontrado!");
		 }
	 }
	 
	 public void exibirCardapio() {
		 if (listaProdutos.isEmpty()) {
			 System.out.println("Cardapio vazio! Cadastre os produtos antes!");
		 }
		 else {
			 System.out.println("===== CARDAPIO BYTE & BREW ======");
			 for (Produto p : listaProdutos) {
				 System.out.println("[Cod: " + p.getCodigo() + "] - " + p.getNome() + "-- R$ " + p.getPreco());
				 System.out.println("==========================");
			 }
		 }
	 }
}