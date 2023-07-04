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

	
}
