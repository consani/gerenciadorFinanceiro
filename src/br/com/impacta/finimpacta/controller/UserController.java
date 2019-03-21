package br.com.impacta.finimpacta.controller;

import br.com.impacta.finimpacta.dao.UserDAO;
import br.com.impacta.finimpacta.model.Usuario;

public class UserController {
	
	private static Usuario usuarioLogado;  
	
	/**
	 * Cria um novo usu�rio no sistema vinculado � sua conta pessoal
	 * 
	 * @param user Usu�rio a ser cadastrado
	 * 
	 * @throws Exception Se usu�rio j� existir com mesmo login ou falha na infra
	 */
	public void criar(Usuario user) throws Exception{
		UserDAO dao = new UserDAO();
		
		if(!dao.existeUsuario(user.getLogin())){
			dao.registrar(user);	
		}else{
			throw new IllegalArgumentException("Login j� registrado para outro usu�rio!");
		}
	}
	
	
	public void realizarLogin(String login, String senha) throws Exception{
		UserDAO dao = new UserDAO();
		
		usuarioLogado = dao.getUsuario(login,senha);
		
		if(usuarioLogado == null){
			throw new IllegalArgumentException("login e/ou senha inv�lido(a)!");
		}
		
	}


	public static String getUsuarioLogado() {
		return UserController.getUsuarioLogado();
	}
	

}
