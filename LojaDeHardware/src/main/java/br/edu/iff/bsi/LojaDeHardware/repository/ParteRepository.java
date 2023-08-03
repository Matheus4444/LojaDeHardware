package br.edu.iff.bsi.LojaDeHardware.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.iff.bsi.LojaDeHardware.entities.Parte;

@Repository
public interface ParteRepository extends JpaRepository<Parte, Long> {

}
