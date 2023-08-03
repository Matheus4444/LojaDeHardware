package br.edu.iff.bsi.LojaDeHardware.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.iff.bsi.LojaDeHardware.entities.Loja;

@Repository
public interface LojaRepository extends JpaRepository<Loja, Long> {

}
