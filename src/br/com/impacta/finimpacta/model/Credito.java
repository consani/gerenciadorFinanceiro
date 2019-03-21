package br.com.impacta.finimpacta.model;

import java.time.LocalDate;

public class Credito extends Lancamento{
	
	private TipoCredito tipo;
	
	public Credito(double valor, LocalDate data, String descricao, TipoCredito tipo) {
		super(valor,data,descricao);
		this.tipo = tipo;
	}

	public TipoCredito getTipo() {
		return tipo;
	}

}
