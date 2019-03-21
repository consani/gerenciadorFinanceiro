package br.com.impacta.finimpacta.controller;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.List;

import br.com.impacta.finimpacta.dao.FinancaDAO;
import br.com.impacta.finimpacta.model.Credito;
import br.com.impacta.finimpacta.model.Debito;
import br.com.impacta.finimpacta.model.TipoCredito;
import br.com.impacta.finimpacta.model.TipoDespesa;

public class FinancaController {
	
	/**
	 * Cria um novo cr�dito na conta, aumentando o saldo a ela vinculado
	 * 
	 * @param valor Valor a ser creditado na conta
	 * @param data Data de ocorr�ncia do cr�dito
	 * @param tipo Tipo de cr�dito efetuado
	 * @param descricao Descricao do credito
	 * 
	 * @throws Exception Caso ocorra inconsist�ncia nos dados ou problemas de infra 
	 */
	public void criarNovoCredito(double valor, LocalDate data, String descricao, TipoCredito tipo) throws Exception{
		FinancaDAO dao = new FinancaDAO();
		String login = UserController.getUsuarioLogado();
		Credito credito = new Credito(valor,data,descricao,tipo);
		dao.registrar(credito,login);
	}
	
	
	/**
	 * Cria um novo d�bito na conta diminuindo o saldo a ela vinculado
	 * 
	 * @param valor Valor do d�bito
	 * @param data data de ocorr�ncia do d�bito
	 * @param tipo Tipo de despesa ocorrida
	 * @param descricao Descricao da despesa
	 * 
	 * @throws Exception Caso ocorra inconsist�ncia nos dados ou problemas de infra 
	 */
	public void criarNovoDebito(double valor, LocalDate data, String descricao, TipoDespesa tipo) throws Exception{
		FinancaDAO dao = new FinancaDAO();
		String login = UserController.getUsuarioLogado();
		Debito debito = new Debito(valor,data,descricao,tipo);
		dao.registrar(debito,login);
	}
	
	/**
	 * Lista todos os d�bitos dentro do m�s corrente
	 * 
	 * @return Lista de d�bitos ocorridos no m�s corrente
	 * @throws Exception Se alguma inconsist�ncia ocorrer ou falha de infra
	 */
	public List<Debito> listarDebitos() throws Exception{
		FinancaDAO dao = new FinancaDAO();
		
		LocalDate dataInicial = LocalDate.now().with(TemporalAdjusters.firstDayOfMonth());
		LocalDate dataFinal = LocalDate.now().with(TemporalAdjusters.lastDayOfMonth());
		
		String login = UserController.getUsuarioLogado();
		List<Debito> debitos = dao.listarDebitos(dataInicial,dataFinal,null,login);
		
		return debitos;
	}
	
	/**
	 * Lista todos os d�bitos que atendam ao filtro informado
	 * 
	 * @param dataInicial Limite inferior de data do d�bito (inclusive)
	 * @param dataFinal Limite superior de data de d�bito (inclusive)
	 * @param tipo Tipo de despesa a ser filtrada
	 * 
	 * @return Lista de d�bitos ocorridos de acordo com o filtro informado
	 * @throws Exception Se alguma inconsist�ncia ocorrer ou falha de infra 
	 */
	public List<Debito> listarDebitos(LocalDate dataInicial, LocalDate dataFinal, TipoDespesa tipo) throws Exception{
		FinancaDAO dao = new FinancaDAO();
		String login = UserController.getUsuarioLogado();
		List<Debito> debitos = dao.listarDebitos(dataInicial,dataFinal,tipo.toString(),login);
		
		return debitos;
	}
	
	

}
