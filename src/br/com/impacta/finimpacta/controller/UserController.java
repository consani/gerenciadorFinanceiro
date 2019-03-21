package br.com.impacta.finimpacta.controller;

import br.com.impacta.finimpacta.dao.UserDAO;
import br.com.impacta.finimpacta.model.Usuario;

public class UserController {
	
	private static Usuario usuarioLogado;  
	
	/**
	 * Cria um novo usuário no sistema vinculado à sua conta pessoal
	 * 
	 * @param user Usuário a ser cadastrado
	 * 
	 * @throws Exception Se usuário já existir com mesmo login ou falha na infra
	 */
	public void criar(Usuario user) throws Exception{
		UserDAO dao = new UserDAO();
		
		if(!dao.existeUsuario(user.getLogin())){
			dao.registrar(user);	
		}else{
			throw new IllegalArgumentException("Login já registrado para outro usuário!");
		}
	}
	
	
	public void realizarLogin(String login, String senha) throws Exception{
		UserDAO dao = new UserDAO();
		
		usuarioLogado = dao.getUsuario(login,senha);
		
		if(usuarioLogado == null){
			throw new IllegalArgumentException("login e/ou senha inválido(a)!");
		}
		
	}


	public static String getUsuarioLogado() {
		return UserController.getUsuarioLogado();
	}
	

}
