package br.com.impacta.finimpacta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.impacta.finimpacta.model.Debito;
import br.com.impacta.finimpacta.model.Lancamento;
import br.com.impacta.finimpacta.model.TipoDespesa;
import br.com.impacta.finimpacta.util.FinancaUtil;

public class FinancaDAO extends BaseDAO {

	public void registrar(Lancamento lancamento, String login) throws Exception {

		Connection con = getConnection();

		String sql = FinancaUtil.get("sqlRegistroLancamento");
		PreparedStatement stmt = con.prepareStatement(sql);

		stmt.setDouble(1, lancamento.getValor());
		stmt.setString(2, lancamento.getData().toString());
		stmt.setString(3, lancamento.getTipo().toString());
		stmt.setString(4, lancamento.getDescricao());
		
		if(lancamento instanceof Debito){
			stmt.setBoolean(5, true);
		}else{
			stmt.setBoolean(5, false);
		}
		
		stmt.setString(6, login);

		stmt.execute();

		closeConnection(con);

	}

	
	public List<Debito> listarDebitos(LocalDate dataInicial, LocalDate dataFinal, String tipo, String login) throws Exception {
		Connection con = getConnection();
		List<Debito> debitos = new ArrayList<>();

		String sql = (tipo == null) ? FinancaUtil.get("sqlDebitosFiltro") : FinancaUtil.get("sqlDebitosFiltroTipo") ;
		
		PreparedStatement stmt = con.prepareStatement(sql);

		stmt.setBoolean(1, true);
		stmt.setString(2, dataInicial.toString());
		stmt.setString(3, dataFinal.toString());
		
		if(tipo != null){
			stmt.setString(4, tipo);	
		}
		
		stmt.setString(5, login);
		

		ResultSet result = stmt.executeQuery();
		while (result.next()) {
			double valor = result.getDouble("valor");
			LocalDate data = FinancaUtil.parseDate(result.getString("data"));
			String descricao = result.getString("descricao");
			TipoDespesa tipoDespesa = TipoDespesa.valueOf(result.getString("tipo"));

			Debito deb = new Debito(valor, data, descricao, tipoDespesa);
			debitos.add(deb);
		}
		
		closeConnection(con);
		
		return debitos;
	}
}
