package br.edu.iff.bsi.LojaDeHardware.entities;

import java.io.Serializable;
import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Parte implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private float preco;
	@Enumerated(EnumType.ORDINAL)
	private TipoPecaEnum tipoPeca;
	@OneToMany(mappedBy = "parte")
	private Collection<Compra> compras;
	public Parte(String nome, float preco, TipoPecaEnum tipoPeca) {
		this.nome = nome;
		this.preco = preco;
		this.tipoPeca = tipoPeca;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	public TipoPecaEnum getTipoPeca() {
		return tipoPeca;
	}
	public void setTipoPeca(TipoPecaEnum tipoPeca) {
		this.tipoPeca = tipoPeca;
	}
	public Collection<Compra> getCompras() {
		return compras;
	}
	public void setCompras(Collection<Compra> compras) {
		this.compras = compras;
	}
	public Long getId() {
		return id;
	}
	
}
