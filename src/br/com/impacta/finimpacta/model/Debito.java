package br.com.impacta.finimpacta.model;

import java.time.LocalDate;

public class Debito extends Lancamento{

	private TipoDespesa tipo;
	
	public Debito(double valor, LocalDate data, String descricao, TipoDespesa tipo) {
		super(valor,data,descricao);
		this.setTipo(tipo);
	}

	public TipoDespesa getTipo() {
		return tipo;
	}

	public void setTipo(TipoDespesa tipo) {
		this.tipo = tipo;
	}


}
