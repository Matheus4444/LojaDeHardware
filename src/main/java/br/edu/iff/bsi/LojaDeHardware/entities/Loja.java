package br.edu.iff.bsi.LojaDeHardware.entities;

import java.io.Serializable;
import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Loja implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private static final String nome = "Loja De Hardware";
	@Column(nullable = false)
	private static final String cnpj = "29.235.567/0001-17";
	@OneToOne
	private static final Endereco endereco = new Endereco("Rua das pavorosas", 69, "Parque Dom Juan",
			"Campos dos Goytacazes", "RJ", "27189-528");
	@ElementCollection
	@OneToMany
	private Collection<Parte> parte;

	public Loja() {
	}

	public Long getId() {
		return id;
	}

	public static String getNome() {
		return nome;
	}

	public static String getCnpj() {
		return cnpj;
	}

	public static Endereco getEndereco() {
		return endereco;
	}	
	
}
