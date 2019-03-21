package br.com.impacta.finimpacta.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import br.com.impacta.finimpacta.util.FinancaUtil;

public abstract class BaseDAO {

	void closeConnection(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	Connection getConnection() throws Exception  {
		String usuarioBD = FinancaUtil.get("usuarioBD");
		String senhaBD = FinancaUtil.get("senhaBD");
		String urlBD = FinancaUtil.get("urlBD");
		
		Connection conexao = null;
		try {
			conexao = DriverManager.getConnection(urlBD,usuarioBD,senhaBD);
		} catch (SQLException e) {
			throw new Exception(e);
		}
		
		return conexao;
		
	}
	

	
}
