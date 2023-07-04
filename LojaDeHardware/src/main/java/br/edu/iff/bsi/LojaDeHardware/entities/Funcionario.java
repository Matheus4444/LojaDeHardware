package br.edu.iff.bsi.LojaDeHardware.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Funcionario extends Pessoa{
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String login;

	public Funcionario(String nome, String email, String cpf, String password, Telefone telefone, String login, Endereco endereco) {
		super(nome, email, cpf, password, telefone, endereco);
		this.login = login;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
}
