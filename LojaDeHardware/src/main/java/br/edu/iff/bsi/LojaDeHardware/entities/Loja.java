package br.edu.iff.bsi.LojaDeHardware.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Loja {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String nome;
	private String cnpj;
	private Endereco endereco;
	private Telefone telefone;
	private Parte parte;
	
	public Loja(long id, String nome, String cnpj, Endereco endereco, Telefone telefone, Parte parte) {
		this.id = id;
		this.nome = nome;
		this.cnpj = cnpj;
		this.endereco = endereco;
		this.telefone = telefone;
		this.parte = parte;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	public Parte getParte() {
		return parte;
	}

	public void setParte(Parte parte) {
		this.parte = parte;
	}
	
	
}
