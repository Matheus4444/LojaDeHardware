package br.edu.iff.bsi.LojaDeHardware.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Compra implements Serializable{
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Temporal(TemporalType.TIMESTAMP)
	private Calendar dataHora;
	private int qtdPartes;
	private double precoFinal;
	private boolean finalizado;
	private String cpfCliente;
	
	@ManyToMany
	@JoinTable(name = "associacao_compra_parte",
				joinColumns = @JoinColumn(name = "id_compra"),
				inverseJoinColumns = @JoinColumn(name = "id_parte"))
	private List<Parte> parte;

	public Compra(String cpfCliente) {
		this.finalizado = false;
		this.qtdPartes = 0;
		this.parte = new ArrayList();
		this.cpfCliente = cpfCliente;
		this.dataHora = Calendar.getInstance();
	}
	public Compra() {
		
	}
	
	
	public Long getId() {
		return id;
	}

	public Calendar getDataHora() {
		return dataHora;
	}

	public int getQtdPartes() {
		return qtdPartes;
	}

	public double getPrecoFinal() {
		return precoFinal;
	}
	
	public String getCpfCliente() {
		return cpfCliente;
	}

	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}
	
	public void adicionarParte(Parte Parte) {
		this.parte.add(Parte);
		this.qtdPartes++;
		this.precoFinal+=Parte.getPreco();
	}
	
	public void removerParte(Parte Parte) {
		this.parte.remove(Parte);
		this.qtdPartes--;
		this.precoFinal-=Parte.getPreco();
	}
	
	public void finalizar() {
		this.finalizado = true;
		this.dataHora = Calendar.getInstance();
	}
	
	public boolean isFinalizado() {
		return this.finalizado;
	}
}