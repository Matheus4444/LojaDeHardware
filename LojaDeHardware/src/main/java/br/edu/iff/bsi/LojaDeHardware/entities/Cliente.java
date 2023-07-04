package br.edu.iff.bsi.LojaDeHardware.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cliente {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
}
