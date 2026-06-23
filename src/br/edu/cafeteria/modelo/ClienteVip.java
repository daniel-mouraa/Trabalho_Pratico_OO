package br.edu.cafeteria.modelo;

import br.edu.cafeteria.excecao.PontosInsuficientesException;

public class ClienteVip extends Cliente {
	private static final double taxa_vip = 2.0;
	public ClienteVip(String nome, String cpf) {
		super(nome, cpf);
	}
	
	public double calcularXp(double valorGasto) {
		double pontos = valorGasto * taxa_vip;
		this.saldoXP += pontos;
		return pontos;
	}
	
	public double pagarXp(double valorGasto) throws PontosInsuficientesException {
		if (this.getSaldoXP() <= 0) {
			throw new PontosInsuficientesException("Cliente nao possui XP suficiente para abater!");
		}
		double valorConvertido = this.getSaldoXP() / 10.0;
		if (valorConvertido >= valorGasto) {
			int xpGasto = (int)(valorGasto * 10);
			this.saldoXP -= xpGasto;
			
			System.out.println("Pagamento Integral feito com pontos!");
			return 0.0;
		}else {
			double novoValor = valorGasto - valorConvertido;
			this.saldoXP = 0;
			
			System.out.println("Desconto aplicado! Desconto total de R$ " + valorConvertido);
			return novoValor;
		}
	}
	

}
