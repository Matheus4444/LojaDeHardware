package br.edu.iff.bsi.LojaDeHardware.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import br.edu.iff.bsi.LojaDeHardware.entities.Carteira;
import br.edu.iff.bsi.LojaDeHardware.entities.Compra;
import br.edu.iff.bsi.LojaDeHardware.entities.Endereco;
import jakarta.annotation.Nullable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
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
	@Nullable
	@ElementCollection
	@Column(length = 16)
	private List<String> telefone = new ArrayList<String>();
	@OneToMany
	@JoinColumn(name = "ID_CLIENTE")
	private List<Compra> compra;

	public Cliente(String nome, String email, String cpf, String password, Endereco endereco,
			String telefone) {
		super(nome, email, cpf, password);
		this.endereco = endereco;
		this.carteira = new Carteira();
		this.telefone.add(telefone);
		this.compra = new ArrayList();
	}

	public Cliente() {

	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public void setCarteira(Carteira carteira) {
		this.carteira = carteira;
	}

	public double verSaldo() {
		return this.carteira.getSaldoDisponivel();
	}

	public void adicionarCompra(Compra compra) {
		this.compra.add(compra);
	}

	public void removerCompra(Compra compra) {
		this.compra.remove(compra);
	}

	public void adicionarSaldo(double saldo) {
		this.carteira.setSaldoDisponivel(this.carteira.getSaldoDisponivel() + saldo);
	}

	public void removerSaldo(double saldo) {
		double retirada = this.carteira.getSaldoDisponivel() - saldo;
		if (retirada >= 0) {
			this.carteira.setSaldoDisponivel(retirada);
		}
	}

	public void setTelefone(String telefone) {
		this.telefone.add(telefone);
	}

	public List<String> getTelefone() {
		return telefone;
	}


	public void setTelefone(List<String> telefone) {
		this.telefone = telefone;
	}


	public void removerTelefone(String telefone) {
		this.telefone.remove(telefone);
	}

	public int getQtdTelefones() {
		return this.telefone.size();
	}
}