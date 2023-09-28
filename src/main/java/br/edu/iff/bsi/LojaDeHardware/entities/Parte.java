	package br.edu.iff.bsi.LojaDeHardware.entities;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Parte implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private double preco;
	@Column(unique=true)
	private String nome;
	private String tipoParte;

	@ManyToMany(mappedBy="parte")
	private List<Compra> compra;
	
	public Parte(double preco, String nome, String tipoParte) {
		super();
		this.preco = preco;
		this.nome = nome;
		this.tipoParte = tipoParte;
	}

	public Parte() {}
	
	public Long getId() {
		return id;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipoParte() {
		return tipoParte;
	}

	public void setTipoParte(String tipoParte) {
		this.tipoParte = tipoParte;
	}
	
}
