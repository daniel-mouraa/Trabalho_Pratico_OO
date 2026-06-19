package br.edu.cafeteria.modelo;

public class ClienteStandard extends Cliente {

	public ClienteStandard(String nome, String cpf) {
		super(nome, cpf);
	}
	
	public double calcularXp(double valorGasto) {
		double pontos = valorGasto * 1.0;
		return pontos;
	}

}