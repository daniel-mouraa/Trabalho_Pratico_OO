package br.edu.cafeteria.modelo;

public abstract class Cliente {
	private String nome, cpf;
	protected double saldoXP;
	private static final double Taxa_Real_Xp = 1.0;
	
	public Cliente (String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
		this.saldoXP = 0.0;
	}
	
	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getSaldoXP() {
		return saldoXP;
	}

	public static double getTaxaRealXp() {
		return Taxa_Real_Xp;
	}

	public abstract double calcularXp(double valorGasto);
}