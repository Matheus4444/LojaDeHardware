package br.edu.iff.bsi.LojaDeHardware.entities;

import java.util.Calendar;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Compra {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private Calendar dataHora;
	private Calendar inicio;
	private Calendar termino;
	private int qntdItens;
	
	public Compra(long id, Calendar dataHora, Calendar inicio, Calendar termino, int qntdItens) {
		this.id = id;
		this.dataHora = dataHora;
		this.inicio = inicio;
		this.termino = termino;
		this.qntdItens = qntdItens;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Calendar getDataHora() {
		return dataHora;
	}

	public void setDataHora(Calendar dataHora) {
		this.dataHora = dataHora;
	}

	public Calendar getInicio() {
		return inicio;
	}

	public void setInicio(Calendar inicio) {
		this.inicio = inicio;
	}

	public Calendar getTermino() {
		return termino;
	}

	public void setTermino(Calendar termino) {
		this.termino = termino;
	}

	public int getQntdItens() {
		return qntdItens;
	}

	public void setQntdItens(int qntdItens) {
		this.qntdItens = qntdItens;
	}
}
