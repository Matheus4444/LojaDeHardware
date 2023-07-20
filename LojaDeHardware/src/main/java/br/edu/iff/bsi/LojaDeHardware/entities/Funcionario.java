package br.edu.iff.bsi.LojaDeHardware.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Funcionario extends Pessoa{

	public Funcionario(String nome, String email, String cpf, String password) {
		super(nome, email, cpf, password);
	}

	public Funcionario() {
		
	}

}
