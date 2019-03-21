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
	 * Cria um novo crédito na conta, aumentando o saldo a ela vinculado
	 * 
	 * @param valor Valor a ser creditado na conta
	 * @param data Data de ocorrência do crédito
	 * @param tipo Tipo de crédito efetuado
	 * @param descricao Descricao do credito
	 * 
	 * @throws Exception Caso ocorra inconsistência nos dados ou problemas de infra 
	 */
	public void criarNovoCredito(double valor, LocalDate data, String descricao, TipoCredito tipo) throws Exception{
		FinancaDAO dao = new FinancaDAO();
		String login = UserController.getUsuarioLogado();
		Credito credito = new Credito(valor,data,descricao,tipo);
		dao.registrar(credito,login);
	}
	
	
	/**
	 * Cria um novo débito na conta diminuindo o saldo a ela vinculado
	 * 
	 * @param valor Valor do débito
	 * @param data data de ocorrência do débito
	 * @param tipo Tipo de despesa ocorrida
	 * @param descricao Descricao da despesa
	 * 
	 * @throws Exception Caso ocorra inconsistência nos dados ou problemas de infra 
	 */
	public void criarNovoDebito(double valor, LocalDate data, String descricao, TipoDespesa tipo) throws Exception{
		FinancaDAO dao = new FinancaDAO();
		String login = UserController.getUsuarioLogado();
		Debito debito = new Debito(valor,data,descricao,tipo);
		dao.registrar(debito,login);
	}
	
	/**
	 * Lista todos os débitos dentro do mês corrente
	 * 
	 * @return Lista de débitos ocorridos no mês corrente
	 * @throws Exception Se alguma inconsistência ocorrer ou falha de infra
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
	 * Lista todos os débitos que atendam ao filtro informado
	 * 
	 * @param dataInicial Limite inferior de data do débito (inclusive)
	 * @param dataFinal Limite superior de data de débito (inclusive)
	 * @param tipo Tipo de despesa a ser filtrada
	 * 
	 * @return Lista de débitos ocorridos de acordo com o filtro informado
	 * @throws Exception Se alguma inconsistência ocorrer ou falha de infra 
	 */
	public List<Debito> listarDebitos(LocalDate dataInicial, LocalDate dataFinal, TipoDespesa tipo) throws Exception{
		FinancaDAO dao = new FinancaDAO();
		String login = UserController.getUsuarioLogado();
		List<Debito> debitos = dao.listarDebitos(dataInicial,dataFinal,tipo.toString(),login);
		
		return debitos;
	}
	
	

}
