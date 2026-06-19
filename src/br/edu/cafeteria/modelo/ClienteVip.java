package br.edu.cafeteria.modelo;

public class ClienteVip extends Cliente {

	public ClienteVip(String nome, String cpf) {
		super(nome, cpf);
	}
	
	public double calcularXp(double valorGasto) {
		double pontos = valorGasto * 2.0;
		return pontos;
	}

}
