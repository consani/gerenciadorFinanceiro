package br.com.impacta.finimpacta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.impacta.finimpacta.model.Usuario;
import br.com.impacta.finimpacta.util.FinancaUtil;

public class UserDAO extends BaseDAO {

	/**
	 * Registra o usuário numa base de dados
	 * 
	 * @param user Usuário a ser cadastrado na base de dados
	 * @throws Exception 
	 */
	public void registrar(Usuario user) throws Exception {
		
		Connection con = getConnection();
		
		String sql = FinancaUtil.get("sqlRegistroUsuario");
		PreparedStatement stmt = con.prepareStatement(sql);
		
		stmt.setString(1, user.getNome());
		stmt.setString(2, user.getLogin());
		stmt.setString(3, user.getSenha());
		stmt.setDouble(4, user.getConta().getSaldo());
		
		stmt.execute();
		
		closeConnection(con);
		
	}
	
	/**
	 * Registra o usuário numa base de dados
	 * 
	 * @param user Usuário a ser cadastrado na base de dados
	 * @throws Exception 
	 */
	public boolean existeUsuario(String login) throws Exception {
		
		Connection con = getConnection();
		
		String sql = FinancaUtil.get("sqlVerificaLogin");
		PreparedStatement stmt = con.prepareStatement(sql);
		
		stmt.setString(1, login);

		ResultSet result = stmt.executeQuery();
		
		closeConnection(con);
		
		return result.next();
		
	}

	public Usuario getUsuario(String login, String senha) throws Exception {
		Connection con = getConnection();
		Usuario usuario = null;
		
		String sql = FinancaUtil.get("sqlGetUsuario");
		PreparedStatement stmt = con.prepareStatement(sql);
		
		stmt.setString(1, login);
		stmt.setString(2, senha);

		ResultSet result = stmt.executeQuery();
		
		if(result.next()){
			
			String nome = result.getString("nome");
			double saldo = result.getDouble("saldo");
			usuario = new Usuario(nome,login,senha,saldo); 
		}
		
		closeConnection(con);
		
		return usuario;
		
		

	}

}
