package br.com.impacta.finimpacta.model;

public class Conta {
	
	private double saldo;

	public Conta(double saldo) {
		this.saldo = saldo;
	}

	public double getSaldo() {
		return saldo;
	}
	
	public void creditar(double valor){
		if(valor < 0){
			throw new IllegalArgumentException("valor deve ser positivo!");
		}
		this.saldo += valor;
	}
	
	public void debitar(double valor){
		if(valor < 0){
			throw new IllegalArgumentException("valor deve ser positivo!");
		}
		this.saldo -= valor;
	}

}
