package br.com.impacta.finimpacta.model;

public class Usuario {

	private String nome;
	private String login;
	private String senha;
	private Conta conta;

	public Usuario(String nome, String login, String senha, double saldo) {
		this.nome = nome;
		this.login = login;
		this.senha = senha;
		this.conta = new Conta(saldo);
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Conta getConta() {
		return conta;
	}

}
