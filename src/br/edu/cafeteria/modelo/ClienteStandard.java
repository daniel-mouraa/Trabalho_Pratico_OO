package br.edu.cafeteria.modelo;

public class ClienteStandard extends Cliente {
	private static final double taxa_standard = 1.0;
	public ClienteStandard(String nome, String cpf) {
		super(nome, cpf);
	}
	
	public double calcularXp(double valorGasto) {
		double pontos = valorGasto * taxa_standard;
		this.saldoXP += pontos;
		return pontos;	
	}

}