package br.edu.cafeteria.app;

import java.util.Scanner;

import br.edu.cafeteria.modelo.ClienteStandard;
import br.edu.cafeteria.servico.GerenciadorCafeteria;

public class CafeteriaApp {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		GerenciadorCafeteria sistema = new GerenciadorCafeteria();
		int opcao = 0;
		
		System.out.println("Bem vindo ao Sistema Byte & Brew! \n");
		do {
			System.out.println("================ MENU PRINCIPAL ===============");
			System.out.println("1. Menu dos Clientes \n");
			System.out.println("2. Menu dos Produtos \n");
			System.out.println("3. Menu de Vendas (Pedidos) \n");
			System.out.println("4. Sair do Sitema \n");
			System.out.println("Escolha uma opcao: \n");
			
			opcao = teclado.nextInt();
			teclado.nextLine();
			
			switch (opcao) {
			case 1:
				System.out.println("====== MENU DOS CLIENTES ===== \n");
				System.out.println("1. Cadastrar novo Cliente \n");
				System.out.println("2. Buscar Cliente por CPF \n");
				System.out.println("3. Atualizar nome do Cliente \n");
				System.out.println("4. Remover Cliente \n");
				System.out.println("Escolha uma opcao: ");
				
				int opcaoCliente = teclado.nextInt();
				teclado.nextLine();
				
				if (opcaoCliente == 1) {
					System.out.println("Digite o nome do cliente: ");
					String nome = teclado.nextLine();
					
					System.out.println("Digite o CPF do cliente: ");
					String cpf = teclado.nextLine();
					
					ClienteStandard novoCliente = new ClienteStandard(nome, cpf);
					sistema.cadastrarClientes(novoCliente);
					
				}
				else if (opcaoCliente == 2) {
					System.out.println("Digite o cpf do cliente:");
					String cpf = teclado.nextLine();
					
					sistema.buscarClientePorCpf(cpf);
				}
			}
			
		}while (opcao != 4);
		teclado.close();
	}
}
