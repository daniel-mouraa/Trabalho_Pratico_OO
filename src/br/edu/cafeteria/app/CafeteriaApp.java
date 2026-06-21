package br.edu.cafeteria.app;

import java.util.Scanner;

import br.edu.cafeteria.excecao.PontosInsuficientesException;
import br.edu.cafeteria.modelo.Bebida;
import br.edu.cafeteria.modelo.Cliente;
import br.edu.cafeteria.modelo.ClienteStandard;
import br.edu.cafeteria.modelo.ClienteVip;
import br.edu.cafeteria.modelo.Comida;
import br.edu.cafeteria.modelo.Pedido;
import br.edu.cafeteria.modelo.Produto;
import br.edu.cafeteria.servico.GerenciadorCafeteria;

public class CafeteriaApp {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		GerenciadorCafeteria sistema = new GerenciadorCafeteria();
		int opcao = 0;
		
		System.out.println("Bem vindo ao Sistema Byte & Brew! \n");
		do {
			System.out.println("================ MENU PRINCIPAL ===============");
			System.out.println("1. Menu dos Clientes");
			System.out.println("2. Menu dos Produtos");
			System.out.println("3. Menu de Vendas (Pedidos)");
			System.out.println("4. Sair do Sitema");
			System.out.println("Escolha uma opcao: ");
			
			opcao = teclado.nextInt();
			teclado.nextLine();
			
			switch (opcao) {
			case 1:
				System.out.println("====== MENU DOS CLIENTES =====");
				System.out.println("1. Cadastrar novo Cliente \n");
				System.out.println("2. Buscar Cliente por CPF \n");
				System.out.println("3. Atualizar nome do Cliente \n");
				System.out.println("4. Remover Cliente \n");
				System.out.println("Escolha uma opcao: ");
				
				int opcaoCliente = teclado.nextInt();
				teclado.nextLine();
				
				if (opcaoCliente == 1) {
					System.out.println("----- CADASTRAR NOVO CLIENTE -----");
					System.out.println("Digite o nome do cliente: ");
					String nome = teclado.nextLine();
					
					System.out.println("Digite o CPF do cliente: ");
					String cpf = teclado.nextLine();
					
					ClienteStandard novoCliente = new ClienteStandard(nome, cpf);
					sistema.cadastrarClientes(novoCliente);
					
				}
				else if (opcaoCliente == 2) {
					System.out.println("----- BUSCAR CLIENTE POR CPF -----");
					System.out.println("Digite o cpf do cliente:");
					String cpf = teclado.nextLine();
					
					Cliente busca = sistema.buscarClientePorCpf(cpf);
					if (busca != null) {
						System.out.println("Cliente encontrado: " + busca.getNome());
					} else {
						System.out.println("Erro! Cliente nao encontrado");
					}
				}
				else if (opcaoCliente == 3) {
					System.out.println("----- ATUALIZAR NOME DO CLIENTE -----");
					System.out.println("Digite o CPF do cliente: ");
					String cpf = teclado.nextLine();
					
					System.out.println("Digite o nome a ser atualizado:");
					String novoNome = teclado.nextLine();
					
					sistema.atualizarCliente(cpf, novoNome);
				}
				else if (opcaoCliente == 4) {
					System.out.println("----- REMOVER CLIENTE -----");
					System.out.println("Digite o CPF do cliente a ser removido: ");
					String cpf = teclado.nextLine();
					
					sistema.removerCliente(cpf);
				}
				break;
			case 2:
				System.out.println("====== MENU DOS PRODUTOS =====");
				System.out.println("1. Cadastrar novo Produto");
				System.out.println("2. Buscar Produto por codigo");
				System.out.println("3. Atualizar preco do Produto");
				System.out.println("4. Atualizar estoque do Produto");
				System.out.println("5. Remover Produto");
				System.out.println("Escolha uma opcao: ");
				
				int opcaoProduto = teclado.nextInt();
				teclado.nextLine();
				
				if(opcaoProduto == 1) {
					System.out.println("----- CADASTRAR NOVO PRODUTO -----");
					System.out.println("Digite o codigo do novo Produto:");
					int novoCodigo = teclado.nextInt();
					teclado.nextLine();
					
					Produto produtoExistente = sistema.buscarProdutoPorCodigo(novoCodigo);
					if (produtoExistente != null) {
						System.out.println("Erro! Ja existe produto cadastrado com esse codigo");
					}
					else {
						System.out.println("Digite o nome do produto: ");
						String nomeProduto = teclado.nextLine();
						System.out.println("Digite o preco: R$ ");
						double preco = teclado.nextDouble();
						teclado.nextLine();
						System.out.println("Digite a quantidade em estoque: ");
						int estoque = teclado.nextInt();
						teclado.nextLine();
						
						System.out.println("Qual eh o tipo de Produto?" + "\n" +
											"1. Bebida" + "\n" +
											"2. Comida");
						System.out.println("Escolha: ");
						int tipoProduto = teclado.nextInt();
						teclado.nextLine();
						
						if(tipoProduto == 1) {
							System.out.println("Qual o tamanho? (P/M/G)");
							String tamanho = teclado.nextLine();
							System.out.println("Qual a temperatura? (Quente/Frio");
							String temperatura = teclado.nextLine();
							System.out.println("Tem quantas gramas de cafeina?");
							double cafeina = teclado.nextDouble();
							teclado.nextLine();
							
							Bebida novaBebida = new Bebida(novoCodigo, nomeProduto, tamanho, temperatura, cafeina, preco, estoque);
							sistema.cadastrarProdutos(novaBebida);
						}
						else if(tipoProduto == 2){
							System.out.println("Tem alguma restricao?");
							String restricao = teclado.nextLine();
							System.out.println("Qual o tempo de preparo em minutos?");
							int tempo = teclado.nextInt();
							teclado.nextLine();
							
							Comida novaComida = new Comida(novoCodigo, nomeProduto, preco, estoque, tempo, restricao);
							sistema.cadastrarProdutos(novaComida);
						}
						else {
							System.out.println("Tipo invalido! Cadastro cancelado.");
						}
					}
				}
				else if (opcaoProduto == 2) {
					System.out.println("----- BUSCAR PRODUTO POR CODIGO -----");
					System.out.println("Digite o codigo do Produto:");
					int codigo = teclado.nextInt();
					teclado.nextLine();
					
					Produto busca = sistema.buscarProdutoPorCodigo(codigo);
					if (busca != null) {
						System.out.println("Produto encontrado: " + busca.getNome());
					}
					else {
						System.out.println("Erro! produto nao encontrado");
					}
				}
				else if (opcaoProduto == 3) {
					System.out.println("----- ATUALIZAR PRECO DO PRODUTO -----");
					System.out.println("Digite o codigo do produto: ");
					int codigo = teclado.nextInt();
					teclado.nextLine();

					System.out.println("Digite o preco a ser atualizado: R$");
					double novoPreco = teclado.nextDouble();
					teclado.nextLine();
						
					sistema.atualizarPrecoProduto(codigo, novoPreco);
					}
				else if (opcaoProduto == 4) {
					System.out.println("----- ATUALIZAR ESTOQUE DO PRODUTO -----");
					System.out.println("Digite o codigo do produto: ");
					int codigo = teclado.nextInt();
					teclado.nextLine();

					System.out.println("Digite o novo estoque disponivel: ");
					int novoEstoque = teclado.nextInt();
					teclado.nextLine();
						
					sistema.atualizarEstoqueProduto(codigo, novoEstoque);
				}
				else if (opcaoProduto == 5) {
					System.out.println("----- REMOVER PRODUTO -----");
					System.out.println("Digite o codigo do produto: ");
					int codigo = teclado.nextInt();
					teclado.nextLine();
					
					sistema.removerProduto(codigo);
				}
				break;
			case 3:
				System.out.println("====== MENU DAS VENDAS (Pedidos) =====");
				System.out.println("1. Cadastrar novo Pedido");
				System.out.println("2. Buscar Pedido por comanda");
				System.out.println("3. Modificar Pedido");
				System.out.println("4. Fechar Conta");
				System.out.println("5. Remover Pedido");
				System.out.println("Escolha uma opcao: ");
				
				int opcaoPedido = teclado.nextInt();
				teclado.nextLine();
				
				if (opcaoPedido == 1) {
					System.out.println("----- NOVO PEDIDO -----");
					System.out.println("Cliente possui cadastro? (S/N)");
					String possuiCadastro = teclado.nextLine();
					
					Cliente clientePedido = null;
					
					if(possuiCadastro.equalsIgnoreCase("S")){
						System.out.println("Digite o CPF do cliente: ");
						String cpfCliente = teclado.nextLine();
						
						clientePedido = sistema.buscarClientePorCpf(cpfCliente);
						if (clientePedido == null) {
							System.out.println("Cliente nao encontrado! Abrindo pedido como anonimo!");
						}
					}
					else if (possuiCadastro.equalsIgnoreCase("N")) {
						System.out.println("Deseja fazer cadastro para ter acesso a beneficios? (S/N)");
						String fazerCadastro = teclado.nextLine();
						
						if (fazerCadastro.equalsIgnoreCase("S")) {
							System.out.println("Informe nome: ");
							String nomeNovo = teclado.nextLine();
							System.out.println("Informe seu cpf: ");
							String cpfNovo = teclado.nextLine();
							
							ClienteStandard novo = new ClienteStandard(nomeNovo, cpfNovo);
							sistema.cadastrarClientes(novo);
							
							clientePedido = novo;
						}
						else if (fazerCadastro.equalsIgnoreCase("N")) {
							System.out.println("Prosseguindo para venda anonima!");
							clientePedido = null;
						}
					}
					
					System.out.println("Responsavel pelo pedido: ");
					String nomeAtendente = teclado.nextLine();
					
					Pedido novaComanda = new Pedido(clientePedido, nomeAtendente);
					int opcaoItem = 0;
					
					do {
						System.out.println("Comanda: " + novaComanda.getNumeroSequencial());
						System.out.println("1. Adicionar Produtos");
						System.out.println("2. Concluir e Salvar Pedido");
						System.out.println("Escolha: ");
						
						opcaoItem = teclado.nextInt();
						teclado.nextLine();
						
						if(opcaoItem == 1) {
							sistema.exibirCardapio();
							System.out.println("Digite o codigo do Produto: ");
							int codProd = teclado.nextInt();
							teclado.nextLine();
							
							System.out.println("Digite a quantidade: ");
							int qtd = teclado.nextInt();
							teclado.nextLine();
							
							Produto produtoAdd = sistema.buscarProdutoPorCodigo(codProd);
							if(produtoAdd != null) {
								try {
									novaComanda.adicionarItem(produtoAdd, qtd);
									System.out.println(produtoAdd.getNome() + "x " + qtd + "adicionados com sucesso!");
								}catch(Exception erroPedido) {
									System.out.println("Motivo: " + erroPedido.getMessage());
								}
							}
							else {
								System.out.println("Codigo incorreto ou produto nao cadastrado!");
							}
						}
					}while (opcaoItem != 2);
					sistema.cadastrarPedido(novaComanda);
					System.out.println("Comanda " + novaComanda.getNumeroSequencial() + "salva com sucesso!");
				}
				else if (opcaoPedido == 2) {
					System.out.println("----- BUSCAR PEDIDO POR COMANDA -----");
					System.out.println("Digite o numero da comanda: ");
					int comanda = teclado.nextInt();
					teclado.nextLine();
					
					Pedido busca = sistema.buscarPedidoPorNumero(comanda);
					if(busca != null) {
						busca.exibirExtrato();
					}
					else {
						System.out.println("Nenhuma Comanda Encontrada!");
					}
				}
				else if (opcaoPedido == 3) {
					System.out.println("----- Adicionar Itens a uma comanda -----");
					System.out.println("Digite o numero da comanda: ");
					int comanda = teclado.nextInt();
					teclado.nextLine();
					
					Pedido busca = sistema.buscarPedidoPorNumero(comanda);
					if(busca != null) {
						System.out.println("Comanda nao encontrada!");
					}
					if(busca.isPago()) {
						System.out.println("Comanda ja paga, nao eh possivel alterar!");
					}
					else {
						System.out.println("1. Adicionar Item /n" +
											"2. Remover Item");
						System.out.println("Escolha: ");
						int opcaoAlt = teclado.nextInt();
						teclado.nextLine();
						
						if(opcaoAlt == 1) {
							sistema.exibirCardapio();
							System.out.println("Qual codigo do produto a ser adicionado?");
							int prodAdd = teclado.nextInt();
							teclado.nextLine();
							System.out.println("Qual a quantidade?");
							int qtdAdd = teclado.nextInt();
							teclado.nextLine();
							
							Produto adicionado = sistema.buscarProdutoPorCodigo(prodAdd);
							if(adicionado != null) {
								try {
									busca.adicionarItem(adicionado, qtdAdd);
									System.out.println("Produto Adicionado!");
								}catch(Exception erroPedido) {
									System.out.println("Motivo: " + erroPedido.getMessage());
								}
							}
						}
						else if(opcaoAlt == 2) {
							busca.exibirExtrato();
							System.out.println("Qual o codigo do produto a ser removido?");
							int remover = teclado.nextInt();
							teclado.nextLine();
							
							busca.removerItem(remover);
						}
					}
				}
				else if(opcaoPedido == 4) {
					System.out.println("----- FECHAR CONTA -----");
					System.out.println("Digite a comanda: ");
					int numComand = teclado.nextInt();
					teclado.nextLine();
					
					Pedido pedidoFechar = sistema.buscarPedidoPorNumero(numComand);
					
					if(pedidoFechar != null) {
						if(pedidoFechar.isPago()) {
							System.out.println("Erro: comanda ja paga!");
						}
						else {
							double valorTotal = pedidoFechar.calcularTotal();
							System.out.println("Resumo Comanda " + pedidoFechar.getNumeroSequencial() + ": /n" +
												"Valor total: R$" + valorTotal);
							
							Cliente clienteConta = pedidoFechar.getCliente();
							if(clienteConta instanceof ClienteVip) {
								ClienteVip vip = (ClienteVip) clienteConta;
								System.out.println("Cliente Vip detectado! Saldo Atual: " + vip.getSaldoXP() + "XP");
								System.out.println("Deseja utilizar XP para abater valor? (S/N)");
								String resposta = teclado.nextLine();
								
								if (resposta.equalsIgnoreCase("S")){
									try{
										valorTotal = vip.pagarXp(valorTotal);
										System.out.println("Desconto Aplicado! Novo valor R$: " + valorTotal);
									}catch(PontosInsuficientesException e){
										System.out.println("Atencao: " + e.getMessage());
										System.out.println("Seguindo com pagamento integral sem desconto!");
									}
								}
								System.out.println("Confirmar pagamento? (S/N)");
								String confirmaPag = teclado.nextLine();
								
								if(confirmaPag.equalsIgnoreCase("S")) {
									pedidoFechar.finalizarPagamento();
									
									if(clienteConta instanceof ClienteVip) {
										ClienteVip vipp  = (ClienteVip) clienteConta;
										vipp.calcularXp(valorTotal);
										System.out.println("Pagamento Concluido! Novos pontos de XP acumulados.");
							    	}
									else if (clienteConta instanceof ClienteStandard){
										ClienteStandard standard = (ClienteStandard) clienteConta;
										standard.calcularXp(valorTotal);
										System.out.println("Pagamento Concluido! Novos pontos de XP acumulados.");
									}
									else {
										System.out.println("Pagamento concluido, mas sem acumular cashback!");
									}
							}
							
							}	
						}
					}
				}
				else if (opcaoPedido == 5) {
					System.out.println("----- APAGAR COMANDA -----");
					System.out.println("Digite a comanda: ");
					int numComand = teclado.nextInt();
					teclado.nextLine();
					
					sistema.removerPedido(numComand);		
				}
			}
		}while (opcao != 4);
		teclado.close();
	}
}

