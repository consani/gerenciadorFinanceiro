package br.com.impacta.finimpacta.model;

import java.time.LocalDate;

public abstract class Lancamento {
	
	private double valor;
	private LocalDate data;
	private String descricao;

	public Lancamento(double valor, LocalDate data, String descricao) {
		this.setValor(valor);
		this.setData(data);
		this.setDescricao(descricao);
	}
	
	public abstract TipoLancamento getTipo();
	
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
