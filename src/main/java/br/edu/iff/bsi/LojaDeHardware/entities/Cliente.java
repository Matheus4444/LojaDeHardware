package br.edu.iff.bsi.LojaDeHardware.entities;

import java.util.ArrayList;
import java.util.Collection;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Cliente extends Pessoa {
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_ENDERECO", referencedColumnName = "ID", nullable = false)
	private Endereco endereco;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_CARTEIRA", referencedColumnName = "ID", nullable = false)
	private Carteira carteira;
	@ElementCollection
	private Collection<String> telefones;
	@OneToMany(mappedBy = "cliente")
	private Collection<Compra> compras;

	public Cliente(String nome, String email, String cpf, String password, Endereco endereco, Carteira carteira,
			String telefone) {
		super(nome, email, cpf, password);
		this.endereco = endereco;
		this.carteira = carteira;
		this.telefones = new ArrayList<>();
		this.telefones.add(telefone);
	}

	public Cliente() {

	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Carteira getCarteira() {
		return carteira;
	}

	public void setCarteira(Carteira carteira) {
		this.carteira = carteira;
	}

	public Collection<String> getTelefones() {
		return telefones;
	}

	public void setTelefones(Collection<String> telefones) {
		this.telefones = telefones;
	}
}